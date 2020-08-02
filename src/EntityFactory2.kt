/**
 * OBJECT DECLARATIONS
 * It is the method to build thread safe singleton class
 * singleton : making the object the only point of access for its properties
 */

object EntityFactory{
    fun create() = EntityFactory2("id", "name")
}

class EntityFactory2 constructor(val id:String, val name : String) {
    override fun toString(): String {
        return "id:$id name:$name"
    }
    // toString is to convert the inputs to a String without calling println
    // directly in the class
    // HERE : the main function calls the EntityFactory which then calls the
    // EntityFactory2 constructor, the EntityFactory2 class overrides the toString
    // to return a String to the main fn.
    // then the println fn is used.
}

fun main() {
    val entity = EntityFactory.create()
    println(entity)
}