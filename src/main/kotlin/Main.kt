import java.util.*

fun main() {
    start(true)
}
var sc: Scanner = Scanner(System.`in`)
var dm: DataManager = DataManager()
var rf: RepeatedFunctions = RepeatedFunctions()
var archives: MutableList<Archive> = mutableListOf()
fun start(flag: Boolean){
    if(flag) println("Доступные действия:\n" + "0. Создать архив\n" + "1. Это мой уже созданный архив\n" + "2. Выход ")
    when(sc.nextLine()){
        "0" -> rf.createNew(null, false, mutableListOf("Введите название для нового архива", "Архив с таким именем уже существует!"))
        "1" -> rf.read(null, false, "Выберите архив:")
        "2" -> return
        else -> {println("Некорректный вариант. Попробуйте снова!")
                 start(false)}
    }
}

