package com.munstein.basictodokotlin.data

import org.dizitart.no2.Nitrite
import java.io.File


/**
 * Created by @Munstein on 24/11/2017. --21:10
 */
class DataAccess {

    private var filesDir : File
    private var database : Nitrite

    constructor(filesDir : File){
        this.filesDir = filesDir
        database = Nitrite.builder()
                .compressed()
                .filePath(filesDir.path + "/main.db")
                .openOrCreate("user", "password")
    }

    private fun test(){
        
    }
}