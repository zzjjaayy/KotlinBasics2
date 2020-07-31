
fun sayHello(greeting:String, itemToGreet:List<String>) {
    itemToGreet.forEach {item ->
        println("$greeting $item")
    }
}

fun main() {
    val list1 = listOf("item1", "item2", "item3")

}