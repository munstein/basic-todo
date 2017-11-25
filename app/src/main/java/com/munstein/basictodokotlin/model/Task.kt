package com.munstein.basictodokotlin.model

/**
 * Created by @Munstein on 24/11/2017. --02:40
 */
class Task {
    var description : String = ""
    var isFavorite : Boolean = false

    constructor()

    constructor(description : String, isFavorite : Boolean){
        this.description = description
        this.isFavorite = isFavorite
    }
}