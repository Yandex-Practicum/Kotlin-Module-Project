import kotlin.system.exitProcess

// Список архивов (глобальная переменная)
val archives = mutableListOf<Archive>()

// Главное меню (меню архивов)
fun showMainMenu() {
    val menu = MenuManager("Список архивов:" + if (archives.isNotEmpty()) " ${archives.joinToString { it.name }}" else "")
    menu.addItem("Создать архив") { createArchive() }
    archives.forEachIndexed { index, archive ->
        menu.addItem(archive.name) { showArchiveMenu(index) }
    }
    menu.show {
        println("Выход из программы")
        exitProcess(0) // Завершение программы
    }
}

// Создание архива
fun createArchive() {
    val name = readInput("Введите название архива:") ?: run {
        println("Название архива не может быть пустым.")
        return
    }
    archives.add(Archive(name))
    println("Архив '$name' создан.")
    showMainMenu() // Обновляем главное меню
}