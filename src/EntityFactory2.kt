import java.util.*

/**
 * OBJECT DECLARATIONS
 * It is the method to build thread safe singleton class
 * singleton : making the object the only point of access for its properties
 */


/**
 * ENUM CLASS
 * It is a named list of constants
 */

enum class levelType {
    EASY, MEDIUM, HARD;

    fun getFormattedName() = name.toLowerCase().capitalize()
    // function to generate name of the enum constant which is formatted
}
// we define 3 constants which will be used by other classes.

object EntityFactory{
    fun create(type: levelType) : EntityFactory2 {
        val id = UUID.randomUUID().toString()
        // the above line assigns a random id and changes it to String

        val name = when(type) {
            levelType.EASY -> "Easy"
            // we can use type.name where type is the input parameter and type is a fn.
            levelType.MEDIUM -> "Medium"
            // we can also use the function created in enum class "getFormattedName"
            // like - levelType.MEDIUM -> getFormattedName
            levelType.HARD -> "Hard"
        }
        // we are using enum class to map values to different constants

        return EntityFactory2(id, name)
    }
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
    val entity = EntityFactory.create(levelType.EASY)
    println(entity)


}