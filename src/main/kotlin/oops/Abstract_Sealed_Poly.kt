package oops

abstract class Animal{
    init {
        println("Inside Animal Initializing ${this}")
    }
    var count: Int = 10
    abstract fun consumeFood()
    open fun eat(){
        this.consumeFood()
    }

    fun getRef(): Animal = this
}

open class Dog: Animal(){
    init {
        println("Inside Dog Initializing ${this}")
    }
    override fun consumeFood() {
        println("Eating the Human")
    }

    open fun areEqual(){
        println(super.getRef() === this)
    }
}

class BullDog: Dog(){
    init {
        println("Inside Dog Initializing ${this}")
    }
    override fun areEqual(){
        println(super.getRef() === this)
    }
}

fun main() {
    val a:Animal = Dog()
    //println(a == a.getRef())

    //println(a === a.getRef())

    //a.eat()

    //(a as Dog).areEqual()

    val b:Animal = BullDog()
    //(b as BullDog).areEqual()

    //println(a.getRef() === b.getRef())  //False

    //println(a.getRef())
    //println(b.getRef())
}