package com.example.kotlintest

open class MyParentClass(year:Int=0) {
    var x=5
    var jaar:Int

    init {
        //this.year = year
        jaar = year
        println("initialiseren")
    }

    fun go(){

        println("goooooo " + jaar )  //+ year
    }
}