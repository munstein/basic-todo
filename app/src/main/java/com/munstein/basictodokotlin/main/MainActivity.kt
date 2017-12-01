package com.munstein.basictodokotlin.main

import android.os.Bundle
import com.munstein.basictodokotlin.R
import com.munstein.basictodokotlin.base.BaseActivity
import com.munstein.basictodokotlin.model.Task
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainMVP.view {

    private lateinit var adapter : CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var task = Task("Fine", true)
        var taskList = ArrayList<Task>()
        taskList.add(task)

        var adapter = CustomAdapter(this, taskList)

        main_listview.adapter = adapter

    }

    override fun updateView() {

    }

    override fun showMessage(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
