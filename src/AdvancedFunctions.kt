/**
 * HIGHER ORDER FUNCTIONS
 * Functions which accept functions as parameters or returns a function.
 */

fun printFilteredStrings(list: List<String>, predicate : (String) -> Boolean) {
    // the above fn takes in a list and Function as parameters
    // here the "predicate" is the name of the fn
    // "(String)" is the parameter taken in by the function "predicate"
    // Boolean is the return type of the function "predicate"

    list.forEach {item ->
        if(predicate(item)) {
            println(item)
        }
    }
    // the above lambda function puts in all the values the input list
    // and sends it as parameters in the "predicate" function
    // prints the list item if true
}

fun printFilteredStrings1(list: List<String>, predicate : ((String) -> Boolean)?) {
    // the above function accepts a nullable function
    // this is done by wrapping the input and return type of function
    // in parenthesis and adding a question mark at the end of the parenthesis

    list.forEach {item ->
        if(predicate?.invoke(item) == true) {
            // we did this because now the constructor accepts nullable functions
            // "?" is used to used to check for nullability
            // allows the function only when not null {or null asserted}
            // invoke method calls for the function
            // and checks if its true
            println(item)
        }
    }

}

val predicate: (String) -> Boolean = {
    it.startsWith("J")
}
// the above is a function stored in a variable
// where, String is the input type & Boolean the return type
// and the function is defined just like a lambda fn.


fun getPrintPredicate() : (String) -> Boolean {
    return {
        it.startsWith("J")
    }
}
// the above function declaration returns a new function.

fun main() {
    val list = listOf("Kotlin", "java", "C++", "Js", "True")
    printFilteredStrings(list) { item ->
        item.startsWith("K")
    }
    // the above function call passes in a list and a lambda function
    // here the item entered is startsWith "K" returns true otherwise false
    // printFilteredStrings(list, {item ->
    //        item.startsWith("K")
    //    })
    // the above declaration is also correct but the other one is recommended
    // by the IDE

    printFilteredStrings1(list, null)
    // now the function accepts nullable functions

    printFilteredStrings(list, predicate)
    // the above call is made possible because we can have functions in
    // variables and pass them whenever we need to the call the function

    printFilteredStrings(list, getPrintPredicate())
    // the above function call accepts a function which is returned from
    // another function.

}