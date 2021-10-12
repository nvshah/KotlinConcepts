package oops

sealed class Shape {
    class Circle(val radius: Int): Shape()
    class Square(val sideLength: Int): Shape()
    fun size(): Int {
        return when (this) {
            is Shape.Circle -> this.radius
            is Shape.Square -> this.sideLength
        }
    }
}

/**
 * Note Sealed Class Can Have Multiple Instance Of each subclass case Which is not possible in Enum Classes
 */
sealed class AcceptedCurrency {
    abstract val valueInDollars: Float
    class Dollar: AcceptedCurrency() {
        //Shadowing
        override val valueInDollars = 1.0f
    }
    class Euro: AcceptedCurrency() {
        override val valueInDollars = 1.25f
    }
    class Crypto: AcceptedCurrency() {
        override val valueInDollars = 2534.92f
    }
    // leave the existing name property alone
}

//-------AnotHER EXAMPLE

sealed class C1 {
    open var number: Int = 10
}

class C2 : C1(){
    override var number: Int = 20
}


data class Human(
    val name: String,
    val gender: Gender
){
    sealed class Gender{
        object Male: Gender()
        object Female: Gender()
    }
}



fun main() {
    val circle1 = Shape.Circle(4)
    val circle2 = Shape.Circle(2)
    val square1 = Shape.Square(4)
    val square2 = Shape.Square(2)

    println(circle1.size()) //4
    println(square2.size()) //2

}