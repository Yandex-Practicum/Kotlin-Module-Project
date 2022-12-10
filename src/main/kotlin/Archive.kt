class Archive : Screen() {
//    override var menu: MutableList<String> = mutableListOf()
    override val theme = "архивов"
    override val title = "архив"

    fun run(store: LinkedHashMap<String, MutableList<String>>) {

        show(store.keys.toList(), theme, title)
        var inp = readln()

        while (!inputError(inp, store.keys.size + 1)) { //errors check
            show(store.keys.toList(), theme, title)
            inp = readln()
        }
        when (inp.toIntOrNull()) {
            0 -> {
                showCreate(title, store); run(store)
            }
            in 1 until store.size + 1 -> showArchNotes(store.keys.toList()[inp.toInt() - 1], store)
            store.size + 1 -> {
                print("Завершение программы.");return
            }
        }
    }
}