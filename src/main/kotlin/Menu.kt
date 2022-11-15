import java.util.Scanner

class Menu : CommonFunctions<Archive>() {
    private val archives: MutableList<Archive> = mutableListOf()


    fun showMenuArchive() {

        println("0. Создать архив")
        archives.forEachIndexed { index, archive -> println("${index + 1}. ${archive.name}") }
        println("${archives.size + 1}. Выход")
        println("Введите цифрой нужную команду")
        logic(getCommand(archives), archives)
    }

    override fun createElement() {
        println("Как назовем новый архив?")
        val name = Scanner(System.`in`).nextLine()
        archives.add(Archive(name))
        showMenuArchive()
    }

    override fun openElement(t: Archive) {
        t.showArchive()
        showMenuArchive()
    }


}