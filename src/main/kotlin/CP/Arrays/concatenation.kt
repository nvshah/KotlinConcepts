package CP.Arrays

fun getConcatenation(nums: IntArray): IntArray {
    return IntArray(nums.count()*2){nums[it%nums.count()]}
}

fun main() {
    println(getConcatenation(intArrayOf(1,2,3,4)).joinToString())
}