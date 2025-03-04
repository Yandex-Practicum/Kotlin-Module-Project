class NoteMenu : BaseMenu<Pair<String, String>>(
    mutableListOf(), MenuUtils(), "заметок", "Создать заметку"
) {

    override fun menuItemSelected(item: Pair<String, String>) {
        println("Заметка: ${item.first}")
        println("Текст заметки:\n${item.second}")

        println("Выберите действие:")
        println("0. Добавить текст")
        println("1. Выход")

        val choice = menuUtils.readInput()

        when (choice) {
            0 -> {
                appendContent(item)
            }

            1 -> {
                return
            }

            else -> {
                println("Некорректный выбор. Пожалуйста выберите 0 или 1.")
            }
        }
    }

    override fun createItem() {
        println("Введите название заметки:")
        val title = readln().trim()
        if (title.isEmpty()) {
            println("Название заметки не может быть пустым.")
            return
        }

        println("Введите текст заметки:")
        val content = readln().trim()
        if (content.isEmpty()) {
            println("Текст заметки не может быть пустым.")
            return
        }

        items.add(Pair(title, content))
        println("Заметка \"$title\" успешно создана.")
    }

    private fun appendContent(item: Pair<String, String>) {
        println("Введите текст, который Вы хотите добавить:")
        val additionalText = readln().trim()
        if (additionalText.isNotEmpty()) {
            val updateContent = item.second + "\n" + additionalText
            val index = items.indexOf(item)
            if (index != -1) {
                items[index] = Pair(item.first, updateContent)
                println("Текст успешно добавлен к заметке \"${item.first}\".")
            } else {
                println("Ошибка: Не удалось найти заметку для обновления.")
            }
        } else {
            println("Добавляемый текст не может быть пустым.")
        }
    }

    fun show() {
        showMenu()
    }
}