import java.util.*

/**
 * Extension Functions & Properties
 */

enum class levelType1 {
    HELP, EASY, MEDIUM, HARD;

    fun getFormattedName() = name.toLowerCase().capitalize()
}

object unknown{
    fun create(type: levelType1) : EntityFactory3 {
        val id = UUID.randomUUID().toString()

        val name = when(type) {
            levelType1.EASY -> "Easy"
            levelType1.MEDIUM -> "Medium"
            levelType1.HARD -> "Hard"
            levelType1.HELP -> type.getFormattedName()
        }

        return when(type) {
            levelType1.EASY -> EntityFactory3.Easy(id, name)
            levelType1.MEDIUM -> EntityFactory3.Medium(id, name)
            levelType1.HARD -> EntityFactory3.Hard(id, name, 1.0f)
            levelType1.HELP -> EntityFactory3.Help
        }
    }
}
sealed class EntityFactory3() {
    // sealed classes cannot be used or inherited by any other
    // classes

    // we can create objects in sealed classes
    object Help : EntityFactory3(){
        val name = "help"
    }

    //classes which have access to sealed class
    // data classes are specially made to hold data and have some standard
    // functionality and utility functions which can be used.
    data class Easy(val id:String, val name:String) : EntityFactory3()
    data class Medium(val id:String, val name:String) : EntityFactory3()
    data class Hard(val id:String, val name:String, val multiplier:Float) : EntityFactory3()


}

// The following function is an extension to the EntityFactory3 medium class
// it is used to add a function to the class
fun EntityFactory3.Medium.printInfo() {
    println("Done. : $id : $name")
}

// The following is a property extension of the EntityFactory3 medium class
// we CANNOT initialise the value of the property because it has no backing
// field and therefore we use a getter
val EntityFactory3.Medium.info : String
    get() = "info"

fun main() {
    val entity = unknown.create(levelType1.EASY)

    // call the extended function {directly calling}
    EntityFactory3.Medium("id", "name").printInfo()

    //using smart cast to call extended functions
    // {calling through "unknown" object}
    val entity2 = unknown.create(levelType1.MEDIUM)
    if (entity2 is EntityFactory3.Medium) {
        entity2.printInfo()
        println(entity2.info)
    }
}