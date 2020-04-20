fun main(args: Array<String>) {
    var x: Int = 10
    while (x >= 0) {
        println(x)
        x -= 1
    }
    println(x)
    println()

    x = 10
    do {
        println(x)
        x -= 1
    } while (x > 0)
    println(x)
}