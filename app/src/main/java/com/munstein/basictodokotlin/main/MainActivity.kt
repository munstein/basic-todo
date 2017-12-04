package com.munstein.basictodokotlin.main

import android.app.PendingIntent.getActivity
import android.os.Bundle
import android.view.*
import android.widget.ListView
import android.widget.Toast
import com.munstein.basictodokotlin.R
import com.munstein.basictodokotlin.base.BaseActivity
import com.munstein.basictodokotlin.data.NitriteDataAccess
import com.munstein.basictodokotlin.model.Task
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.AdapterView


class MainActivity : BaseActivity(), MainMVP.view, View.OnClickListener {

    private lateinit var adapter : CustomAdapter
    private lateinit var presenter : MainMVP.presenter
    private lateinit var tasks : List<Task>
    private val ctxMenuId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.window.setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        presenter = MainPresenter(this, MainModel(NitriteDataAccess(this.filesDir)))
        tasks = presenter.getTasks()

        main_btn_add.setOnClickListener(this)

        buildListview()
    }

    private fun buildListview(){
        adapter = CustomAdapter(this, this.tasks)
        registerForContextMenu(main_listview)
        main_listview.adapter = this.adapter
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
                presenter.onRemoveTask(tasks.get(position));
        }
        return super.onContextItemSelected(item)
    }

    override fun updateView(tasks : List<Task>) {
        this.tasks = tasks
        main_edit_task.text.clear()
        buildListview()
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun onClick(view: View?) {
        presenter.onAddTask(Task(main_edit_task.text.toString(), false))
    }


}
