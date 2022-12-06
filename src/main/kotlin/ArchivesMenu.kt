
fun createArchive() {

    scanner.nextLine()
    println("Введите название нового архива:")

    val name = scanner.nextLine()
    archives[name] = mutableListOf()
    println("Вы создали архив с названием: '$name'")
}