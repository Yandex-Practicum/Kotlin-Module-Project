fun main() {
    // ваш код начнется здесь
    // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
    println("Привет")
    ArchiveMenu.printMenu()
}

fun exit() {
    return
}

fun String.isValidInt(): Boolean {
    return this.toIntOrNull() != null
}