fun rotateMatrix(matrix: Array<Array<Int>>) {
    val n = matrix.size
    for (i in 0 until n) {
        for (j in i until n) {
            val temp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp
        }
    }
    //reverse each row
    for (i in 0 until n) {
        var left = 0
        var right = n - 1
        while (left < right) {
            val temp = matrix[i][left]
            matrix[i][left] = matrix[i][right]
            matrix[i][right] = temp
            left++
            right--
        }
    }

}

fun printMatrix(matrix: Array<Array<Int>>) {
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
        arrayOf(4, 5, 6),
        arrayOf(7, 8, 9)
    )
    println("Original matrix")
    printMatrix(matrix)
    rotateMatrix(matrix)
    println("rotated matrix")
    printMatrix(matrix)
}
