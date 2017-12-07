package com.munstein.basictodokotlin.main

import com.munstein.basictodokotlin.model.Task

/**
 * Created by @Munstein on 26/11/2017. --18:18
 */
class MainPresenter : MainMVP.presenter {

    private var view: MainMVP.view

    private var model: MainMVP.model

    constructor(view : MainMVP.view, model: MainMVP.model){
        this.view = view
        this.model = model
    }

    override fun changeFavoriteStatus(task: Task) {
        model.changeFavoriteStatus(task)
        view.updateView(model.getTasks())
    }

    override fun addTask(task: Task) {
        if(task.description.isNotEmpty()){
            if(model.saveTask(task)){
                view.updateView(model.getTasks())
            }else{
                view.showMessage("this task already exists")
            }

        }else{
            view.showMessage("Please, type a task.")
        }
    }

    override fun removeTask(task: Task) {
        model.removeTask(task)
        view.updateView(model.getTasks())
    }

    override fun getTasks(): List<Task> {
        return model.getTasks()
    }

}