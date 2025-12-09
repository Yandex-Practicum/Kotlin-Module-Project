interface Screen {
    fun show(repo: Repository, input: InputReader): NavCommand
}

sealed class NavCommand {
    data class Push(val screen: Screen) : NavCommand()
    object Pop : NavCommand()
    object Exit : NavCommand()
    object Stay : NavCommand()
}

class Navigator(
    private val repo: Repository,
    private val input: InputReader
) {
    private val stack: MutableList<Screen> = mutableListOf()

    fun start(root: Screen) {
        stack.add(root)

        while (stack.isNotEmpty()) {
            val current = stack.last()

            when (val cmd = current.show(repo, input)) {
                is NavCommand.Push -> stack.add(cmd.screen)

                NavCommand.Pop -> {
                    if (stack.size > 1) stack.removeAt(stack.lastIndex) else return
                }

                NavCommand.Exit -> return
                NavCommand.Stay -> { }
            }
        }
    }
}
