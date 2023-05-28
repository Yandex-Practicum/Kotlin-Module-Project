package menu

import utils.ScanEnter
import datastructure.Container
import datastructure.Archive


internal class CreateArch(
    override val container: Container,
    override var menu: String = "*** СОЗДАНИЕ НОВОГО АРХИВА ***",
    override val commands: MutableList<String> = mutableListOf()
) : AbstСonstructorMenu() {


    private lateinit var name: String

    internal fun run() {
        println(LINE)
        println(menu)
        print("Введите имя АРХИВА: ")

        validateCommand()

        container.addArc(Archive(nameArchive = this.name, mutableListOf()))
        SelectArch(container).run()
    }

    override fun validateCommand() {
        name = ScanEnter().validateString()
    }
}