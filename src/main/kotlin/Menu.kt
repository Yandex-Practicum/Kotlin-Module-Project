import kotlin.system.exitProcess

abstract class Menu<T>(
    val menu: MutableMap<String, () -> Unit>,
    val content: MutableMap<String, T>
) {
}