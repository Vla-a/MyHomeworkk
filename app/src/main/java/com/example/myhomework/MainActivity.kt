package com.example.myhomework

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myhomework.alarmсlock.AlarmClockActivity
import com.example.myhomework.customview.CustomViewActivity
import com.example.myhomework.galeryiaphoto.PhotoActivity
import com.example.myhomework.homework10.HomeWork10Activity
import com.example.myhomework.homework12.HomeWork12Activity
import com.example.myhomework.homework13.HomeWork13Activity
import com.example.myhomework.homework16.HomeWork15Activity
import com.example.myhomework.homework17.HomeWork17Activity
import com.example.myhomework.homework20.WeatherLocationActivity
import com.example.myhomework.homework6.HomeWork6Activity
import com.example.myhomework.homework7.HomeWork7Activity


class MainActivity : AppCompatActivity() {

    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button10: Button
    private lateinit var button12: Button
    private lateinit var button13: Button
    private lateinit var button15: Button
    private lateinit var button17: Button
    private lateinit var button18: Button
    private lateinit var button20: Button
    private lateinit var button21: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button6 = findViewById(R.id.button6)
        button6.setOnClickListener {

            val intent = Intent(this, HomeWork6Activity::class.java)
            startActivity(intent)
        }
        button7 = findViewById(R.id.button7)
        button7.setOnClickListener {
            val intent1 = Intent(this, HomeWork7Activity::class.java)
            startActivity(intent1)
        }
        button10 = findViewById(R.id.button10)
        button10.setOnClickListener {
            val intent2 = Intent(this, HomeWork10Activity::class.java)
            startActivity(intent2)
        }
        button12 = findViewById(R.id.button12)
        button12.setOnClickListener {
            val intent3 = Intent(this, HomeWork12Activity::class.java)
            startActivity(intent3)
        }
        button13 = findViewById(R.id.button13)
        button13.setOnClickListener {
            startActivity(Intent(this, HomeWork13Activity::class.java))
        }
        button15 = findViewById(R.id.button15)
        button15.setOnClickListener {
            startActivity(Intent(this, HomeWork15Activity::class.java))
        }

        button17 = findViewById(R.id.button17)
        button17.setOnClickListener {
            startActivity(Intent(this, HomeWork17Activity::class.java))
        }

        button18 = findViewById(R.id.button18)
        button18.setOnClickListener {
            startActivity(Intent(this, AlarmClockActivity::class.java))
        }
        button20 = findViewById(R.id.button20)
        button20.setOnClickListener {

            val intent = Intent(this, WeatherLocationActivity::class.java)
            startActivity(intent)
        }

        button21 = findViewById(R.id.button21)
        button21.setOnClickListener {

//            val intent = Intent(this, CustomViewActivity::class.java)
//            startActivity(intent)
            val intent = Intent(this, PhotoActivity::class.java)
            startActivity(intent)
        }
//        SixCars.createCar()
//
//        val bob = Dog("Bob", 43)
//        println("${bob.name} пробежал за ${"%.2f".format(bob.getTime())}")
//        val rok = Elephant("Pok", 89)
//        println("${rok.name} пробежал за ${"%.2f".format(rok.getTime())}")
//
////homework4.1
//        val woker1 = Worker("Ivan1", 1420.20)
//        val woker2 = Worker("Ivan2", 1380.40)
//        val woker3 = Worker("Ivan3", 1510.10)
//        val woker4 = Worker("Vasua1", 1310.35)
//        val woker5 = Worker("Vasua2", 1410.45)
//        val woker6 = Worker("Vasua3", 1340.95)
//        val woker7 = Worker("Sasha1", 1310.35)
//        val woker8 = Worker("Sasha2", 1410.45)
//        val woker9 = Worker("Sasha3", 1340.95)
//        val woker10 = Worker("Dima1", 1310.35)
//        val woker11 = Worker("Dima2", 1410.45)
//        val woker12 = Worker("Dima3", 1340.95)
//        val manager1 = Manager("Serg", 2090.60, arrayListOf(woker1, woker2, woker3))
//        val manager2 = Manager("Maks", 2190.80, arrayListOf(woker4, woker5, woker6))
//        val manager3 = Manager("Pak", 2065.30, arrayListOf(woker7, woker8, woker9))
//        val manager4 = Manager("Malk", 2027.80, arrayListOf(woker10, woker11, woker12))
//        val boss1 = Boss("Boss1", 3055.90,arrayListOf( manager1, manager2))
//        val boss2 = Boss("Boss1", 3055.90, arrayListOf( manager2, manager3))
//        val res = arrayListOf(
//            boss1, boss2, manager1, manager2, manager3, manager4,
//            woker1, woker2, woker3, woker4, woker5, woker6, woker7, woker8, woker9,
//            woker10, woker11, woker12,
//        ).forEach {
//            println("Name: ${it.name}, salary: ${it.salary} rub., ")
//            when (it) {
//                is Boss -> println("имеет ${it.listManager.size} подчиненных")
//                is Worker -> it.work()
//                is Manager -> println("имеет ${it.listWorker.size} подчиненных  ")
//            }
//        }
//
//        //homework4.2
//        println("----------------------------------------------------------")
//        arrayListOf(
//            Boss("Boss1", 3055.90, arrayListOf(
//                Manager("Maks", 2190.80, arrayListOf(
//                    Worker("Vasua1", 1310.35),
//                    Worker("Vasua2", 1410.45),
//                    Worker("Vasua3", 1340.95))),
//                Manager("Serg", 2090.60, arrayListOf(
//                    Worker("Ivan1", 1420.20),
//                    Worker("Ivan2", 1380.40),
//                    Worker("Ivan3", 1510.10))))),
//            Boss("Boss1", 3055.90, arrayListOf(
//                Manager("Pak", 2065.30, arrayListOf(
//                    Worker("Sasha1", 1310.35),
//                    Worker("Sasha2", 1410.45),
//                    Worker("Sasha3", 1340.95))),
//                Manager("Malk", 2027.80, arrayListOf(
//                    Worker("Dima1", 1310.35),
//                    Worker("Dima2", 1410.45),
//                    Worker("Dima3", 1340.95))))),
//            Manager("Serg", 2090.60, arrayListOf(
//                Worker("Ivan1", 1420.20),
//                Worker("Ivan2", 1380.40),
//                Worker("Ivan3", 1510.10))),
//            Manager("Maks", 2190.80, arrayListOf(
//                Worker("Vasua1", 1310.35),
//                Worker("Vasua2", 1410.45),
//                Worker("Vasua3", 1340.95))),
//            Manager("Pak", 2065.30, arrayListOf(
//                Worker("Sasha1", 1310.35),
//                Worker("Sasha2", 1410.45),
//                Worker("Sasha3", 1340.95))),
//            Manager("Malk", 2027.80, arrayListOf(
//                Worker("Dima1", 1310.35),
//                Worker("Dima2", 1410.45),
//                Worker("Dima3", 1340.95))),
//            Worker("Ivan1", 1420.20),
//            Worker("Ivan2", 1380.40),
//            Worker("Ivan3", 1510.10),
//            Worker("Vasua1", 1310.35),
//            Worker("Vasua2", 1410.45),
//            Worker("Vasua3", 1340.95),
//            Worker("Sasha1", 1310.35),
//            Worker("Sasha2", 1410.45),
//            Worker("Sasha3", 1340.95),
//            Worker("Dima1", 1310.35),
//            Worker("Dima2", 1410.45),
//            Worker("Dima3", 1340.95)
//        ).forEach {
//            println("Name: ${it.name}, salary: ${it.salary} rub., ")
//            when (it) {
//                is Boss -> println("${it.listManager.forEach {
//                    println("подчененный: ${it.name} ")}} имеет ${it.listManager.size} подчиненных")
//                is Worker -> it.work()
//                is Manager -> println("${it.listWorker.forEach {
//                    println("подчененный: ${it.name} ")}} имеет ${it.listWorker.size} подчиненных")
//            }
//        }
//    }
//    override fun onStart() {
//        super.onStart()
//        Log.e("fff", "onStart ")
//    }
//
//    override fun onResume() {
//        super.onResume()
//
//        Log.e("fff", "onResume")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.e("fff", "onPause")
//    }
//    override fun onStop() {
//        super.onStop()
//        Log.e("fff", "onStop")
//
//        }
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.e("fff", "onDestroy")
//    }
    }
