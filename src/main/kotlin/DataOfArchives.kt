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
            val input1 = beforeInput
            when (input1) {
                1 -> {
                    chooseOne(archs) // смог вынести до такого уровня, общее меню не получается вынести так как функция в этом классе принимает параметр,
                }                    //а в другом нет
                2 -> {
                    createOne()
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

     fun chooseOne(archs: List<Archive>) {
        if (archs.isEmpty()) {
            println("К сожалению, $phrase1 пуст, добавь новый архив!")
        } else {
            archs.forEachIndexed { index, archive -> println("${index + 1}. ${archive.name}") }
            println("Выберите $phrase1 по номеру выше")
            check(beforeInput)
            val input2 = beforeInput
            when (input2) {
                in 1..archs.size -> {
                    archs[input2 - 1].showList(scanner2)
                }
            }
        }
    }
}




