import Data.Archieve
import java.util.Scanner

class PaigeLogic {
    private val scan: Scanner = Scanner(System.`in`)

    var archieves = HashMap<Int, Archieve>()

    fun getMenuCorrectInput(): Int {
        var isInputNumber: Boolean

        while (true) {
            val value = scan.nextLine()
            isInputNumber = try {
                value.toInt()
                true
            } catch (e: NumberFormatException) {
                false
            }

            if (!isInputNumber) {
                println("Необходимо ввести число")
                continue
            }
            return value.toInt()
        }
    }

    fun getStringCorrectInput() : String{
        while (true){
            val value = scan.nextLine()
            if (value.isBlank()){
                println("Поле не может быть пустым, повторите ввод:")
                continue
            }
            return value
        }
    }

    fun addArchieve(note: Archieve) {
        archieves[archieves.size + 1] = note
        println("Архив добавлен")
    }

    fun showAllArchieves(): String? {
        if (archieves.size > 0) {
            for (archieve in archieves) {
                return archieve.key.toString() + ". " + archieve.value.name
            }
        }
        return null
    }

    fun chooseArchieve(archieveID: Int): Archieve? {
        return archieves[archieveID]
    }
}
