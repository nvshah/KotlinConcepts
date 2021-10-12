package BasicsTypes

fun main() {
    var a: Int = 10
    var b: Int = 10

    var o:Any = a  //Implicit boxing
    var o2:Any = b

    println(a.compareTo(b))
    println(a === b)   //true
    println(o === o2)  //true

    var a2: Int = 200
    var b2: Int = 200

    o = a2
    o2 = b2

    println(a === b)   //same as primitve types are compared on stack only
    println(o === o2)  //false as 200 is not cached(interned)

    var s1: String = "Hello"
    var s2: String = "Hello"
    var s3: String? = "Hello"

    println(s1 === s2)
    println(s1 === s3)


}