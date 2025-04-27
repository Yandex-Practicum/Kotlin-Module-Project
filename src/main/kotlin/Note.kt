 class Note(private val title: String, private var content: String = "") : Menu() {
    override fun toString(): String {
        return "Название: $title\n" +
                "Текст: $content"
    }

    override fun showMenu() {
        println("⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍")
        println("Заметка: $title")
        println("⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍")
        println("1. Показать текст своей заметки")
        println("2. Записать текст в свою заметку")
        println("3. Убрать текст в своей заметке")
        println("4. Назад")

    }

    override fun handleMenu() {
        while (true) {
            scanner.nextLine().toIntOrNull()
                ?.let { value ->
                    when(value) {
                        1 -> show()
                        2 -> add()
                        3 -> remove()
                        4 -> return
                        else -> println("Введите верное число")
                    }
                    showMenu()
                }
                ?: println("Введите число")
        }
    }

    override fun add() {
        println("Введите текст заметки")
        getText()?.let { text -> content = text }
    }

    override fun remove() {
        content = ""
        println("Текст удален")
    }

    override fun select() {}


    override fun show() {
        println(this)
    }
}