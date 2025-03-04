//fun main(args: Array<String>) {
//    println("Hello World!")
//}

fun main() {
//    val app = NoteApp()
//    app.start()

    val playerNames = listOf("Ivan", "Maria", "Commander Shepard")
    val players = playerNames.map { Player(it) }

    val game = BowlingGame(players)
    game.play()
}