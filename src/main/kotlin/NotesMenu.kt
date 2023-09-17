import java.util.*

class NotesMenu {

    fun showMenu(notes: MutableList<Note>) {

        while (true) {
            MenuGenerator().generateMenu("Notes", notes)
            try {
                when (val input: Int = scanner.nextInt()) {

                    0 -> {
                        while (true) {
                            println("\nВведите название заметки:")
                            scanner.useDelimiter("\\R")
                            val title: String = scanner.next().trim()
                            if (title.isEmpty()) {
                                println("ОШИБКА! Название не может быть пустым. Пожалуйста повторите ввод.")
                                continue
                            } else {
                                while (true) {
                                    println("\nВведите текст заметки:")
                                    val content: String = scanner.next().trim()
                                    if (content.isEmpty()) {
                                        println("ОШИБКА! Текст заметки не может быть пустым. Пожалуйста повторите ввод.")
                                    } else {
                                        notes.add(Note(title, content))
                                        println("Заметка '$title' успешно создана")
                                        break
                                    }
                                }
                            }
                            break

                        }

                    }

                    in 1..notes.size -> {
                        println(notes[input - 1].showTheNote())
                        println("Для возврата в предыдущее меню введите '0'")
                        while (true) {
                            try {
                                while (scanner.nextInt() != 0) {
                                    println("Ошибка ввода команды. Для возврата в предыдущее меню введите '0'")

                                }


                            } catch (e: Exception) {
                                println("Ошибка ввода команды. Для возврата в предыдущее меню введите '0'")
                                scanner.next().trim()
                                continue
                            }
                            break
                        }
                    }

                    notes.size + 1 -> break
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