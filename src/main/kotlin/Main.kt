import java.util.*

fun main() {
    // ваш код начнется здесь
    // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
    //var dataArchive: MutableList<Archive> = DataManager().archives
    //dataArchive.add(Archive("Archive #1", mutableListOf(Note("Note #1", "TextTextText"))))
    //println(dataArchive)
    start(true)
}
var sc: Scanner = Scanner(System.`in`)
var dm: DataManager = DataManager()
fun start(flag: Boolean){
    if(flag) println("Список архивов:\n" + "0. Создать архив\n" + "1. Это мой уже созданный архив\n" + "2. Выход ")
    when(sc.nextLine()){
        "0" -> dm.createArchive()
        "1" -> dm.manageArchives()
        "2" -> return
        else -> {println("Некорректный вариант. Попробуйте снова!")
                 start(false)}
    }
}

