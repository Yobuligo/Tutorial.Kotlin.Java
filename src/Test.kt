class Person(var firstname: String, var lastname: String) {
    fun displayPerson() {
        println("$firstname $lastname")
    }
}

fun main(args: Array<String>) {
    val myName: String = "Peter"
    var encrypted: String = ""
    var decrypted: String = ""

    for (index in myName.indices) {
        val letter: Char = myName[index] + 3
        encrypted += letter
    }

    for (index in encrypted.indices) {
        var letter: Char = encrypted[index] - 3
        decrypted += letter
    }

    println("encrypted $encrypted")
    println("decrypted $decrypted")

    println()
    for (index in myName.indices) {
        print(index)
        print(myName[index])
    }

}

