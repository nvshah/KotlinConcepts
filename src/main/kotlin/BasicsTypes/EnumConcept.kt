package BasicsTypes

import java.util.Calendar


enum class DayOfTheWeek(val isWeekend: Boolean = false) {
    Sunday(true),
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday(true);

    companion object{
        fun today():DayOfTheWeek{
            // 1
            val calendarDayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
            // 2
            var adjustedDay = calendarDayOfWeek - 1
            // 3
            val days = DayOfTheWeek.values()
            if (adjustedDay < 0) {
                adjustedDay += days.count()
            }
            // 4
            val today = days.first { it.ordinal == adjustedDay }
            return today
        }
    }
    fun daysUntil(other: DayOfTheWeek) : Int {
        if (this.ordinal < other.ordinal) { // 1
            return other.ordinal - this.ordinal // 2
        } else {
            return other.ordinal - this.ordinal +
                    DayOfTheWeek.values().count() //3
        }
    }
}


//enum class Team(val )

fun main() {
    for(day in DayOfTheWeek.values()){
        println("day # -> ${day.ordinal}, ${day.name}, Weekend : ${day.isWeekend}")
    }

    println(DayOfTheWeek.valueOf("Monday"))

    val today = DayOfTheWeek.today()
    val isWeekend = "It is${if (today.isWeekend) "" else " not"} the weekend"
    println("It is $today. $isWeekend.")

    val secondDay = DayOfTheWeek.Monday
    val daysUntil = today.daysUntil(secondDay)
    println(daysUntil)
}