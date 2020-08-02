/**
 * COMPANION OBJECTS
 */
// COMPANION OBJECTS are just like any other class so they can implement classes

interface IdProvider {
    fun getID() : String
}

class Entity private constructor(val id : String) {
    // the constructor is marked private and cannot be used by anyone

    companion object : IdProvider{
        // the companion object implements the IdProvider interface
        override fun getID(): String {
            return "123"
        }

        const val id : String = "id"
        // const means a constant
        fun create() = Entity(getID())
    }
    // the above is an instance of an companion object that helps construct
    // a private class.

    // the above companion object can have a name like :
    // companion object Jay{
    //        fun create() = Entity("id")
    //    }
    // To access the above object we would need to use the following line :
    // val entity = Entity.Companion.Jay.create()

}

fun main() {
    val entity = Entity.Companion.create()
    val id  = entity.id
    // Since the constructor is private, we used a companion object
    // we can also write this statement like :
    // val entity = Entity.create()
    // this ^ will not work if used from java's class {interoperability}
}