package BasicsTypes

// ----- Extension Function ------
fun <T> List<T>.toBulletedList(): String {
    val separator = "\n - "
    return this.joinToString(
        separator,
        prefix = separator,
        postfix = "\n"
    ) { "$it" }
}

// Own Generic Constraints

// 1
class Mover<T : Checkable>(
    // 2
    thingsToMove: List<T>,
    val truckHeightInInches: Int = (12 * 12)
) {
    private var thingsWhichFailedCheck = mutableListOf<T>()

    // 3
    private var thingsLeftInOldPlace = mutableListOf<T>()
    private var thingsInTruck = mutableListOf<Any>()
    private var thingsInNewPlace = mutableListOf<T>()

    // 4
    init {
        thingsLeftInOldPlace.addAll(thingsToMove)
    }

    // 5
    fun moveEverythingToTruck(startingContainer: Container<T>?) {
        var currentContainer = startingContainer
        while (thingsLeftInOldPlace.count() > 0) {
            val item = thingsLeftInOldPlace.removeAt(0)
            if (item.checkIsOK()) {
                // if a container is provided, you provide logic to pack the item into a container
                if (currentContainer != null) {
                    //container is full
                    if (!currentContainer.canAddAnotherItem()) {
                        moveContainerToTruck(currentContainer)
                        currentContainer = currentContainer.getAnother()
                    }
                    //add item in container i.e packing
                    currentContainer.addItem(item)
                    println("Packed Your item: $item")
                } else {
                    thingsInTruck.add(item)
                    println("Moved your $item to the truck!")
                }
            } else {
                thingsWhichFailedCheck.add(item)
                println("Could not move your $item to the truck :[")
            }
        }
        currentContainer?.let { moveContainerToTruck(it) }
    }

    @Suppress("UNCHECKED_CAST")
    fun moveEverythingIntoNewPlace() {
        //val breakableThings = thingsInTruck.filterIsInstance<BreakableThing>() //Works but we want of type T or Container
        //val containers = thingsInTruck.filterIsInstance<Container<*>>() // Works but again Container of List<Any?>

        //val items = thingsInTruck.filterIsInstance<T>() //Error

        ///it needs to get a container of a
        //particular type - but it doesn't actually matter under the hood what type it is.
        val containers = thingsInTruck.filterIsInstance<Container<T>>()
        for (container in containers) {
            moveContainerFromTruck(container)
        }
        while (thingsInTruck.isNotEmpty()) {
            val item = thingsInTruck.removeAt(0) as? T
            if (item != null) {
                tryToMoveItemIntoNewPlace(item)
            } else {
                println("Something in the truck was not of the expected generic type:$item")
            }
        }
    }

    private fun tryToMoveItemIntoNewPlace(item: T) {
        if (item.checkIsOK()) {
            thingsInNewPlace.add(item)
            println("Moved your $item into your new place!")
        } else {
            thingsWhichFailedCheck.add(item)
            println("Could not move your $item into your new place :[")
        }
    }


    private fun moveContainerToTruck(container: Container<T>) {
        thingsInTruck.add(container)
        println("Moved a container with your ${container.contents().toBulletedList()} to the truck !")
    }

    private fun moveContainerFromTruck(container: Container<T>) {
        thingsInTruck.remove(container)
        while (container.canRemoveAnotherItem()) {
            val itemInContainer = container.removeItem()
            println("Unpacked your $itemInContainer!")
            tryToMoveItemIntoNewPlace(itemInContainer)
        }
    }

    fun finishMove() {
        println("OK, we're done! We were able to move your:${thingsInNewPlace.toBulletedList()}")
        if (!thingsWhichFailedCheck.isEmpty()) {
            println("But we need to talk about your:${thingsWhichFailedCheck.toBulletedList()}")
        }
    }
}

interface Checkable {
    fun checkIsOK(): Boolean
}

class CheapThing(val name: String) : Checkable {
    override fun toString(): String {
        return name
    }

    override fun checkIsOK(): Boolean = true
}

class BreakableThing(
    val name: String,
    var isBroken: Boolean = false
) : Checkable {
    fun smash() {
        isBroken = true
    }

    override fun checkIsOK(): Boolean {
        return !isBroken
    }

    override fun toString(): String {
        return name
    }
}

// 1
interface Container<T> {
    fun canAddAnotherItem(): Boolean
    fun addItem(item: T)
    fun canRemoveAnotherItem(): Boolean
    fun removeItem(): T
    fun getAnother(): Container<T>
    fun contents(): List<T>
}

///Container to Hold Breakable Things
class CardboardBox : Container<BreakableThing> {
    private var items = mutableListOf<BreakableThing>()
    override fun contents(): List<BreakableThing> {
        return items.toList()
    }

    override fun canAddAnotherItem(): Boolean {
        return items.count() < 2
    }

    override fun addItem(item: BreakableThing) {
        items.add(item)
    }

    override fun canRemoveAnotherItem(): Boolean {
        return items.isNotEmpty()
    }

    override fun removeItem(): BreakableThing {
        val lastItem = items.last()
        items.remove(lastItem)
        return lastItem
    }

    override fun getAnother(): Container<BreakableThing> {
        return CardboardBox()
    }
}

fun main() {
    val l1 = listOf("1", "2", "4")
    println(l1.toBulletedList())

    //2
    val cheapThings = listOf(
        CheapThing("Cinder Block table"),
        CheapThing("Box of old books"),
        CheapThing("Ugly old couch")
    )
    val cheapMover = Mover(cheapThings)

    cheapMover.apply {
        this.moveEverythingToTruck(null)
        this.moveEverythingIntoNewPlace()
        this.finishMove()
    }

    val television = BreakableThing("Flat-Screen Television")
    val breakableThings = listOf(
        television,
        BreakableThing("Mirror"),
        BreakableThing("Guitar")
    )
    val expensiveMover = Mover(breakableThings)

    expensiveMover.apply {
        this.moveEverythingToTruck(CardboardBox())
        television.smash() //while transporting telivision was smashed
        this.moveEverythingIntoNewPlace()
        this.finishMove()
    }

}