import java.util.*
import kotlin.math.abs

fun isAnagram(s1 : String, s2 : String) : Boolean {
    val len1 = s1.length
    val len2 = s2.length
    if (len1 != len2) return false
    val s1Arr = s1.toCharArray()
    val s2Arr = s2.toCharArray()
    Arrays.sort(s1Arr)
    Arrays.sort(s2Arr)
    var res = 0
    for (i in 0 until len1) {
        res = res xor s1[i] - 'a'
        res = res xor s2[i] - 'a'
    }
    return res == 0
}

fun main() {
    val s1 = "racecar"
    val s2 = "carrace"
    println(isAnagram(s1, s2))
}