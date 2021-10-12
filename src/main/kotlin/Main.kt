import oops.Person


class C1(var n: Int){
    //Exceuted after init block
    constructor():this(10){
        println("Constructor 1")
    }
    //Executed First
    init {
        println("Initializer Block 1")
    }
}

fun main(){
    var c = C1()
    //main1()
}

fun main1() {
    val l1 = listOf(1, 2, 3, 4, 5, 2, 3, 2)
    val ml1 = SequenceUtils.removeOne(2, l1)
    val ml2 = SequenceUtils.remove(2, l1)

    println(ml1.joinToString())
    println(ml2.joinToString())

    val m1 = mapOf("1" to "one", "2" to "two")
    val m2 = mapOf("1" to "Single", "3" to "triple")

    val m3 = MapUtils.mergeMaps(m1, m2)
    println(m3)

    val s = "This is Nipun Shah".lowercase()
    println(SequenceUtils.occurrencesOfCharacters(s))

    val m4 = mapOf("1" to 1, "2" to 2, "3" to 3, "4" to 4, "11" to 1, "12" to 2, "21" to 1, "33" to 3, "45" to 5)
    val m5 = mapOf("1" to 1, "2" to 2, "3" to 3, "4" to 4, "45" to 5)
    println("m4 is Invertible (t/f) :- ${MapUtils.isInvertible(m4)}")
    println("m5 is Invertible (t/f) :- ${MapUtils.isInvertible(m5)}")

    val lt1 = listOf(1, 2, 3, 4, 4, 5, 2, 5, 6, 6, 6, 6, 8, 7, 9, 9, 10)
    println("Unique Count of each member: ${MapUtils.counter(lt1)}")

    val p1 = Person1("Manoj")
    val p2 = Person1("Manoj")
    val p3 = p2

    println(p1 == p2)
    println(p1 === p2)
    println(p2 == p3)
    println(p2 === p3)

    //destructuring example for data class
    val p4 = Person("Mitesh", 20, "Male")
    val (name, age) = p4

    println("${name} ${age}")
}

class Person1(val name: String)