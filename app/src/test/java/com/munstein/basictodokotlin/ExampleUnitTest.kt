package com.munstein.basictodokotlin

import com.munstein.basictodokotlin.data.NitriteDataAccess
import com.munstein.basictodokotlin.main.MainModel
import com.munstein.basictodokotlin.model.Task
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    var data = NitriteDataAccess()
    var mainModel = MainModel(data)


    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun add_select(){
        var task = Task()
        task.isFavorite = false;
        task.description = "Hello nosql"
        mainModel.saveTask(task)
        var tasks =  mainModel.getTasks()
        assertEquals(task.description, tasks[0].description)
    }

    @Test
    fun add_select_remove(){
        var task = Task()
        task.isFavorite = false;
        task.description = "Hello nosql"
        mainModel.saveTask(task)
        var tasks =  mainModel.getTasks()
        assertEquals(task.description, tasks[0].description)
        mainModel.removeTask(task)
        tasks = mainModel.getTasks()
        assertEquals(0, tasks.size)
    }
}
