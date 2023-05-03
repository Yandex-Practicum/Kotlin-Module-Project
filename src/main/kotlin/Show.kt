

class Show(private val listObjects: MutableList<out Screen>) {

    fun show(createObject: String) {
        println("0. Создать $createObject")
        var counter: Int = 1
        for (obj in listObjects) {
            println("$counter. ${obj.name}")
            counter++
        }
        println("$counter. Выход ")
    }
}
