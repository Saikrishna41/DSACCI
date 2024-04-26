import java.lang.StringBuilder


fun stringCompression(s: String): String {
    if (s.isEmpty()) return ""
    val comppressedStringBuilder = StringBuilder()
    var currChar = s[0]
    var charCount = 1
    for (i in 1 until s.length) {
        if (currChar == s[i]) {
            charCount++
        } else {
            comppressedStringBuilder.append(currChar)
            comppressedStringBuilder.append(charCount)
            currChar = s[i]
            charCount = 1
        }
    }
    comppressedStringBuilder.append(currChar)
    comppressedStringBuilder.append(charCount)
    val comppressedString = comppressedStringBuilder.toString()
    return if (comppressedString.length < s.length) {
        comppressedString
    } else {
        s
    }
}

fun main() {
    println(stringCompression("aabccccccaaa"))
}