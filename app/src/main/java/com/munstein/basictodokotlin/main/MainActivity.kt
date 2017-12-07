package com.munstein.basictodokotlin.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.CompoundButton
import android.widget.Toast
import com.munstein.basictodokotlin.R
import com.munstein.basictodokotlin.base.BaseActivity
import com.munstein.basictodokotlin.data.NitriteDataAccess
import com.munstein.basictodokotlin.model.Task
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), MainMVP.view, View.OnClickListener {

    private lateinit var adapter : CustomAdapter
    private lateinit var presenter : MainMVP.presenter
    private var tasks = ArrayList<Task>()
    private val ctxMenuId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.window.setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        presenter = MainPresenter(this, MainModel(NitriteDataAccess(this.filesDir)))
        this.tasks = presenter.getTasks() as ArrayList<Task>
        main_imgbtn_add.setOnClickListener(this)
        buildListview()
    }

    private fun buildListview(){
        adapter = CustomAdapter(this, tasks, CompoundButton.OnCheckedChangeListener {
            view, checked ->
            var task = this.tasks[view.tag as Int]
            task.isFavorite = checked
            presenter.changeFavoriteStatus(task)
        })

        registerForContextMenu(main_listview)
        main_listview.adapter = adapter
        main_listview.setOnCreateContextMenuListener { contextMenu, view, contextMenuInfo ->
            contextMenu.setHeaderTitle("action")
            contextMenu.add(Menu.NONE, ctxMenuId, Menu.NONE, "delete")
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        val menuInfo = item!!.getMenuInfo() as AdapterView.AdapterContextMenuInfo
        val position = menuInfo.position
        when (item!!.getItemId()) {
            ctxMenuId->
                presenter.removeTask(tasks.get(position));
        }
        return super.onContextItemSelected(item)
    }

    override fun updateView(tasks : List<Task>) {
        this.tasks.clear()
        this.tasks.addAll(tasks)
        adapter.notifyDataSetChanged()
        main_edit_task.text.clear()
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun onClick(view: View?) {
        presenter.addTask(Task(main_edit_task.text.toString(), false))
    }

}
