package com.example.kotlintest
//Peugeot,208,2015 zijn defaultwaardes
class Car(var brand: String="Peugeot", var model: String="208", var year: Int=2015): MyParentClass(year){

    fun drive(){
        x=10
        println("vroem" + x)
    }

    fun speed(maxSpeed: Int){
        println("Maxspeed is:" + maxSpeed)
    }
}