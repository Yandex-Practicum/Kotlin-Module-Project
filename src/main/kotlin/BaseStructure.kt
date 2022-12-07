import java.util.*

abstract class BaseStructure<K : Any, V> {
    abstract var list: MutableMap<K, V>
    private var index: Int = 0

    open fun showList() {
        var i = 0
        list.forEach { (key,_) -> println("${++i}. $key") }
        println("${++i}. Выход")
        index = i
    }

    fun inputHandler(input: Int): String {
        return when (input) {
            0 -> { println("Введите название")
                addItem(Scanner(System.`in`).nextLine())
                "this" }
            in 1 until index -> getKey(input)
            index -> "the_end"
            else -> "this"
        }
    }

    abstract fun addItem(key: String)

    private fun getKey(input: Int): String {
        var k = ""
        var i = 0
        for (e in list)
            if (++i == input) k = e.key.toString()
        return k
    }


}