package com.example.kotlintest

interface MyInterface {

    var vr: Any
        get() = 10
        set(value) = TODO()

    fun vrMethod(){
        vr=100
        println("$vr")
    }

}