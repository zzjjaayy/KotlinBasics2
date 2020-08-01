class FancyInfoProvider : BasicInfoProvider(){
    // by default in Kotlin, classes and closed OR final
    // i.e can't be inherited from
    // therefore the class that needs to be inherited needs to be "open"

    // Since this class in inherited we can override all its functions
    override val providerInfo: String
        get() = "Fancy"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println()
    }

    // To access or override the properties, we need to mark them open
    override val sessionPrefix: String
        get() = "Fancy Session"

}