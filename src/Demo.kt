import java.util.Random

fun main() {
    println("Hello World")

    //Variable Types
    val name = "Peter"  //readonly variable
    var myAge = 37      //changeable variable

    var bigInt: Int = Int.MAX_VALUE
    var smallInt: Int = Int.MIN_VALUE
    println("biggest Int:  " + bigInt)
    println("smallest Int:  $smallInt") //String Innapolation

    var bigLong: Long = Long.MAX_VALUE
    var smallLong: Long = Long.MIN_VALUE
    println("biggest Long: $bigLong")
    println("smallest Long: $smallLong")

    //true and false
    if (true is Boolean) {
        print("true is boolean\n")
    }

    //Strings
    var letterGrade: Char = 'A'
    println("A is a Character: ${letterGrade is Char}")

    println("3.14 to Int: " + (3.14.toInt()))
    println("A to int: " + 'A'.toInt())
    println("65 to char: " + 65.toChar())

    val myName = "Peter Hoffmann"
    val longString = """Peter 
|           Hoffmann"""

    var fName: String = "Peter"
    var lName: String = "Hoffmann"

    fName = "Sally"
    var fullname = fName + " " + lName
    println("Name : $fullname")

    println("1 + 2 = ${1 + 2}")

    println("String Length : ${longString.length}")

    var str1 = "A random string"
    var str2 = "a random string"
    println("Strings Equal : ${str1.equals((str2))}")
    println("Compare A to B : ${"A".compareTo("B")}")

    println("2nd Index: ${str1.get(2)}")
    println("2nd Index: ${str1[2]}")
    println("Index 2 - 7: ${str1.subSequence(2, 8)}")
    println("Contains random: ${str1.contains("random")}")

    //Arrays
    var myArray = arrayOf(1, 1.23, "Peter")  //create and fill an array
    println(myArray[2])

    myArray[1] = 3.14
    println("Array lenght: ${myArray.size}")
    println("Peter in Array: ${myArray.contains("Peter")}")

    var partArray = myArray.copyOfRange(0, 1)
    println("First : ${myArray.first()}")
    println("Peter Index : ${myArray.indexOf("Peter")}")

    var squareArray = Array(5, { x -> x * x }) //define a new array
    println(squareArray[2])

    var array2: Array<Int> = arrayOf(1, 2, 3)

    //Ranges
    val oneTo10 = 1..10
    val alpha = "A".."Z"

    println("A in alpha : ${"R" in alpha}")

    val tenTo1 = 10.downTo(1)
    val twoTo20 = 2.rangeTo(20)
    val range3 = oneTo10.step(3)

    for (x in range3) println("range3: $x")

    for (x in tenTo1.reversed()) println("Reverse: $x")

    //Conditional Operators / Logical Operators
    val age = 8
    if (age < 5) {
        println("Go to Preschool")
    } else if (age == 5) {
        println("Go to Kindergarten")
    } else if ((age > 5) && (age <= 17)) {
        val grade = age - 5
        println("Go to Grade $grade")
    } else {
        println("Go to College")
    }

    when (age) {
        0, 1, 2, 3, 4 -> println("Go to Preschool") //list of values

        5 -> println("Go to Kindergarten") //specific value

        in 6..17 -> {
            val grade = age - 5
            println("Go to Grade $grade")
        }// range

        else -> println("Go to College")
    }

    //Looping Lists
    for (x in 1..10) {
        println("loop : $x")
    }

    val random = Random()
    val magicNumber = random.nextInt(50) + 1
    var guess = 0

    while (magicNumber != guess) {
        guess++
    }

    println("Magic Number: $magicNumber")

    for (x in 1..20) {
        if (x % 2 == 0) {
            continue
        }

        println("Odd : $x")

        if (x == 15) break
    }

    var array3: Array<Int> = arrayOf(3, 6, 9)
    for (i in array3.indices) {
        println("Multiple 3: ${array3[i]}")
    }

    for ((index, value) in array3.withIndex()) {
        println("Index : $index Value : $value")
    }


    //Functions
    fun add(num1: Int, num2: Int): Int = num1 + num2  //Single Line Function
    println("5 + 4 = ${add(5, 4)}")

    fun subtract(num1: Int = 1, num2: Int = 1) =
        num1 + num2  //Single Line Function with default value and no return value
    println("5 - 4 = ${subtract(5 - 4)}")

    println("4 - 5 = ${subtract(num2 = 5, num1 = 4)}") //named parameters

    fun sayHello(name: String): Unit = println("Hello $name")
    sayHello("Peter")

    val (two, three) = nextTwo(1) //Pair Result
    println("1 $two $three")
    println("Sum = ${getSum(1, 2, 3, 4, 5)}") //use vararg as result

    val multiply = { num1: Int, num2: Int -> num1 * num2 } //Define function and assign it
    println("5 * 3 = ${multiply(5, 3)}")

    println("5! = ${fact(5)}")

    //Collection oprators
    val numList = 1..20
    val evenList = numList.filter { it % 2 == 0 } //"it" can be used a default attribute name
    evenList.forEach { n -> println(n) }

    val mult3 = makeMathFunc(3)
    println("5 * 3 = ${mult3(5)}")

    val numList2 = 1..20
    val listSum = numList2.reduce { x, y -> x + y }
    println("Reduce Sum: $listSum")

    val listSum2 = numList2.fold(5) { x, y -> x + y }
    println("Fold Sum: $listSum2")

    println("Evens: ${numList2.any { it % 2 == 0 }}") //returns if any entries returns mod 2 as true (that is true)
    println("Evens: ${numList2.all { it % 2 == 0 }}") //returns if all entries return mod 2 as true (that is false)

    val big3 = numList2.filter { it > 3 }
    big3.forEach { n -> println(">3 : $n") }

    val times7 = numList2.map { it * 7 }
    times7.forEach { n -> println("*7 : $n") }
}

fun nextTwo(num: Int): Pair<Int, Int> {
    return Pair(num + 1, num + 2)
}

fun getSum(vararg nums: Int): Int {
    var sum = 0
    nums.forEach { n -> sum += n }
    return sum
}

//Calc of a factor (5*4*3*2*1)
fun fact(x: Int): Int {
    tailrec fun factTail(y: Int, z: Int): Int {
        if (y == 0) return z
        else return factTail(y - 1, y * z)
    }
    return factTail(x, 1)
}

//Functions with functions
fun makeMathFunc(num1: Int): (Int) -> Int = { num2 -> num1 * num2 }