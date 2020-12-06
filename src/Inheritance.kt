
//Kotlin classes are final by default. If you want to allow the class inheritance, mark the class with the open modifier.
//Kotlin methods are also final by default. As with the classes, the open modifier allows overriding them.
//A class inherits a superclass when you specify the : SuperclassName() after its name. The empty parentheses () indicate an invocation of the superclass default constructor.
//Overriding methods or attributes requires the override modifier.


open class Dog(var name: String){
    open fun sayHello() = "hello " + this.name
}
class Spitz(var names: String, val size : String): Dog(names) {
    override fun sayHello() = "size is " + this.size
}
fun main() {
    val dog: Dog = Spitz("tommy", "small")
    println(dog.sayHello())

    val tiger = SiberianTiger()
    tiger.printOrigin()

    val lion1 = Asiatic("bhopali")
    lion1.printDetails()
}

//Another example
open class Tiger(val origin: String){
    fun printOrigin() = println(this.origin)
}
class SiberianTiger : Tiger("Siberian")

//yet another example
open class Lion(val name: String, val origin: String){
    fun printDetails() = println("The lion name is ${name} and origin is ${this.origin}")
}
class Asiatic(name : String) : Lion(name = name, origin="indian")
