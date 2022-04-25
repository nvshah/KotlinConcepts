package FP

fun calculateEven1() {
    var result = 0
    (0..20).forEach {
        if (it % 3 == 0) return
        if (it % 2 == 0) result += it
    }
    println(result)
}

fun calculateEven2() {
    var result = 0
    (0..20).forEach {
        if (it % 3 == 0) return@forEach
        if (it % 2 == 0) result += it
    }
    println(result)
}

fun calculateEven3() {
    var result = 0
    (0..20).forEach loop@{
        if (it % 3 == 0) return@loop
        if (it % 2 == 0) result += it
    }
    println(result)
}

fun calculateEven4() {
    var result = 0
    (0..20).forEach(fun(value) { if (value % 3 == 0) return
        if (value % 2 == 0) result += value
    })
    println(result)
}