//
//    override fun onClick(v: View?) {
//        when (v?.id) {
//            R.id.button6 -> button6.setOnClickListener {
//                val intent = Intent(this, HomeWork6Activity::class.java)
//                startActivity(intent)
//            }
//        }
//    }
}

//  fun main() {
//
//      // Создаем неизменяемую коллекцию, возвращаемое значение - Set
//      var set = setOf("Java", "Kotlin", "Go")
//      // Оценить, больше ли длина всех элементов 4
//      println(set.all { it.length > 4 })
//      // Определяем, больше ли длинных bean-компонентов любого элемента 4
//      println(set.any { it.length > 4 })
//      // Использование значения лямбда-выражения в качестве ключа и элемента коллекции в качестве значения для формирования коллекции Map
//      val map = set.associateBy { "Учиться" + it + "Язык" }
//      println(map)
//
//      println("Java" in set)
//      println("Go" !in set)
//
//      // Возвращаемся в коллекцию после удаления первых двух элементов коллекции Set
//      val dropedList = set.drop(2)
//      println(dropedList)
//
//      // Элементы коллекции Filter Set: требуется, чтобы элементы коллекции содержали li
//      val fliteredList = set.filter { "li" in it }
//      println(fliteredList)
//
//      // Находим элемент, содержащий li, в коллекции Set, если найден, возвращаем элемент, иначе возвращаем null
//      val foundStr1 = set.find { "li" in it }
//      println(foundStr1)
//
//      // Находим все строки в коллекции Set, которые нужно соединить вместе
//      val foldedList = set.fold("", { acc, e -> acc + e })
//      println(foldedList)
//
//      // Находим, где появляется элемент
//      println(set.indexOf("Go"))
//
//      // Сопоставляем каждый элемент набора с новым значением и возвращаем коллекцию Set, состоящую из всех новых значений
//      val mappedList = set.map { "Учиться" + it + "Программирование" }
//      println(mappedList)
//
//
//      // Изменение порядка сбора
//      val reversedList = set.reversed()
//      println(reversedList)
//
//      val bSet = setOf("Lua", "Erlang", "Kotlin")
//      // Вычислить пересечение двух наборов
//      println(set intersect bSet)
//      // Вычислить объединение двух наборов
//      println(set union bSet)
//      // Устанавливаем сложение, эквивалентное объединению
//      println(set + bSet)
//      // Устанавливаем вычитание, вычитаем общие элементы
//      println(set - bSet)
//}
//
//fun removeFillerWords(
//    text: List<String>,
//    vararg fillerWords: String): List<String> {
//    val fillerWordSet = setOf(*fillerWords)
//
//    val res = mutableListOf<String>()
//    for (word in text) {
//        if (word !in fillerWordSet) {
//            res += word
//        }
//    }
//    return res
//}