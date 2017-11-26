package com.munstein.basictodokotlin.base

import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by @Munstein on 25/11/2017. --23:31
 */
open class BaseActivity : AppCompatActivity() {

    fun showToast(msg : String){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

}