import java.util.Scanner

data class MenuItem (
    val name : String,
    val activ : () -> Unit
)

class Menu(val title : String) {
 val item = mutableListOf<MenuItem>()
    val scanner = Scanner(System.`in`)
    var Running = true

    fun addItem(name: String, activ: () -> Unit){
        item.add(MenuItem(name, activ))

    }

    fun show() {
        while (Running) {
            println(title)
            item.forEachIndexed { index, item -> println("$index. ${item.name}") }

            println("Выберите действие")

            val read = scanner.nextLine().trim()
            val index = read.toIntOrNull()
            if (index == null) {
                println("Введите число")
                continue
            }
            if (index < 0 || index >= item.size) {
                println("Введите корректное число")
                continue
            }
            item[index].activ.invoke()

        }


    }

    fun end(){
        Running = false
    }

    fun readText() : String{
        while(true){
            val text = scanner.nextLine().trim()
            if (text.isNotEmpty()) {
                return text
            }
            println("Текст не должен быть пустым")
        }
    }

}