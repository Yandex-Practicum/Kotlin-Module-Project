import java.util.Scanner

/*класс, который содержит код:
По выводу пунктов меню;
По чтению пользовательского ввода;
По выполнению определённых операций на выбор пункта меню.*/
class MenuManager (val items:List<Item> ){
    val scaner: Scanner = Scanner(System.`in`)
    var userInput: Int? = null

    fun userInputValidation(items:List<Item>) {
        сreateOptionsMenu(items)
        do {
            while (!scaner.hasNextInt()) {
                scaner.next()
                println("вы ввели не цифру попробуйте ввести еще раз")
                сreateOptionsMenu(items)
            }
            userInput = scaner.nextInt()
            if (userInput!! < 0) {
                println("такой цифры нет попробуйте ввести еще раз")
                сreateOptionsMenu(items)
            }

        }while (userInput!! <0)

        scaner.close()

        for (count in items) {
            if ((count.itemId) == userInput) {
                count.inten.invoke()
            }
        }
    }

}
//создание меню
fun сreateOptionsMenu(items:List<Item>) {
    for (element in items) {
        println(" ${element.itemId}. ${element.title}")
    }
}
