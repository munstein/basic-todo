package com.munstein.basictodokotlin.main

import com.munstein.basictodokotlin.model.Task

/**
 * Created by @Munstein on 24/11/2017. --02:34
 */
interface MainMVP {

    interface model{
        fun saveTask(task : Task)
        fun unfavorite(task : Task)
        fun removeTask(task : Task)
        fun getTasks(task : Task) : List<Task>
    }

    interface view{
        fun updateView()
        fun showMessage(msg : String)
    }

    interface presenter{
        fun setFavorite()
        fun addTask()
        fun removeTask()
    }

}