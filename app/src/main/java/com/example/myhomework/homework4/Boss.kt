package com.example.myhomework.homework4



class Boss(name: String, salary: Double, val listManager:  MutableList<Manager>) : Staff(
    name,
    salary,
) {
}