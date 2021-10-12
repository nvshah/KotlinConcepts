package oops

import kotlin.properties.Delegates

//1------------Observable Delegated Properties----------------------
class DelegatedLevel(val id: Int, var boss: String) {
    companion object {
        var highestLevel = 1
    }
    var unlocked: Boolean by Delegates.observable(false) {
            _, old, new ->
        if (new && id > highestLevel) {
            highestLevel = id
        }
        println("$old -> $new")
    }
}

fun main1(){
    val delegatedlevel1 = DelegatedLevel(id = 1, boss = "Chameleon")
    val delegatedlevel2 = DelegatedLevel(id = 2, boss = "Squid")
    println(DelegatedLevel.highestLevel) // 1
    delegatedlevel2.unlocked = true
    println(DelegatedLevel.highestLevel) // 2
}

//2------------limiting a variable----------------------

class LightBulb{
    companion object{
        const val maxCurrent = 40
    }
    var current by Delegates.vetoable(0) {
            _, _, new ->
        if (new > maxCurrent) {
            println("Current too high, falling back to previous setting.")
            false
        } else {
            true
        }
    }
}

fun main(){
    val light = LightBulb()
    light.current = 50
    var current = light.current // 0
    light.current = 40
    current = light.current // 40
}