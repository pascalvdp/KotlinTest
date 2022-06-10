//https://drive.google.com/drive/folders/1HSMlhSHpQa5EV4UMFyzQfZIiqSX2YsBdpackage com.example.kotlintest
package com.example.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    //var buttonTest1: Button? = null
    //var tv: TextView? = null
    //val buttonTest1: Button = findViewById(R.id.buttonTest)
    //val buttonTest1 = Button(this)
    lateinit var buttonTest1: Button
    lateinit var tv: TextView
    //var buttonTest1 = Button(this)
    //var tv= TextView(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.textView)
        buttonTest1=findViewById(R.id.buttonTest)

        tv.text = "button niet aangeklikt"

        buttonTest1.setOnClickListener{
            Toast.makeText(this,"buttonTest clicked", Toast.LENGTH_SHORT).show()
            //changeText()
            //test()
            //testObjects()
            testLists()
            //testClasses()
            //testClasses2()
            //testDataClass()
            //testLambdas()
            //testArrays()
            //testAnnotations()
            //testProperties()
            //testInterfacesAndObjects()
            //testSealedClassAndInterface()
        }

    }

    fun test(){
        var number = 100000.toLong() //100000
        var result = recursiveSum(number)
        println("sun of upto $number number = $result")
    }

    //als men geen tailrec toepast dan crasht het systeem
    tailrec fun recursiveSum(n: Long, semiresult: Long = 0) : Long{ //100000+99999+99998+99997+...
        return if (n <= 0){
            semiresult
        }else{
            //println("$semiresult")
            recursiveSum((n-1),n+semiresult)
        }
    }

    fun changeText(){
        if (tv.text=="button niet aangeklikt"){
            tv.text="button clicked"
        }else{
            tv.text = "button niet aangeklikt"
        }
    }

    fun testObjects(){
        println("test objecten")
        val obj : String? = "123"
        if(obj is String){
            println("lengte van de string = ${obj.length}")
        }
        val str:String? = obj as String?
        println(str)
        val obj2 : Any = "kotlin"
        val obj3 : String? = obj2 as? String  //kotlin
        val obj4 : Int? = obj2 as? Int        //null
        println(obj3)
        println(obj4)
        //
        var stri1:String? = null
        var stri2:String? = "May be declare nullable string"
        var len1:Int = stri1 ?.length ?:-1
        var len2:Int = stri2 ?.length ?:-1
        println("lengte string1 = ${len1}") //-1
        println("lengte string2 = ${len2}") //30
    }

    fun testLists(){
        var day = 2
        var result = when(day){
            1 -> {
                println("maandag")
                println("first day of the week")
            }
            2 -> "dinsdag"
            4 -> "donderdag"
            5 -> "vrijdag"
            6 -> "dag " + 6
            else -> "nothing found"
        }
        println("resultaat = $result")
        var test = arrayOf("Peugeot","Renault","Ford","Mazda")
        var cars = test + "Bmw"
        if("Ford" in cars){
            println("found2")
        }else{
            println("not found!!!!!!")
        }
        //println(cars[1])
        for (numbers in 5..15){//5 tot 15
            print(numbers.toString() + " ")
        }
        println()
        for (chars in 'a'..'x'){//a tot x
            print(chars + " ")
        }
        for (x in 5 downTo 1) {//54321
        }
        for (x in 1.rangeTo(5)) {//12345
        }
        for (x in 5.downTo(1)) {//54321
        }
        println()
        //class IntRange in kotlin
        var range2 = IntRange(1,5)
        for(x in range2){
            print("class IntRange = $x, ")
        }
        println()
        var range: IntProgression = 5.downTo(1)
        for(x in range){
            print("IntProgression = $x, ")
        }
        println()
        var range3: IntRange = IntRange(1,5)
        for(x in range3.reversed()){
            print("IntRange reversed(omgekeerd) = $x, ")
        }
        println()
        var range4: IntRange = 1..10
        for(x in range4 step 3){
            print("step 3 = $x, ") //1 4 7 10
        }
        println()
        val first = ((range4 step 2).first)
        val last = ((range4 step 2).last)
        println("first = $first")//1
        println("last = $last")//9
        println()
        first@ for (i in 1..5){
            tweede@ for(j in 1..10){
                if (i==3){ break@first }
                println(j)
            }
        }
        //test lijsten
        var mutableList1 = mutableListOf("Ajay","Vijay")
        mutableList1.add("Prakash")
        var mutableList2 = mutableListOf<String>()
        mutableList2.add("Ajeet")
        var list3 = listOf<String>()
        //list3.add => dit gaat niet, enkel bij mutable list

        //test list in function MutableList<Int>?.swap
        val list = mutableListOf(5,10,15)
        println("before swapping the list :$list")
        val result2 = list.swap(0,2)
        println("after swapping the list :$result2")
        //test lijsten
        val stringList: ArrayList<String> = arrayListOf("nulde","eerste","tweede")
        val floatList: ArrayList<Float> = arrayListOf(10.5f,5.0f,25.5f)
        printValue(stringList)//zie functies lager
        printValue(floatList)
        stringList.printVal()
    }

    //hierboven gebruikt
    fun IntProgression.reversed(): IntProgression{
        return IntProgression.fromClosedRange(last, first, -step)
    }

    //hierboven gebruikt
    fun Long.downTo(other: Int): IntProgression{
        return IntProgression.fromClosedRange(this.toInt(), other, -1)
    }

    //hierboven gebruikt
    fun MutableList<Int>?.swap(index1:Int,index2:Int):Any{
        if(this == null) return "null"
        else {
            val tmp = this[index1]
            this[index1] = this[index2]
            this[index2] = tmp
            return this
        }
    }

    //hierboven gebruikt
    fun <T> printValue(list: ArrayList<T>){
        for (element in list){
            println(element)
        }
    }

    //hierboven gebruikt
    fun <T>ArrayList<T>.printVal(){
        for (element in this){
            println("printVal = $element")
        }
    }

    fun testClasses() {
        val cl = Car("Ford", "Mustang", 1969)
        cl.drive()
        cl.speed(200)
        cl.go()

        val tt = MyParentClass(2000)
        tt.go()

        val peu = Car()
        peu.go()
        peu.year=1001
        //var va = peu.year
        println("het jaar is ${peu.year}")
    }

    fun testClasses2(){
        var myObj = MijnClass("hans", 230, "passw")
        myObj.myFunction()
        var myObj2 = MijnClass("hans", 23)
        myObj2.myFunction()
        var myObj3 = MijnClass()
        myObj3.myFunction()
        //testCreate is static in java, in kotlin = companion object
        var test = MijnClass //hier zijn geen haakjes, dus ook geen object
        test.testCreate()
    }

    fun testDataClass(){
        val p1 = MyDataClass("laptop")
        val p2 = MyDataClass("laptop")
        println(p1==p2)//=true, indien MyDataClass geen data class is dan = false
        println(p1.equals(p2))//=true, indien MyDataClass geen data class is dan = false
        //p1.item
    }

    fun testLambdas(){
        val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
        //println(sum(5,10))

        val myLambda: (Int) -> Unit= {s: Int -> println(s) } //lambda function
        addNumber(5,10,myLambda)

        val items = listOf(1, 2, 3, 4, 5)
        // Lambdas are code blocks enclosed in curly braces.
        items.fold(0, {
            // When a lambda has parameters, they go first, followed by '->'
                acc: Int, i: Int ->
            print("acc = $acc, i = $i, ")
            val result = acc + i
            println("result = $result")
            // The last expression in a lambda is considered the return value:
            result
        })
        // Parameter types in a lambda are optional if they can be inferred:
        val joinedToString = items.fold("Elements:", { acc, i -> acc + " " + i })
        // Function references can also be used for higher-order function calls:
        val product = items.fold(1, Int::times)
        println("joinedToString = $joinedToString")
        println("product = $product")
        //lambdas, input kan je ook gewoon een ander woord voor gebruiken
        val stringLengthFunc: (String) -> Int = { input ->
            //println("lengte van $input = ${input.length}")//dit werkt ook
            input.length
        }
        val invoer = "android"
        val stringLength: Int = stringLengthFunc(invoer)
        println("lengte van $invoer = $stringLength")
    }

    fun addNumber(a: Int, b: Int, mylambda: (Int) -> Unit ){   //high level function lambda as parameter
        val add = a + b
        mylambda(add) // println(add)
    }

    fun testArrays(){
        val asc = Array(5,{i -> i*2}) // 0 2 4 6 8
        for(k in asc){
            println(k)
        }
    }

    fun testAnnotations(){
        var c = MyClass()
        var x = c.javaClass.getAnnotation(Ann::class.java)
        if(x!=null){
            println("value:"+x?.value)
            println("valuetest:${x?.test}")
        }
    }

    var y = 5
    fun testProperties(){
        println(::y.get())//=5
        println(::y.name)//=y
        ::y.set(10)
        println(::y.get())//=10
        //
        fun isPositive(x: Int) = x > 0
        fun isPositive(s: String) = s== "kotlin" || s == "Kotlin"
        val numbers = listOf(-10,-5,0,5,10)
        val Strings = listOf("kotlin","program")
        println(numbers.filter(::isPositive))
        println(Strings.filter(::isPositive))
        //
        class A(val x: Int)
        val prop = A::x
        println(prop.get(A(5)))
    }

    fun testInterfacesAndObjects(){
        class Horse : Movable by FourLegged
        var p = Horse()
        println(p.legsCount)
    }

    fun testSealedClassAndInterface(){
        //var seal2 = MySealedClass() //dit gaat niet wegens sealed = verzegeld
        var seal = MyClassSeal() //dit gaat wel via een andere class
        seal.testSeal()
        println("${seal.vr}")
        //classes
        fun eval(e: Shape) =
            when (e) {
                is Shape.Circle ->println("Circle area is ${3.14*e.radius*e.radius}")
                is Shape.Square ->println("Square area is ${e.length*e.length}")
                is Shape.Rectangle ->println("Rectagle area is ${e.length*e.breadth}")
                //else -> "else case is not require as all case is covered above"
                //  Shape.NotAShape ->Double.NaN
            }
        var circle = Shape.Circle(5.0f)
        var square = Shape.Square(5)
        var rectangle = Shape.Rectangle(4,5)
        eval(circle)
        eval(square)
        eval(rectangle)
        //interfaces
        var tt = MyClassInterface()
        tt.vr=33
        tt.vrMethod()
        tt.vrSeal=34
        tt.vrSealMethod()

    }
}
