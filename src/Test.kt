fun main(args: Array<String>) {
    println("Hello world")
    printMessage1("One")
    printMessageWithPrefix("puneet")
    printMessageWithPrefix("puneet", "hi")
    printMessageWithPrefix(message = "puneet", prefix = "hi")
    println(sum(2, 4))
    println(multiple(2, 4))

    //infix fun Int.times(str: String) = str.repeat(this)
    //println(3 times "Hi")

    val pair = "Ferrari" to "katrina"
    println(pair)

    infix fun String.onto(other: String) = Pair(this, other)
    val mypair = "a" onto "b"
    println(mypair)

    val p = Person("Puneet")
    val g = Person("Guttu")
    println(p likes g)

    operator fun Int.times(str: String) = str.repeat(this)
    println(2 * "Bye ")

    operator fun String.get(range: IntRange) = substring(range)
    val str = "My name is Puneet Goyal and works in Posten Norge AS"
    println(str[0..16])

    printAll("a", "b", "c")
    printAllAnd("a", "b", "c", other = "d")

    var a : String = "puneet" //mutable
    println(a)
    val b : Int = 3 //immutable
    println(b)
    val c = 4 // automatic type inference , Int

    var neverNull : String = "b"
    //neverNull = null // compilation error

    var canbenull : String? = "c"
    canbenull = null

    var assumedNonnull = "compiler assumes non null"

    strLength(neverNull)
    //strLength(canbenull)// compilation error

    println(describeString("Hi this is me"))
    val customer =  Customer()
    val contact = Contact(1, "abc@gmail.com")
    println("contact id is ${contact.id}")
    contact.email = "def@gmail.com"

}
class Customer
class Contact(val id:Int, var email: String)

fun describeString(mayBeString : String?): String {
    if(null != mayBeString && mayBeString.length > 0) {
        return "Length of String is ${mayBeString.length}"
    } else {
        return "Empty String"
    }
}

fun strLength(notNull: String): Int {                   // 7
    return notNull.length
}

fun printAll(vararg messages: String) {
    for (m in messages) print(m)
    println()
}

fun printAllAnd(vararg messages: String, other: String) {
    for (m in messages) print(m)
    println(other)
}

class Person(val name: String) {
    val linkedPerson = mutableListOf<Person>()
    infix fun likes(other: Person) {
        linkedPerson.add(other)
    }

    override fun toString() = this.name
}

fun printMessage1(message: String): Unit {
    println(message)
}

fun printMessageWithPrefix(message: String, prefix: String = "Hello") {
    println("[$prefix] $message")
}

fun sum(x: Int, y: Int) = x + y
fun multiple(x: Int, y: Int): Int {
    return x * y
}



