package Screen

import Menu

class Screen(val name: String, val menu: Menu) {
    fun showMenu() = println(menu)

    fun activityCreate(massage: String): String {

        println("activity created")
        return this.name
    }

    fun activityChose(massage: String): String {
        this.menu.choseActivity()
        println("activity chosen")
        return this.name
    }


}