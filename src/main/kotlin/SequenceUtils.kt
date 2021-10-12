class SequenceUtils {
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

    }
}

class MapUtils {
    companion object {
        fun mergeMaps(map1: Map<String, String>, map2: Map<String, String>):
                Map<String, String> {
            var m = mutableMapOf<String, String>()
            for (k in map1.keys.minus(map2.keys)) {
                m[k] = map1[k]!!
            }
            for (k in map2.keys) {
                m[k] = map2[k]!!
            }
            return m
        }

        // returns the count of unique items in collection
        fun <T> counter(iter: Iterable<T>): Map<T, Int>{
            val counter = mutableMapOf<T, Int>()
            for (e in iter) {
                val cnt = counter.getOrDefault(e, 0)
                counter[e] = cnt + 1
            }
            return counter
        }

        // returns true if all of the values of a map are unique.
        fun isInvertible(map: Map<String, Int>): Boolean{
            val ctr = mutableSetOf<Int>()
            for(v in map.values){
                if(v in ctr) return false
                ctr.add(v)
            }
            return true
        }
    }
}