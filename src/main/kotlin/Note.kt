import utils.RequestMessage
import utils.RequestMessage.*
import java.util.*

class Note(private val title: String, private val content: String) : Screen {
    override val commandName: String = title

    override fun onScreen() {
        showNote()
        backToPreviousScreen(ENTER_ANY_KEY)
    }

    private fun showNote() {
        println("Заметка: $title")
        println(content)
    }

    private fun backToPreviousScreen(message: RequestMessage) {
        if (getAnyKey(message)) ScreenStack.pop()
    }

    /** Возвращает true при вводе любой строки. Перед считыванием выводит [requestMessage] */
    private fun getAnyKey(requestMessage: RequestMessage): Boolean {
        println(requestMessage)
        Scanner(System.`in`).nextLine()
        return true
    }

    override fun toString(): String {
        return title
    }
}
