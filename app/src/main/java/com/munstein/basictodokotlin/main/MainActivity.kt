package com.munstein.basictodokotlin.main

import android.os.Bundle
import com.munstein.basictodokotlin.R
import com.munstein.basictodokotlin.base.BaseActivity
import com.munstein.basictodokotlin.data.NitriteDataAccess
import com.munstein.basictodokotlin.model.Task
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainMVP.view {

    private lateinit var adapter : CustomAdapter
    private lateinit var presenter : MainMVP.presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this, MainModel(NitriteDataAccess(this.filesDir)))

        var adapter = CustomAdapter(this, presenter.getTasks())

        main_listview.adapter = adapter

    }

    override fun updateView() {

    }

    override fun showMessage(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
