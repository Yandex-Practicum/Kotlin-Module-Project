import java.util.Scanner
import kotlin.math.acos


class MenuFunctions(
    private val scanner: Scanner = Scanner(System.`in`)
) {
    private fun printNoteMenu(name: String) {

        println("*************\nВы находитесь в архиве $name\n*************")
        println(" __________________________\n|Выберите нужный пункт меню|\n --------------------------")
        println("1: Создать заметку\n2: Список заметок\n3: Просмотр заметки\n4: Вернуться в предыдущее меню")
    }

    private fun printArchiveMenu() {
        println("Выберите нужный пункт меню\n1: Создать архив\n2: Список архивов\n3: Выбор архива\n4: Завершить работу программы\n")
    }

    fun menuStartApp() {
        archiveMenu()
    }

    private fun archiveMenu() {
        var menu: String
        val menuText = "1: Создать архив\n2: Список архивов\n" +
                "3: Выбрать архив\n4: Выход из программы"
        val archiveLogic = ArchiveLogic()
        print(menuText)

        while (true) {
            menu = scanner.next()
            when (menu) {
                "1" -> {
                    print("Введите имя архива: ")
                    val name = scanner.next()
                    if (archiveLogic.createNewArchive(name)) {
                        println("Архив $name создан")
                    } else {
                        println("Архив с именем $name уже существует")
                    }
                }

                "2" -> {
                    val listNames = archiveLogic.getListOfArchives()
                    printNames(listNames, "Архивов")
                }

                "3" -> {
                    if (archiveLogic.getListOfArchives().isNotEmpty()) {
                        print("Введите имя архива: ")
                        val name = scanner.next()
                        val archive = archiveLogic.getArchive(name)
                        if (archive != null) {
                            println("Вы находитесь в архиве $name")
                            noteMenu(archive)
                            print(menuText)
                        } else {
                            println("Архива с именем $name не существует.")
                        }
                    } else {
                        println("Архивов пока нет.")
                    }
                }

                "4" -> {
                    return
                }

                else -> {
                    println("Увы, но такого раздела меню пока нет. Выберите доступный пункт меню")
                    print(menuText)
                }
            }
        }
    }

    private fun noteMenu(archive: Archive) {
        printNoteMenu(archive.getName())
        while (true) {
            val menu = scanner.next()
            when (menu) {
                "1" -> {
                    print("Введите имя заметки: ")
                    val name = scanner.next()
                    print("Введите текст заметки: ")
                    val text = scanner.next()
                    val note = Note(name, text)
                    archive.addNote(note)
                    println("Заметка $name успешна добавлена в архив ${archive.getName()}")
                }

                "2" -> {
                    val listNames = archive.getListOfNotes()
                    printNames(listNames, "Заметок")
                }

                "3" -> {
                    if (archive.getListOfNotes().isNotEmpty()) {
                        print("Введите имя заметки: ")
                        val name = scanner.next()
                        val note = archive.getNote(name)
                        if (note != null) {
                            note.readTextNote()
                        } else {
                            println("Заметки с именем $name не существует")
                        }
                    } else {
                        println("Заметок еще нет")
                    }
                }
                "4" -> {
                    return
                }
                else ->{
                    println("Увы, но такой команды нет. Попробуйте еще раз")
                }
            }
        }
    }

    private fun printNames(listNames: Array<String>, objName: String) {
        if (listNames.isNotEmpty()) {
            var i: Int = 1
            for (name in listNames) {
                println("$i - $name")
                i++
            }
        } else {
            println("$objName еще нет.")
        }
    }
}