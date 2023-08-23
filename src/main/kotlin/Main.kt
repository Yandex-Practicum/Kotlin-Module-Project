import Screen
fun main() {
    Screen.mainScreen()
    Input.inputInt()
    println("Создаем архив")
    Creation.createArchive("Мой архив")
    println(Archive.howMuch())
}