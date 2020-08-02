import java.util.*

/**
 * DATA CLASSES
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

fun main() {
    val entity = unknown.create(levelType1.EASY)
    val entity1 = unknown.create(levelType1.EASY)

    if(entity == entity1) {
        println("equal")} else {println("not equal")}
    // "==" checks if their values are equal
    // "===" checks if they are the same reference
}