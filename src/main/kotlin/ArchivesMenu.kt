import java.util.*

class ArchivesMenu {

    fun showMenu() {
        val archives: MutableList<Archive> = mutableListOf()

        while (true) {
            MenuGenerator().generateMenu("Archives", archives)

            try {
                when (val input: Int = scanner.nextInt()) {

                    0 -> {
                        while (true) {
                            println("\nВведите название архива:")
                            scanner.useDelimiter("\\R")
                            var title: String = scanner.next().trim()
                            if (title.isNotEmpty()) {
                                archives.add(Archive(title, mutableListOf()))
                                println("Архив '$title' успешно создан")
                                break
                            } else {
                                println("ОШИБКА! Название не может быть пустым. Пожалуйста повторите ввод.")
                            }
                        }

                    }

                    in 1..archives.size -> NotesMenu().showMenu(archives[input - 1].notes)

                    archives.size + 1 -> break
                    else -> println("Ошибка ввода команды, такого пункта нет. Пожалуйста повторите ввод.")
                }
            } catch (e: Exception) {
                println("Ошибка ввода команды. Пожалуйста повторите ввод.")
                scanner.next()
            }

        }

    }

    companion object {
        val scanner = Scanner(System.`in`)


    }

}