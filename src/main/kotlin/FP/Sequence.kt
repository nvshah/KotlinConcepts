package FP

fun main() {
    // Memoization technique

    val factorial = generateSequence(1 to 1) {
        it.first + 1 to it.second * (it.first + 1) }
    println(factorial.take(10).map { it.second }.last())


    val fibonacci = generateSequence (0 to 1){
        it.second to it.first + it.second
    }

    println(fibonacci.take(5).map { it.first }.toList())
}