package oops

import javax.naming.Context

open class Cls1(val i: Int){
    init {
        println(i)
    }
    fun m1() = println("m1 from Cls1")
}

abstract class AbstractClassConcept(i: Int):Cls1(10) {
    fun m2() = println("m2 from Abstract Class")
    abstract fun m3()

    init {
        println("AC $i")
    }

    //Singleton Object
    companion object{
        init {
            println("Hahah")
        }
        var p1 = "sdsds"
        operator fun invoke(i: Int) = Cls2()
    }
}

class Cls2 : AbstractClassConcept(20){
    override fun m3() {
        println("m3 from cls2")
    }

    operator fun invoke():Cls2{
        println("invoked")
        return Cls2()
    }
}

fun main() {
    var o = Cls2()
    println(o.let { it.m1(); it.m2(); it.m3() } )

    println(AbstractClassConcept.p1)
    //var o2 = AbstractClassConcept(10)

//    var o2 = Cls2()
//    o2()
//    println(o2.m3())


    //println()


}
