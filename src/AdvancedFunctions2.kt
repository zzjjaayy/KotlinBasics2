fun main() {
    val list = listOf("Js", "K", "LK")
    list.filter {
        it.startsWith("J")
    }.forEach {
        println(it)
    }
    // the above function allows us to print only the words starting with "J"
    // from a list

    val list1 = listOf("Js", "K", "LK", null, null)
    list1.filterNotNull().filter {
        it.startsWith("J")
    }.forEach {
        println(it)
    }
    // the filterNotNull() rejects all null values

    list1.filterNotNull()
            .filter {
                it.startsWith("J")
            }.map {
                it.length
            }.take(2)
            .forEach {
                println(it)
            }
    // Above the map function can change the data type
    // where the type changed from String to Int
    // "take" fn takes the first 3 items from the list
    // "takeLast" will take the last 3 items

    list1.filterNotNull()
            .filter {
                it.startsWith("J")
            }.associate { it to it.length }// this creates a map of the list
            // item and its length
            .forEach {
                println("${it.key} : ${it.value}")
            }
            // this prints the item and its length

    val map1 = list.associate {
        it to it.length
    } // storing the map value in a variable

    val test = list.filterNotNull().last()
    // stores the last value
    // we can also use the first() fn

    val test1 = list.find {
        it.startsWith("java")
    }.orEmpty() // stores the value of the first element found starting with "java"
    // can also use findLast to find last element matching the requirement
    // orEmpty fn returns an empty String if null

}