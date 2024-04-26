fun setZeros(matrix: Array<Array<Int>>) {
    val rows = matrix.size
    val cols = matrix[0].size
    val zeroRows = mutableSetOf<Int>()
    val zeroCols = mutableSetOf<Int>()
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (matrix[i][j] == 0) {
                zeroRows.add(i)
                zeroCols.add(j)
            }
        }
    }
    for (row in zeroRows) {
        for (j in 0 until cols) {
            matrix[row][j] = 0
        }
    }

    for (col in zeroCols) {
        for (j in 0 until rows) {
            matrix[j][col] = 0
        }
    }
}

fun printMatrix3(matrix: Array<Array<Int>>) {
    for (row in matrix) {
        for (cell in row) {
            print("$cell ")
        }
        println()
    }
}

fun main() {
    val matrix = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 0, 6),
        arrayOf(7, 8, 9)
    )
    println("Original matrix")
    printMatrix3(matrix)
    println("after transformation")
    setZeros(matrix)
    printMatrix3(matrix)
}