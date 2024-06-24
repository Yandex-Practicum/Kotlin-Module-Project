import java.util.Scanner

class ArhiveCreate {
    val archiveList = mutableListOf<Archive>()
    private var scanner = Scanner(System.`in`)
    var noteList: MutableList<Note> = mutableListOf()
    fun printMenu() {
        while (true){

            getSize(archiveList,"СОЗДАНИЕ АРХИВА\nВведите номер архива либо \n0 - Создать архив ")

            val command = switch(archiveList.size)

            if (command == -100) {
                println("Вы вышли из приложения")
                break
            }
            if (command == 0) {
                val archiveName=nameInput("Введите название архива: ")
                val newArhive =Archive(name=archiveName)
                archiveList.add(newArhive)
                println("Архив добавлен: $archiveName")

            } else {
                while (true){
                    val archive = archiveList[command - 1]
                    noteList=archive.noteList

                    getSize(noteList,"СОЗДАНИЕ ЗАМЕТКИ\nВведите номер заметки либо \n0 - Создать заметку ")
                    val commandNote=switch(noteList.size)
                    when(commandNote) {
                        0 -> {
                            val noteName = nameInput("Введите заголовок заметки: ")
                            val noteInfo = nameInput("Введите содержание заметки: ")
                            archive.addNote(Note(noteName, noteInfo))
                            println("Заметка добавлена: $noteName") }

                        -100->break

                        else->println(noteList[commandNote-1].infoOut())
                    }
                }
            }
        }

    }





    fun nameInput(string: String): String {
        while (true) {
            println(string)
            val name=getCommand()
            if (name.isNotEmpty()) {
                return name
            } else {
                println("Некорректный ввод, попробуйте снова.")
            }
        }
    }
    fun isInt(str: String) = try {
        str.toInt()
        true
    } catch (e: NumberFormatException) {
        false
    }
    open fun getCommand(): String {
        return scanner.nextLine()
    }

    fun switch(size:Int):Int{
        var command=""
        while (true) {
            command=getCommand()
            if(!isInt(command)) {
                println("Ошибка: надо ввести целое число!")
                continue}
            if(command.toInt() > (size +1)) {
                println("Ошибка: такого пункта меню нет. Попробуйте еще раз!")
                continue
            }
            if(command.toInt() <0) {
                println("Ошибка: число должно быть целым положительным!")
                continue
            }
            if (command.toInt() == size + 1) {
                return -100
                break
            }
            else {
                break
            }
        }
        return command.toInt()
    }
    fun <T> getSize(t: MutableList<T>,string: String) {
        println(string)
        for (i in 0..t.size-1){
            println("${i + 1} - ${t.get(i)}")}
        println("${t.size + 1} - Выход")
    }
}