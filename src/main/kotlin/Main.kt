fun main() {
    println("Заметки 0.9b")
    val menuLevelList = listOf("список архивов", "архив", "заметка")
    val archiveList = Menu<Menu<*>>(null, menuLevelList, 0,null)
    archiveList.run()
    println("Програма завершена")
}
