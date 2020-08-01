/**
 * INTERFACE
 * NOTE :
 * in Kotlin we don't need a new file for a new class or interface
 * so we can make this class in the same file
 */

interface PersonInfoProvider {
    fun printInfo(person: Person)
    // a Person object is needed as an input parameter

    val providerInfo : String
    // we can declare a variable in an interface but we can not initialise it
    fun printInfo2(person: Person) {
        println(providerInfo)
    }
}

interface SessionInfoProvider {
    fun getSessionID() : String
}


/**
 * CLASS IMPLEMENTING INTERFACES
 */

// The class that implements an interface need to implement all its interfaces
// Or we can declare it as an abstract class by adding the "abstract" keyword
// But if we declare the class as abstract, we WON'T be able to create an
// instance of it with the "val provider = BasicInfoProvider"

class BasicInfoProvider : PersonInfoProvider, SessionInfoProvider{
// The above class declaration states that it is implementing the
// PersonInfoProvider using the colon sign and comma separating the interfaces

    override fun printInfo(person: Person) {
        // override keyword is important as its absence gives an compile error
        println("Print anything")
    }
    // this implementation can be added in the Interface and not here
    // and code will compile without errors

    override fun printInfo2(person: Person) {
        super.printInfo2(person)
        println("Test")
        // we can override an already implemented function
        // but will have to add the "super" function
    }


    override val providerInfo: String
        get() = "BasicInfoProvider"
        //initialising the variable declared in the interface

    override fun getSessionID(): String {
        return "Session"
    }
    //implements the function of the SessionInfoProvider Interface

}


fun main() {
    val provider = BasicInfoProvider()
    provider.printInfo(Person())
    provider.getSessionID()
    // called an function of the class by providing an empty instance of the
    // Person class which is required as a parameter

    checkTypes(provider)
}

/**
 * TYPE CHECKING AND CASTING
 */


    fun checkTypes(infoProvider: PersonInfoProvider){
        if(infoProvider is SessionInfoProvider) {
            println("Is Session Provider")
        } else {
            println("is not")
            (infoProvider as SessionInfoProvider).getSessionID()
            //the above line shows type casting
            // where the infoProvider if isn't a SessionInfoProvider
            // can be casted as one to use its properties.
            // Kotlin supports Smart Cast which means you don't need to
            // explicitly mention the interface always like -
            // infoProvider.getSessionID()  => this statement will work the same.
        }
    // The function is to check whether the class implements the SessionInfoProvider
    // the "is" provider tells whether it is implemented or not.


    //TYPE CASTING

}
