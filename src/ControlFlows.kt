fun cases(obj : Any){
    val a = when(obj) {
        1 -> "value is 1"
        "Hello"-> "Greetings"
        is String -> "${obj} value type is String"
        //!is String -> "${obj} value type is not String"
        else -> "unknown"
    }
    println(a)
}

class test
fun main() {
    cases(1)
    cases("Hello")
    cases("abc")
    cases(2)
    cases(test())

    val list = listOf<String>("1","2","3")
    for (l in list) println(l)

    var i = 0
    while(i < 5){
        println("the value of i is ${i}")
        i++
    }

    do{
        println("do while ${i}")
        i--
    }while(i>0)

    val zoo = Zoo(listOf(Animal("zebra"), Animal("lion")))

    for (animal in zoo) {                                   // 3
        println("Watch out, it's a ${animal.name}")
    }

    //ranges
    println("--------Ranges-------------")
    for(i in 0..3) print(i)
    println()
    for(i in 0..10 step 2) print(i)
    println()
    for(i in 0 until 3) print(i)
    println()
    for(i in 2..8 step 2) print(i)
    println()

    for(c in 'a'..'e') print(c)
    for(c in 'a' until 'f') print(c)
    for (c in 'z' downTo 's' step 2) {
        print(c)
    }

    //ranges are also useful in the if statement
    val x = 2
    if(x in 1..5) println("values lies between 1 and 5")
    if(x !in 5..10) println("values does not lies between 10 and 5")

    //Kotlin uses == for structural comparison and === for referential comparison.

    val authors = setOf<String>("shakespeare", "sheldon", "larsen")
    val composers = setOf<String>("sheldon", "shakespeare", "larsen")
    println("{authors == composers} : ${authors == composers}")
    println("{authors === composers} : ${authors === composers}")

    val user = User("Alex",1)
    println(user)
    val secondUser = User("Alex",1 )
    val thirdUser = User("Max", 3)
    println(user==secondUser)
    println(user==thirdUser)
    println(user.hashCode())                               // 4
    println(secondUser.hashCode())                               // 4
    println(thirdUser.hashCode())

    println(user.copy())
    val c : User = user.copy("Max")// 5
    println(c.hashCode())
    println(c)                              // 6
    println(user.copy(id = 2))

    println("-----------------ENUM-------------")
    val state = State.RUNNING
    val message = when(state){
        State.IDLE->"state is Idle"
        State.RUNNING->"state is Running"
        State.FINISHED->"state is Finished "
    }
    println(message)

    val col = Color.RED
    println("col.containsRed() ${col.containsRed()}")
    println("col.containsRed() ${Color.BLUE.containsRed()}")


}
fun greetMammal(mammal : Mammal){
    val message = when(mammal){
        is Human -> "Hello ${mammal.name}; You're working as a ${mammal.job}"    // 4
        is Cat ->  "Hello ${mammal.name}"
    }
}
sealed class Mammal(val name : String)
class Cat(val catName : String) : Mammal(catName)
class Human(val humanName : String, val job : String) : Mammal(humanName)

enum class Color(val rgb: Int){
    RED(0xFF0000),                                    // 2
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00);
    fun containsRed() : Boolean {
        println(this.rgb and 0xFF0000 != 0)
        return (this.rgb and 0xFF0000 != 0)
    }
}

//Enum classes
enum class State {
    IDLE, RUNNING, FINISHED
}

data class User(val name : String, val id : Int)

//There is no ternary operator condition ? then : else in Kotlin. Instead, if may be used as an expression
fun max(a: Int, b: Int){
    if(a>b) a else b
}
class Animal(val name : String)
class Zoo( val animals: List<Animal>){
    operator fun iterator(): Iterator<Animal>{
        return animals.iterator()
    }

}