fun main() {
    val bowser = Animal("Bowser", 20.0, 13.5);
    bowser.getInfo()

    val spot = Dog("Spot", 20.0, 14.5, "Paul Smith")
    spot.getInfo()

    val tweety = Bird("Tweety", true)
    tweety.fly(10.0)

    //mark a variable as null value (using the ?)
    var nullVal: String? = null;

    fun returnNull(): String? {
        return null
    }

    var nullVal2 = returnNull()
    if (nullVal2 != null) {
        println("${nullVal2.length}")
    }

    var nullVal3 = nullVal2!!.length

    var nullVal4: String = returnNull() ?: "No name"
}

/*
Example for class
 */
open class Animal(
    val name: String,
    var height: Double,
    var weight: Double
) {
    init {
        val regex = Regex(".*\\d+.*")
        require(!name.matches(regex)) { "Animal name can'n contain numbers" } //
        require(height > 0) { "Height must be greater than zero" }
        require(weight > 0) { "Weight must be greater than zero" }
    }

    open fun getInfo(): Unit {
        println("$name is $height tall and weights $weight")
    }
}

/*
Example Inheritance
 */
class Dog(name: String, height: Double, weight: Double, var owner: String) : Animal(name, height, weight) {

    override fun getInfo() {
        println("$name is $height tall and weights $weight and is owned by $owner")
    }

}

/*
Example Interface
 */
interface IFlyable {
    var flies: Boolean
    fun fly(distMile: Double): Unit
}

class Bird(val name: String, override var flies: Boolean) : IFlyable {
    override fun fly(distMile: Double) {
        if (flies) {
            println("$name flies $distMile miles")
        }
    }
}