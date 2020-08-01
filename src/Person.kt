class Person( val firstName:String, val lastName:String) {
    //firstName and LastName are parameters that function/class needs

    /**
     * PROPERTIES
     */

    //   val first: String
    //   val last: String
    //     init {
    //        first = firstName
    //        last = lastName
    //     }
    //  init block initializes the class. {can be created multiple times
    //  , will be executed as per order}
    // ^^ Method 1 to declare and initialise properties {don't add val in constructor}


    //  val first: String = firstName
    //  val last: String = lastName
    // ^^ Method 2 to declare and initialise properties {don't add val in constructor}


    // Method 3 to declare and initialise a property is in the
    // constructor part of the class
    // adding the val keyword before parameters makes them properties directly


    /**
     * GETTERS AND SETTERS {USE ONLY WHEN CUSTOM BEHAVIOUR IS NEEDED}
     */
    var nickName : String? = null // "var" can be changed
        set(value) {
            field = value
            println("new nickname = $value")
        }
        // the set method is called when there is a change in the value of the
        // target variable.

        get() {
            println("value is $field")
            return field
        }
        // the get method is called when the value for a property is called.

    /**
     * CONSTRUCTORS
     */

    constructor() : this("jj", "rr") {
        print("$firstName, $lastName")
    }
    // this particular constructor can achieved by defining it in the
    // primary constructor like ths :-
    // class Person(val firstName:String = "jj", val lastName:String = "rr") {}
    // this sets default values for the parameters if nothing is received

    /**
     * METHODS
     */

    fun printInfo() {
        // checks if the nickname is null
        val nickToPrint = if(nickName != null) nickName else "No nickname"
        // OR
        // The above if-else check can also be done in the following way
        // val nickToPrint = nickName ?: "no nickname"
        // the "?:" is called an Elvis Operator which checks if the value{nickName} is null
        // and if it's true it uses the provided value instead otherwise
        // uses the same value "nickName"

        println("$firstName ($nickToPrint) $lastName")
    }

    /**
     * VISIBILITY MODIFIERS
     */

    // 1. Public means all classes and functions can use it
    // 2. Internal means all the classes and functions can use it present the same module
    // 3. Private means it is accessible to only the classes and functions/methods
    //    same file.
    // 4. Protected means it is accessible only inside that particular class
    //    ^ can be used in sub-classes of the class where it is defined

    // EXAMPLE : if we make the Person private, we wont be able to use it in any
    // other file's classes or functions


}