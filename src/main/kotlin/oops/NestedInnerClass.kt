package oops

class Car(val carName: String) {
    inner class Engine(val engineName: String) {
        override fun toString(): String {
            return "$engineName engine in a $carName"
        }
    }
}

fun main() {
    val mazda = Car("mazda")
    val mazdaEngine = mazda.Engine("rotary")
    println(mazdaEngine) // > rotary engine in a mazda
}