package menu

import datastructure.Container
import utils.ScanEnter


//выбор меню
internal class SelectArch(
    override var container: Container?,
    override var menu: String = "*** ЭКРАН АРХИВОВ ***",
    override val commands: MutableList<String> = mutableListOf()
) : AbstСonstructorMenu() {

    internal fun run() {

        if (container == null) {
            this.container = Container()
        }

        println(LINE)
        commands.add("Создать АРХИВ")

        container!!.getArchTitles().forEach { archiveTittle ->
            commands.add(archiveTittle)
        }

        commands.add("Выход из ПРИЛОЖЕНИЯ")
        menuСonstructor()
        validateCommand()
    }

    override fun validateCommand() {
        when (val command = ScanEnter().validateInt(commands.size - 1)) {
            0 -> CreateArch(container!!).run()
            commands.size - 1 -> {
                println(LINE)
                println("Работа приложения завершена")
            }

            else -> MenuArchive(container!!).run(command - 1)
        }
    }
}