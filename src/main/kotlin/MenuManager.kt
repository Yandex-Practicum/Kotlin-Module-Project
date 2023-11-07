import java.util.Scanner

/*класс, который содержит код:
По выводу пунктов меню;
По чтению пользовательского ввода;
По выполнению определённых операций на выбор пункта меню.*/
class MenuManager (private val items:MutableList<Item>){
    val scaner: Scanner = Scanner(System.`in`)
    var userInput: Int? = null
    //val items:MutableList<Item> = items

    fun showMenu() {
        println("Меню:")
        for (element in items) {
            println(" ${element.itemId}. ${element.title}")
        }
    }

    fun getUserInput():Int {
        //showMenu(items)
        do {
            while (!scaner.hasNextInt()) {
                val input = scaner.next()
                println("$input не является целым числом. Попробуйте снова.")
                showMenu()
            }
            userInput = scaner.nextInt()
            if (userInput!! < 0) {
                println("Число должно быть неотрицательным. Попробуйте снова.")
                showMenu()
            }

        }while (userInput!! <0)

        //scaner.close()
        for (count in items) {
            if ((count.itemId) == userInput) {
                count.inten.invoke()
            }
        }
        return userInput as Int
    }
    fun userInputValidationText(): String {
        var title:String =""
        do {
            if (scaner.hasNextLine()) {
                title = scaner.nextLine()
            }
        }while (title.equals(""))

        return title
    }

}
//создание меню

