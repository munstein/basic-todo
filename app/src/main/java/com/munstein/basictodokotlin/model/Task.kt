package com.munstein.basictodokotlin.model

/**
 * Created by @Munstein on 24/11/2017. --02:40
 */

data class Task(var description: String, var isFavorite: Boolean){
    //Parameter-less constructor for outside classes
    constructor() : this("", false)
}