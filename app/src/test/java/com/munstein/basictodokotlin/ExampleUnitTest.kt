package com.munstein.basictodokotlin

import com.munstein.basictodokotlin.data.NitriteDataAccess
import com.munstein.basictodokotlin.main.MainModel
import com.munstein.basictodokotlin.model.Task
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 * :D
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    var data = NitriteDataAccess()
    var mainModel = MainModel(data)

    @Test
    fun test_add_select() {
        var task = Task("Hello NoSQL", false)
        mainModel.saveTask(task)
        var tasks = mainModel.getTasks()
        assertEquals(task.description, tasks[0].description)
    }

    @Test
    fun test_add_select_remove() {
        var task = Task("Hello NoSQL", false)
        mainModel.saveTask(task)
        var tasks = mainModel.getTasks()
        assertEquals(task.description, tasks[0].description)
        mainModel.removeTask(tasks[0])
        tasks = mainModel.getTasks()
        assertEquals(0, tasks.size)
    }

    @Test
    fun test_add_multiple() {
        var total = 55
        var task = Task("Hello NoSQL", false)

        for (i in 1..total) mainModel.saveTask(task)

        var tasks = mainModel.getTasks()
        assertEquals(total, tasks.size)
    }

    @Test
    fun test_unfavorite() {
        var task = Task("Hello NoSQL", true)
        mainModel.saveTask(task)
        var tasks = mainModel.getTasks()
        assertEquals(task.description, tasks[0].description)
        mainModel.unfavorite(task)
        tasks = mainModel.getTasks()
        assertEquals(false, tasks[0].isFavorite)
    }

    @Test
    fun test_favorite() {
        var task = Task("Hello NoSQL", false)
        mainModel.saveTask(task)
        var tasks = mainModel.getTasks()
        assertEquals(task.description, tasks[0].description)
        mainModel.favorite(task)
        tasks = mainModel.getTasks()
        assertEquals(true, tasks[0].isFavorite)
    }

}
