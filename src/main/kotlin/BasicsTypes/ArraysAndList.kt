package BasicsTypes

//import oops.Animal
//import oops.Shape

////Error -> Inheritance is only allowed within same package (i.e logical namespace)
//class A: Shape(){
//
//}

fun main() {
    val a1 = arrayOf(1,2,3,4,5)
    val a2 = intArrayOf(1,2,3,4,5)

    println(a1)
    println(a2)

    val a3 = a2.toTypedArray()  //Boxing
    println(a1.contentEquals(a2.toTypedArray()))

    val l1 = listOf(1,2,3,4,5)
    val l2 = arrayListOf(1,2,3,4,5)

    l2.removeAt(3)
    println(l2)
}