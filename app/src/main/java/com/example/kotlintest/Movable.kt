package com.example.kotlintest

interface Movable {
    val legsCount: Int
    fun canWalk() = legsCount > 1
}