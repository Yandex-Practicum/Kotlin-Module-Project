import java.util.Scanner

class MenuNavi(val name: String) {

    val menuItems = mutableListOf<Pair<String, () -> Unit>>()

    fun funMenu(exit:() -> Unit = {}){
        while (true) {
        println("$name:")

        menuItems.forEachIndexed { index, pair ->
            println("$index. ${pair.first}")
        }
        if (menuItems.size !== 0) println("${menuItems.size}. Выход") else println("1. Выход")

        val i = Scanner(System.`in`).nextLine().toIntOrNull()
            if (i != null) {
                if (i < menuItems.size) {
                    menuItems[i].second()
                    return}
            }
            if (i == menuItems.size) {
                exit()
            } else {
                println("Неверный ввод, попробуйте снова")
            }
        }
    }
}