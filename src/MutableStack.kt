class MutableStack<E> (vararg items : E){

    private val elements = items.toMutableList()

    fun push(item : E) = elements.add(item)

    fun peek() = elements.last()

    fun pop() : E = elements.removeAt(elements.size - 1)

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size

    override fun toString() = "MutableStack{${elements.joinToString()}}"

}

fun main() {
    val instance = MutableStack<String>()

    println(instance.isEmpty())
    println(instance.push("1st"))
    println(instance.push("2nd"))
    println(instance.push("3rd"))
    println(instance.peek())
    println(instance.peek())
    println(instance.pop())
    println(instance.peek())
    println(instance.toString())

    fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)

    val stack = mutableStackOf(0.1,0.2)
    println(stack)

}