fun main() {
    val repo = Repository()
    val input = InputReader()
    val navigator = Navigator(repo,input)

    navigator.start(ArchiveListScreen())
}