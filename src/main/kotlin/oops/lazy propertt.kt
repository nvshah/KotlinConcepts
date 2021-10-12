package oops

class Circle(var radius: Double = 0.0) {
    val pi: Double by lazy {
        ((4.0 * Math.atan(1.0 / 5.0)) - Math.atan(1.0 / 239.0)) * 4.0
    }
    val circumference: Double
        get() = pi * radius * 2
}

class Oval{
    lateinit var circle: Circle
}

//Extension Propertu
val Circle.diameter:Double
    get() = 2.0 * radius // Extension properties do not have backing fields, so you can only define them using custom accessors.

fun main(){
    val circle = Circle(5.0) // got a circle, pi has not been run

    val circumference = circle.circumference // 31.42, Now pI has been initialised & assigned & allocated

    val unitCircle = Circle(1.0)
    println(unitCircle.diameter) // > 2.0
}