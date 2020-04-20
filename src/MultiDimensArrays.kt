fun main(args: Array<String>) {
    Array1D()
    Array2D()
}

fun Array1D() {
    var oneDArray = arrayOf<Int>()
    for (i in 0..9) {
        oneDArray += i
    }

    for (entry in oneDArray) {
        println(entry)
    }
}

fun Array2D() {
    var coordinateSystem = arrayOf<Array<String>>()
    for (i in 0..9) {
        var rowArray = arrayOf<String>()
        for (j in 0..9) {
            if (j > 0) {
                rowArray += ",($i / $j)"
            } else {
                rowArray += "($i / $j)"
            }

        }
        coordinateSystem += rowArray
    }

    for (row in coordinateSystem) {
        for (field in row) {
            print(field)
        }
        print("\n")
    }

    println(coordinateSystem[5])
}