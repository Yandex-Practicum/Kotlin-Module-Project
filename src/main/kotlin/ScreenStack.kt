/**
 * Осуществляет навигацию между "Экранами" через стек. В качестве элементов Стека используюстя
 * экземпляры классов реализующих интерфейс Screen.
 */
object ScreenStack {
    private var stack: ArrayDeque<Screen> = ArrayDeque()

    /** Добавляет [item] в Стек, если его в нем нет и вызывает соответствующий "Экран" */
    fun push(item: Screen) {
        if (stack.isEmpty() && item !is ListOfArchives) {
            println("Initialization error.")
            return
        }
        if (stack.contains(item)) return
        stack.add(item)
        item.onScreen()
    }

    /**
     * Удаляет из Стека текущий "Экран" и вызывает предыдущий. При наличии в стеке
     * единственного элемента, которым всегда является сипсок архивов(ListOfArchives)
     * происходит завершение программы.
     */
    fun pop() {
        stack.removeLast()
        stack.lastOrNull()?.onScreen() ?: println("Closing...")
    }
}