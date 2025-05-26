import java.util.Scanner

class CheckingDataEntry {

    val scanner : Scanner = Scanner(System.`in`)

    fun readInput():String{
        return scanner.nextLine().trim()
    }

    fun resultInputInt(result:String?) : Int{
        var intInput = result?.toIntOrNull()
        while (intInput == null){
            print("Введенное значение не число. Повторите ввод:")
            intInput = readLine()?.toIntOrNull()
        }
        return intInput
    }

    fun inputStringName() :String{
        var stringInput = readlnOrNull()?: ""

        while (stringInput.length == 0){
            print("Текст не может быть пустым. Повторите ввод:")
            stringInput = readlnOrNull()?: ""
        }
        return stringInput
    }

    fun <T> checkingCollection(list: MutableList<T>):Boolean{
        if (list.isEmpty()) {
            println("---Список данных пуст---")
            return false}
        return true
    }

    fun checking():Int{
        return resultInputInt(readInput())
    }
}