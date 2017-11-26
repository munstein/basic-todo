package com.munstein.basictodokotlin.main

import android.os.Bundle
import com.munstein.basictodokotlin.R
import com.munstein.basictodokotlin.base.BaseActivity

class MainActivity : BaseActivity(), MainMVP.view {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun updateView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMessage(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
