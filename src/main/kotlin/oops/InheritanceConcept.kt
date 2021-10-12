package oops

open class A{
    open var a: Int = 10;

    fun f1() = println(a)
}

open class B : A(){
    override var a: Int = 20
    open fun f2() = println(a)
}

class C: B(){
    override var a: Int = 30
    override fun f2() = println(a)
    fun f3() = println("From C")
}

fun main() {
    val o:A = B()

    o.f1()

    val o2:B = B()

    o2.f2()
    o2.f1()

    val o3:A = C()
    val o4:B = o3 as B

    o4.f2()

    val o5:A = B()
    val o6:C = o5 as C   //Exception - oops.B cannot be cast to class oops.C

    o6.f2()
    o6.f3()
}