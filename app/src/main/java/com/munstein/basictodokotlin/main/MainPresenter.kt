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

    override fun onSetFavorite() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onUnfavorite() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAddTask() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRemoveTask() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTasks(): List<Task> {
        return model.getTasks()
    }


}