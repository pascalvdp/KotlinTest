package com.example.kotlintest

class MijnClass(var id: Int=400): MijnParentClass(id) { //id = primaire constructor

    //var id: Int = 400
    init {
        //this.id=id
    }
    //super(id) => enkel in gebruik als er geen primaire constructor is
    constructor(name: String, id: Int) : this(name, id, "passw") {
    //this.id = id
    }

    constructor(name: String, id: Int, pass: String) : this(id) {
        //this.id = id
    }

    fun myFunction(){
        println("test = $test")
        println("id = $id")
    }

    //een companion object = zoals in java static is
    companion object{
        fun testCreate():String{ //MijnClass.testCreate() => dit wordt toegepast
            return "static method"
        }
    }
}