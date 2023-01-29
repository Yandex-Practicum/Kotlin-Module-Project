import kotlin.system.exitProcess

interface Menu {
    val menu: MutableMap<String, () -> Unit>
}