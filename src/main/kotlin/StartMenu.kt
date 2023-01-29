import java.util.*

class StartMenu() : Menu() {
    val content: MutableMap<String, Archive> = mutableMapOf()
    val navigator = Navigation()
  //  override val menu: MutableMap<String, () -> Unit> = mutableMapOf()

    fun makeArchive() {
        println("Введите имя архива:")
        val newArchive = Archive(Scanner(System.`in`).nextLine(), this)
        content.put(newArchive.name, newArchive)
        menu["Открыть ${newArchive.name}"] = { navigator.show(content[newArchive.name]!!) }
        println("${newArchive.name} добавлен к списку архивов")
    }
}