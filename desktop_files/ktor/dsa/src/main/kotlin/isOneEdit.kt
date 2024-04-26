import kotlin.math.abs

fun isOneEditAway(s1 : String, s2 : String) : Boolean {
    val len1 = s1.length
    val len2 = s2.length
    if (abs(len1 - len2) > 1) return false
    var edits = 0
    var i = 0
    var j = 0
    while (i < len1 && j < len2) {
        if (s1[i] != s2[j]) {
            if(edits == 1) return false
            if (len1 > len2) {
                i++
            }
            else if (len2 > len1) {
                j++
            }
            else {
                i++
                j++
            }
            edits++
        }
        else {
            i++
            j++
        }
    }
    if (i < len1 || j < len2) edits++
    return edits <= 1
}

fun main() {
    val s1 = "pale"
    val s2 = "palesf"
    println("the result is ${isOneEditAway(s1,s2)}")
}