package screens

import model.MenuItem

abstract class ChooseScreenAbstract <T> {
    abstract val title: String
    abstract val createItemLine: String
    abstract val createItemOperation: () -> Unit
    abstract val chooseItemOperation: (element: T) -> Unit
    abstract val getElementList: (parentId: Int) -> List<T>
    fun start(parentId: Int) {
        while (true) {
            val menuItems: MutableList<MenuItem> = mutableListOf()
            menuItems.add(MenuItem(1, createItemLine, operation = createItemOperation))
            var itemIndex = 2
            for (element in getElementList(parentId)) {
                menuItems.add(MenuItem(itemIndex,
                    element.toString(),
                    operation = { chooseItemOperation(element) }))
                itemIndex++
            }
            menuItems.add(MenuItem(itemIndex, "Выход", null))
            MenuUtils.printMenu(title, menuItems)
            val choice = MenuUtils.getChoice(menuItems)
            if (choice != null) {
                if (choice == itemIndex) return
                MenuUtils.goToMenuItem(choice, menuItems)
            }
        }
    }

}