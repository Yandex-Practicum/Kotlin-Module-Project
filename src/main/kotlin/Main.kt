import java.util.Scanner

fun main() {
    val scanner1 = Scanner(System.`in`)
    val scanner2 =
        Scanner(System.`in`)//Пришлось делать много сканнеров, иначе там какие-то баги с ним происходят,
    val dataOfArchive = DataOfArchives()// когда делаю HasNextInt()
    val check = Check()
    println("Добро пожаловать в Заметки!")

    while (true) {
        val archs = dataOfArchive.getArchives()
        println("Выберите следующее действие:")
        println("1 - Посмотреть архивы")
        println("2 - Создать архив")
        println("0 - Выход из приложения")
        if (scanner1.hasNextInt()) {
            val int1 = scanner1.nextInt()
            when (int1) {
                1 -> {
                    if (archs.isEmpty()) {
                        println("К сожалению, архив пуст, добавь новый архив!")
                        continue
                    } else {
                        archs.forEachIndexed { index, archive -> println("${index + 1}. ${archive.name}") }
                        println("Выберите архив по номеру выше")
                        if (scanner2.hasNextInt()) {
                            val int2 = scanner2.nextInt()
                            when (int2) {
                                in 1..archs.size -> {
                                    archs[int2 - 1].showNotesMenu(scanner2)
                                }
                                else -> {
                                    check.errorOfScanner()
                                }
                            }
                        } else {
                            check.errorOfScanner()
                        }
                    }

                }
                2 -> {
                    println("Введите название архива")
                    val nameOfArch = scanner2.nextLine()
                    dataOfArchive.createArchive(nameOfArch)
                    println("Ваш архив $nameOfArch создан")
                }
                0 -> {
                    println("Выходим...")
                    break
                }
                else -> {
                    check.errorOfScanner()
                }

            }
        } else {
            check.errorOfScanner()
            return
        }

    }
}





