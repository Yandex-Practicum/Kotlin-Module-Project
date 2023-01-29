import kotlin.system.exitProcess

open class Menu() {
    val menu: MutableMap<String, () -> Unit> = mutableMapOf()
}