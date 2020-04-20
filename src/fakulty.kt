fun main(args: Array<String>) {
    var n: Int = 12
    var faculty: Int = n

    while (n > 1) {
        n -= 1
        faculty *= n
    }

    println(faculty)
}