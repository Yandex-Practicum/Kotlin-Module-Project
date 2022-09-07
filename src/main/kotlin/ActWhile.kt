import java.util.*
import kotlin.collections.ArrayList

interface ActWhile {

    fun askAction(): String {
        val scanner = Scanner(System.`in`)
        println("Введите номер подпункта меню:")
        val number = scanner.nextLine()
        return number
    }

    fun askActionWithExit(text: String): String {
        println("$text (или 'q' для отмены)")
        val scanner = Scanner(System.`in`)
        val number = scanner.nextLine()
        return number
    }

    fun <T : Common> userResultAction(dataList: ArrayList<T>) {
        while (true) {
            val number = askAction()
            val num = number.toIntOrNull()

            if (num != null && num <= dataList.size + 1) {
                if (num == dataList.size + 1) {
                    finishAction()
                    break
                }

                if (num == 0)
                    createAction()
                else
                    showAction(num)

            } else {
                wrongNumberAction(number)
            }
        }
    }

    fun finishAction(){}
    fun createAction()
    fun showAction(num: Int)
    fun wrongNumberAction(number: String)
}