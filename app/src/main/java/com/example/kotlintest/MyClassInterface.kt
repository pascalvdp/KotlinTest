package com.example.kotlintest

class MyClassInterface : MyInterface,MySealedInterface {

    override var vr: Any
        get() = super.vr
        set(value) {}

    override var vrSeal: Any
        get() = super.vrSeal
        set(value) {}

    override fun vrMethod() {
        super.vrMethod()
    }

    override fun vrSealMethod() {
        super.vrSealMethod()
    }
}