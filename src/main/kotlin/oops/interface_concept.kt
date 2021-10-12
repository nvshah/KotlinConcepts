package oops

enum class Direction {
    LEFT, RIGHT
}
interface DirectionalVehicle {
    fun accelerate()
    fun stop()
    fun turn(direction: Direction)
    fun description(): String
}

//--- DEFAULT metHOD params INTERFACE
interface OptionalDirectionalVehicle {
    fun turn(direction: Direction = Direction.LEFT)
}

class OptionalDirection: OptionalDirectionalVehicle {
    override fun turn(direction: Direction) {
        println(direction)
    }
}

//--- DEFAULT metHOD IMPLEMENTATION INTERFACE
interface SpaceVehicle {
    fun accelerate()
    fun stop() {
        println("Whoa, slow down!")
    }
}

class LightFreighter: SpaceVehicle {
    override fun accelerate() {
        println("Proceed to hyperspace!")
    }
}

class Starship: SpaceVehicle {
    override fun accelerate() {
        println("Warp factor 9 please!")
    }
    //You can override method impl
    override fun stop() {
        super.stop()
        println("That kind of hurt!")
    }
}

// Properties :- Either abstract or implemented (No backing fields are available for interface)
interface VehicleProperties {
    val weight: Int // abstract
    val name: String
        get() = "Vehicle"
}
class Car2: VehicleProperties {
    //! Note here weight is overriden as field
    override val weight: Int = 1000
}
class Tank: VehicleProperties {
    //! Note here weight is overriden as getter
    override val weight: Int
        get() = 10000
    override val name: String
        get() = "Tank"
}

//---> EXTENDING the Interface
interface Vehicle{
    fun stop()
    fun accelerate()
}
interface WheeledVehicle: Vehicle {
    val numberOfWheels: Int
    var wheelSize: Double
}
class Bike: WheeledVehicle {
    var peddling = false
    var brakesApplied = false
    override val numberOfWheels = 2
    override var wheelSize = 622.0
    override fun accelerate() {
        peddling = true
        brakesApplied = false
    }
    override fun stop() {
        peddling = false
        brakesApplied = true
    }
}

fun main() {
    val car = OptionalDirection()
    car.turn()
    car.turn(Direction.RIGHT)

    val falcon = LightFreighter()
    falcon.accelerate()
    falcon.stop()

    val enterprise = Starship()
    enterprise.accelerate() // > Warp factor 9 please!
    enterprise.stop()
}