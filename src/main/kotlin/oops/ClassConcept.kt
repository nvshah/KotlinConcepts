package  oops

data class Person (val name:String, val age:Int, val gender:String)

// 2 Companion(Static)-------------
class Scientist private constructor(
    val id: Int,
    val firstName: String,
    val lastName: String) {
    companion object {
        var currentId = 0
        fun newScientist(firstName: String, lastName: String): Scientist {
            currentId += 1
            return Scientist(currentId, firstName, lastName)
        }
    }
    var fullName = "$firstName $lastName"
}

// 3. Singleton-------------------
object ScientistRepository {
    val allScientists = mutableListOf<Scientist>()
    fun addScientist(student: Scientist) {
        allScientists.add(student)
    }
    fun removeScientist(student: Scientist) {
        allScientists.remove(student)
    }
    fun listAllScientists() {
        allScientists.forEach {
            println("${it.id}: ${it.fullName}")
        }
    }
}

fun main(){
    val emmy = Scientist.newScientist("Emmy", "Noether")
    val isaac = Scientist.newScientist("Isaac", "Newton")
    val nick = Scientist.newScientist("Nikola", "Tesla")
    ScientistRepository.addScientist(emmy)
    ScientistRepository.addScientist(isaac)
    ScientistRepository.addScientist(nick)
    ScientistRepository.listAllScientists()
}