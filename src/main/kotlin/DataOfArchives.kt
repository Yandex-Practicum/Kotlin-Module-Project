import java.util.*

open class DataOfArchives : Tool() {
    private val archives = mutableListOf<Archive>()
    override val phrase1 = "архив"
    override val phrase2 = "архивы"
    val scanner1 = Scanner(System.`in`)
    val scanner2 = Scanner(System.`in`)
    override var beforeInput: Int = 0
    override fun createOne() {
        println("Введите название архива")
        val nameOfArch = scanner2.nextLine()
        archives.add(Archive(nameOfArch))
        println("Ваш архив $nameOfArch создан")
    }

    fun getArchives(): List<Archive> {
        return archives.toList()
    }

    fun StartOfMenu() {
        while (true) {
            val archs = getArchives()
            textOfMenu(phrase1, phrase2) /// сделал через абстракт класс логику тут
            check(beforeInput) // и тут
            val input1 = scanner1.nextInt()
            when (input1) {
                1 -> { // этот блок не получается вынести, манался с ним часов 6, из-за разных типо листов не идет, если выношу
                    if (archs.isEmpty()) { // в отдельный метод и пытаюсь ифнуть через инстанс того или другого листа, то данные проваливаются по итогу
                        println("К сожалению, $phrase1 пуст, добавь новый архив!")// в общем получается какой-то ад, проще по новой переписать
                    } else {
                        archs.forEachIndexed { index, archive -> println("${index + 1}. ${archive.name}") }
                        println("Выберите $phrase1 по номеру выше")
                        if (scanner2.hasNextInt()) {
                            val input2 = scanner2.nextInt()
                            when (input2) {
                                in 1..archs.size -> {
                                    archs[input2 - 1].showList(scanner2)
                                }
                                else -> {
                                    Error.errorOfScanner()
                                }
                            }
                        } else {
                            Error.errorOfScanner()
                        }
                    }
                }
                2 -> {
                    createOne() // также вынес в отдельный метод логику тут
                }
                0 -> {
                    println("Выходим...")
                    break
                }
                else -> {
                    Error.errorOfScanner()
                }

            }
        }

    }
}




