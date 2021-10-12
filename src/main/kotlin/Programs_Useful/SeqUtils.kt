class SeqUtils {
    companion object {
        //removes the first occurrence of a given integer from a list of integers.
        fun removeOne(item: Int, list: List<Int>): List<Int> = ArrayList(list).also { it.remove(item) }

        //remove all occurence of a given integer from a list of integers
        fun remove(item: Int, list: List<Int>): List<Int> = ArrayList(list).also { it.removeAll { m -> m == item } }

        //calculates which characters occur in a string, as well as how often each of these characters occur
        fun occurrencesOfCharacters(text: String): Map<Char, Int> {
            val charCounter = mutableMapOf<Char, Int>()
            for (c in text) {
                if(c.isWhitespace()) continue
                val v = charCounter.getOrDefault(c, 0)
                charCounter[c] = v + 1
            }
            return charCounter
        }

        fun<T> accumulate(list: ArrayList<T>, func: (a:T, b:T)->T, startWith:T?): ArrayList<T>{
            if (!list.any()){
                return arrayListOf()
            }
            val result = arrayListOf<T>()
            val s = startWith?.let { func(startWith, list.first()) } ?: list.first()
            result.add(s)
            var last = s
            list.drop(1).forEach {
                val m = func(last, it)
                result.add(m)
                last = m
            }
            return result
        }
    }
}

fun main() {
    val l1 = arrayListOf(1,2,3,4,5)
    val a1 = SeqUtils.accumulate(l1, {a,b-> a+b}, 0)
    println(a1)
}