fun main() {
    val data1 = dc("1") // store a data class in a variable
    println(data1) // prints -> "dc(id=1)"

    println(pair1)

    println(testItem1)
    println(testItem2)
    println(testItem3)
    println(testItem4)
    println(testItem5)

    println(list.reversed())


}

/**
 * DATA CLASS
 */

data class dc(val id : String)

/**
 *PAIRS
 */
val pair1 = "item1" to "item2" // prints -> "(item1, item2)"
val pair2 = "item" to "item" to "item"
val pair3 = "item1" to "item2" to "item3" to "item4" // prints -> "(((item1, item2), item3), item4)"
val pair4 = "item1" to ("item2" to "item3")

// Functions on Pairs
val testItem1 = pair1.first // will store "item1"
val testItem2 = pair3.first // will store "((item1, item2), item3)"
val testItem3 = pair3.first.first // will store "(item1, item2)"
val testItem4 = pair3.first.first.first // will store "item1"
val testItem5 = pair4.second // will store "("item2, item3")"

/**
 * Collection (Additions)
 */
val list = mutableListOf("1", "2", "3") // refer main fn to see "reversed" fn


