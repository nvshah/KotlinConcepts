//1. Singleton --------------------
object Avengers {
    var _name: String = ""

    //NOTE : here if used `var` instead of val then it will give error
    //       because in Singleton or Companion mutable getter is not allowed it needs setter as well
    val name
        get() = _name

    fun m1(name: String) {
        _name = name
        println("Hola $name")
    }
}
//utilise
//var ironMan = Avengers.m1("Tony Stark")

//2. Factory --------------------
enum class Animes {
    Naruto,
    OnePiece,
    DeathNote
}

sealed class Anime {
    //static objects of same class only
    object NarutoAnime : Anime()
    object OnePieceAnime : Anime()
    object DeathNoteAnime : Anime()
}

object AnimeFactory {
    fun getAnime(anime: Animes) = when (anime) {
        Animes.DeathNote -> Anime.DeathNoteAnime
        Animes.OnePiece -> Anime.OnePieceAnime
        Animes.Naruto -> Anime.NarutoAnime
    }
}

//Utilise
// var l = AnimeFactory.getAnime(Animes.Naruto)

//3. Builder --------------------
class TTRacquet private constructor(val rubber: String, val gum: Boolean, val wood: String) {
    class Builder {
        private var rubber = "Stag"
        private var gum = false
        private var wood = "Stag"

        fun applyRubber(rubber: String) = apply { this.rubber = rubber }
        fun applyGum(gum: Boolean) = apply { this.gum = gum }
        fun applyWood(wood: String) = apply { this.wood = wood }

        fun build() = TTRacquet(rubber, gum, wood)
    }
}
//Utilise
// var racquet = TTRacquet.Builder().applyRubber("Stiga").build()

//4. Facade --------------------

//5. Dependency Injection --------

//6. Adapter -------------------