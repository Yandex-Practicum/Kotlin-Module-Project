package options

import objects.Archives
import objects.PunktMenu
import screens.MenuScreen
import java.util.Scanner
import kotlin.system.exitProcess

class ArchiveOptions : MenuScreen() {
    private val archives = mutableListOf<Archives>()

    fun create() {
        while (true) {
            val options = mutableListOf<PunktMenu>()

            options.add(PunktMenu("Создать архив"){
                println("Введите название архива")
                val name = Scanner(System.`in`).nextLine()
                if (name == null){
                    println("Введите название архива")
                }
                else {
                    archives.add(Archives(name))
                }
            })

            archives.forEach { archive ->
                options.add(PunktMenu(archive.name) {
                    NotesOptions(archive).create()
                })
            }
            options.add(PunktMenu("Выход") {
                exitProcess(0)
            })
            showMenuScreen("Список архивов", options)
        }
    }
}