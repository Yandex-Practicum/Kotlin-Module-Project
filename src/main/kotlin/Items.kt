abstract class Item(
    open var name: String?
) {
    abstract fun show()

    abstract fun create(): Item
}

abstract class Items<T: Item> {
    abstract var itemsList: List<T>
    private val userInteraction: UserInteraction = UserInteraction()

    fun show() {
        if (itemsList.isEmpty()) {
            println("List is empty")
        } else {
            for (i in itemsList.indices) {
                println("$i. ${itemsList[i].name}")
            }
        }
    }

    fun choose(): T{
            println("Enter element number")
            val elementNumber = userInteraction.readCommand()
            if (elementNumber in itemsList.indices) {
                itemsList[elementNumber].show()
                return itemsList[elementNumber]
            } else {
                println("Wrong element number. Number should be in range from 0 to ${itemsList.size - 1}")
                choose()
            }
        return itemsList[elementNumber]
    }
}
