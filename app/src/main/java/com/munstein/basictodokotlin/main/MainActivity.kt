package com.munstein.basictodokotlin.main

import android.os.Bundle
import com.munstein.basictodokotlin.R
import com.munstein.basictodokotlin.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
