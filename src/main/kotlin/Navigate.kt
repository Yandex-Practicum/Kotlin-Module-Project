/*
import java.util.Scanner

open class Page {
    fun show(list: MutableList<T>, title: String, item: String){
        while (true) {
            println(
                "$title \n" +
                        "\"q\" вернуться в предыдущее меню \n" +
                        "0. Cоздать $item"
            )
            for (i in list)
                println("${list.indexOf(i) + 1}. ${i.name}")

            val input = Scanner(System.`in`).nextLine()
            if (input == "q") break
            else if (input == "0") this.createNote()
            else list[input.toInt() - 1].show()
        }
    }
}
*/
