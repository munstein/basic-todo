package com.munstein.basictodokotlin.main

import com.munstein.basictodokotlin.model.Task

/**
 * Created by @Munstein on 24/11/2017. --02:34
 */

interface MainMVP {

    interface model{
        fun saveTask(task : Task) : Boolean
        fun removeTask(task : Task)
        fun getTasks() : List<Task>
        fun favorite(task : Task)
        fun unfavorite(task : Task)
    }

    interface view{
        fun updateView(tasks : List<Task>)
        fun showMessage(msg : String)
    }

    interface presenter{
        fun favoriteTask(task: Task)
        fun unfavoriteTask(task: Task)
        fun addTask(task : Task)
        fun removeTask(task : Task)
        fun getTasks() : List<Task>
    }

}