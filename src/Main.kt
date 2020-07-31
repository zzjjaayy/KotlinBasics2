
fun sayHello1(greeting:String, vararg itemToGreet:String) {
    //"vararg" is used to let enter variable number of parameters for String

    itemToGreet.forEach {item ->
        println("$greeting $item")
    }
}

fun sayHello2(greeting:String, vararg itemToGreet:String) {
    itemToGreet.forEach {item ->
        println("$greeting $item")
    }
}

fun sayHello3(greeting:String = "Hello", itemToGreet:String = "Kotlin") {
    // "Hello" & "Kotlin" is now the default value of greeting & itemToGreet respectively
    // if nothing is passed
    itemToGreet.forEach {item ->
        println("$greeting $item")
    }
}

fun main() {

    /**
     * ARGUMENTS & PARAMETERS
     */
    val array1 = arrayOf("item1", "item2", "item3")
    sayHello1("hi", "item1", "item2")

    sayHello1("Hi", *array1)
    //adding a "*" lets enter an array in place of varargs

    sayHello2(itemToGreet = *array1, greeting = "Hi")
    // if we mention the name of the parameter, we can mixing up their order.

    sayHello3()
    //we can pass functions without any arguments because we passed in default values

}