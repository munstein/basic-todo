package com.munstein.basictodokotlin.main

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.munstein.basictodokotlin.data.NitriteDataAccess
import com.munstein.basictodokotlin.model.Task
import org.dizitart.no2.Cursor
import org.dizitart.no2.Document
import org.dizitart.no2.filters.Filters
import org.dizitart.no2.filters.Filters.eq
import org.dizitart.no2.mapper.JacksonMapper
import org.dizitart.no2.mapper.NitriteMapper

/**
 * Created by @Munstein on 26/11/2017. --21:46
 */
class MainModel : MainMVP.model {

    private var dataAccess : NitriteDataAccess
    private var gson : Gson
    private var nitriteMapper : NitriteMapper

    constructor(dataAccess: NitriteDataAccess){
        this.dataAccess = dataAccess
        gson = Gson()
        nitriteMapper = JacksonMapper()
    }

    override fun saveTask(task: Task) {
        var doc = nitriteMapper.parse(gson.toJson(task))
        var x = doc.id
        dataAccess.tasksCollection.insert(doc)
    }

    override fun removeTask(task: Task) {
        var result = dataAccess.tasksCollection.find(eq("description", task.description))
        dataAccess.tasksCollection.remove(result.firstOrDefault())
    }

    override fun unfavorite(task: Task) {
        dataAccess.tasksCollection.update(eq("description", task.description),
                Document.createDocument("isFavorite", false))
    }

    override fun favorite(task: Task) {
        dataAccess.tasksCollection.update(eq("description", task.description),
                Document.createDocument("isFavorite", true))
    }

    override fun getTasks(): List<Task> {
        var results = dataAccess.tasksCollection.find()
        var list = ArrayList<Task>()

        for (document in results) {
            list.add(nitriteMapper.asObject(document, Task::class.java))
        }

        return list;
    }
}