package BasicsTypes

fun main() {
    var s1 = "NipunShahdssddsdsdsdsdsdsaasasasasasaNipunShahdssddsdsdsdsdsdsaasasasasasa"
    var s2 = "NipunShahdssddsdsdsdsdsdsaasasasasasaNipunShahdssddsdsdsdsdsdsaasasasasasa"

    var a1 = arrayOf(1,2,4)
    var a2 = arrayOf(1,2,4)

    println(s1 == s2)
    println(s1 === s2)

    println(a1.contentEquals(a2))
    println(a1 === a2)
}