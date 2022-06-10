package com.example.kotlintest

sealed interface MySealedInterface{

    var vrSeal: Any
        get() = 66
        set(value) = TODO()

    fun vrSealMethod(){
        vrSeal=660
        println("$vrSeal")
    }
}