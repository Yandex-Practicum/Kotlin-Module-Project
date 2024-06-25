class Items {
    private val itemList = mutableListOf<Item>()

    fun addItemToList(archive: Item) {
        itemList.add(archive)
    }

    fun getItems(): List<Item> {
        return itemList
    }

    fun getItemIndex(index: Int): Item? {
        return if (index in itemList.indices) {
            itemList[index]
        } else {
            null
        }
    }
}
