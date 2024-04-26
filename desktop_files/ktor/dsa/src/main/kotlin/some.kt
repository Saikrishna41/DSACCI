

fun isUnique(s : String) : Boolean {
    var checker = 0
    for (c in s) {
        val bitAtIndex = c -'a'
        if (checker and (1 shl bitAtIndex) > 0) return false
        checker = checker or (1 shl bitAtIndex)
    }
    return true
}

fun main() {
    
}