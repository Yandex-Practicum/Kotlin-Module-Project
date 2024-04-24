class SelectNumberScreen {
    inline fun <reified T> selectNumber (list: MutableList<T>) : Int {  //функция, считывающая выбранный номер архива/заметки в архиве
        val textInput = readln()
        return try {
            if ((textInput.toInt() < list.size) and (textInput.toInt() >= 0)) {
                textInput.toInt()
            } else {
                println("Такого номера нет")
                -1
            }
        } catch(e: Exception){
            println("Номер введен некорректно")
            -1
        }
    }
}