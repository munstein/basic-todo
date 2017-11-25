package com.munstein.basictodokotlin.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.munstein.basictodokotlin.R
import com.munstein.basictodokotlin.data.DataAccess

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var db = DataAccess()
        db.test()

    }
}
