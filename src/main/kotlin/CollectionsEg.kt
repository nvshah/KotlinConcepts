fun main(){
    //Arrays

    //1. initializer - non-primitive (Boxed) types
    val a1 = arrayOf(2,3,4,5,6)

    //2. Array(size, factory)
    val a2 = Array(5, {6})
    val a23 = Array<Int>(5){6}

    //PRIMITIVE Types (Non-Boxed) & faster comparatively
    val oddNumbers = intArrayOf(1, 3, 5, 7) // {floatArrayOf, booleanArrayOf, doubleArrayOf}

    //Here its primitive types & get initialized with default value
    val zeros = DoubleArray(4)

    //Convert Boxed -> Primitve
    val otherOddNumbers = arrayOf(1, 3, 5, 7).toIntArray()

    //LISTS
    val l1 = listOf(1,2,3,4) //ArrayList
    val l2 = mutableListOf(1,2,3)


    //MAPS

    //Mixed Types are allowed
    val m1 = mutableMapOf(1 to 1, "2" to 2, 3 to "3")
    //m1 += 4 to 4 //Wrong -> Values need to be of same types for this to work
    println("${m1["2"]} ${m1[3]}")

    val m2 = mutableMapOf(1 to "1", "2" to "2", "3" to "3")
    m2 += 4 to "4" //As long as all values are String it will work

    // Sort Custom
    val ranks = arrayOf(1,2,3,4)
    ranks.sortWith(compareBy{-it})

    println(ranks.joinToString()) // 4, 3, 2, 1


    // ---- Amazing Mutable List

    var lst1 = listOf(1,2,3)
    var lst2: List<Number> = lst1 //valid as List<> takes in as generic type

    var lst3 = mutableListOf(1,2,3)
    // Invalid as MutableList<> both accepts & return parameter of type T
    // var lst4: MutableList<Number> = lst3
}