/*
// translate to Konlin from https://gist.github.com/felipernb/3981562
import kotlin.random.Random

class Player(val name: String) {
    private val rolls = IntArray(21)
    private var currentRoll = 0
    private var frameScores = IntArray(10)

    fun roll(pins: Int) {
        rolls[currentRoll++] = pins
    }

    fun calculateScore(): Int {
        var score = 0
        var frameIndex = 0

        for (frame in 0 until 10) {
            when {
                isStrike(frameIndex) -> {
                    score += 10 + strikeBonus(frameIndex)
                    frameScores[frame] = score
                    frameIndex++
                }
                isSpare(frameIndex) -> {
                    score += 10 + spareBonus(frameIndex)
                    frameScores[frame] = score
                    frameIndex += 2
                }
                else -> {
                    score += sumOfBallsInFrame(frameIndex)
                    frameScores[frame] = score
                    frameIndex += 2
                }
            }
        }
        return score
    }

    fun getFrameScores(): IntArray = frameScores

    private fun isStrike(frameIndex: Int) = rolls[frameIndex] == 10
    private fun isSpare(frameIndex: Int) = sumOfBallsInFrame(frameIndex) == 10
    private fun strikeBonus(frameIndex: Int) = rolls[frameIndex + 1] + rolls[frameIndex + 2]
    private fun spareBonus(frameIndex: Int) = rolls[frameIndex + 2]
    private fun sumOfBallsInFrame(frameIndex: Int) = rolls[frameIndex] + rolls[frameIndex + 1]

    fun getRolls(): List<Pair<Int, Int>> {
        val frames = mutableListOf<Pair<Int, Int>>()
        var index = 0

        for (frame in 0 until 10) {
            if (isStrike(index)) {
                frames.add(Pair(10, 0))
                index++
            } else {
                frames.add(Pair(rolls[index], rolls[index + 1]))
                index += 2
            }
        }
        return frames
    }
}

class BowlingGame(private val players: List<Player>) {

    fun play() {
        for (frameIndex in 1..10) {
            for (player in players) {
                println("Frame $frameIndex for ${player.name}:")

                // Generate rolls for the current player
                if (Random.nextInt(100) < 30) {  // 30% chance for a strike or use if(Random.nextBoolean()) 50% chance for a strike
                    player.roll(10)
                    println("Roll: 10 (Strike)")
                } else {
                    val firstRoll = Random.nextInt(0, 11)
                    val secondRoll = if (firstRoll == 10) 0 else Random.nextInt(0, 11 - firstRoll)
                    player.roll(firstRoll)
                    player.roll(secondRoll)
                    println("Rolls: $firstRoll, $secondRoll")
                }
            }
        }
        printFinalScores()
    }

    private fun printFinalScores() {
        val nameLength = 20     // Length for player name
        val frameLength = 78    // Length for displaying frames
        val scoreLength = 15    // Length for total score

        println("\nFinal Scores:")
        println("Player Name${" ".repeat(nameLength - 11)}| Frames${" ".repeat(frameLength - 6)}| Total Score")
        println("-".repeat(nameLength + frameLength + scoreLength))

        for (player in players) {
            val totalScore = player.calculateScore()
            val rolls = player.getRolls()
            val frameScores = player.getFrameScores()

            // Display rolls for each frame
            print("${player.name.padEnd(nameLength)}| ")
            for (frame in rolls) {
                val (first, second) = frame
                val frameDisplay = when {
                    first == 10 -> "X   "         // Strike
                    first + second == 10 -> "$first /" // Spare
                    else -> "$first $second"    // Open frame
                }
                print("$frameDisplay\t| ")
            }
            println()

            // Display cumulative scores for each frame
            print(" ".repeat(nameLength) + "| ")
            for (score in frameScores) {
                print("${score.toString().padEnd(5)}\t| ")
            }
            // Display the total score
            print("${totalScore.toString().padEnd(10)} ")  // Display total score
            println("\n" + "-".repeat(nameLength + frameLength + scoreLength))
        }
    }

}

 */
// option 2 as per Ilya requirement using class Frame
import kotlin.random.Random

class Frame {
    var firstRoll: Int = 0
    var secondRoll: Int = 0

    fun isStrike() = firstRoll == 10
    fun isSpare() = (firstRoll + secondRoll) == 10
    fun score() = firstRoll + secondRoll
}

class Player(val name: String) {
    private val frames = Array(10) { Frame() }
    private var currentFrameIndex = 0

    fun roll(pins: Int) {
        // Set the first roll
        if (frames[currentFrameIndex].firstRoll == 0) {
            frames[currentFrameIndex].firstRoll = pins
            // If it's a strike, no second roll in this frame
            if (frames[currentFrameIndex].isStrike()) {
                currentFrameIndex++
            }
        } else {
            // Set the second roll
            frames[currentFrameIndex].secondRoll = pins
            currentFrameIndex++
        }
    }

    fun calculateScore(): Int {
        var score = 0
        var frameIndex = 0

        for (frame in frames) {
            when {
                frame.isStrike() -> {
                    score += 10 + strikeBonus(frameIndex)
                    frameIndex++
                }
                frame.isSpare() -> {
                    score += 10 + spareBonus(frameIndex)
                    frameIndex++
                }
                else -> {
                    score += frame.score()
                    frameIndex++
                }
            }
        }
        return score
    }

    fun getRolls(): List<Pair<Int, Int>> {
        return frames.map { Pair(it.firstRoll, it.secondRoll) }
    }

    fun getCumulativeScores(): IntArray {
        val cumulativeScores = IntArray(10)
        var totalScore = 0

        for (i in frames.indices) {
            totalScore += frames[i].score()
            cumulativeScores[i] = totalScore
        }
        return cumulativeScores
    }

    private fun strikeBonus(frameIndex: Int) =
        if (frameIndex + 1 < frames.size) frames[frameIndex + 1].firstRoll +
                if (frameIndex + 1 < frames.size && frames[frameIndex + 1].isStrike() && frameIndex + 2 < frames.size) frames[frameIndex + 2].firstRoll
                else frames[frameIndex + 1].secondRoll else 0

    private fun spareBonus(frameIndex: Int) =
        if (frameIndex + 1 < frames.size) frames[frameIndex + 1].firstRoll else 0
}

class BowlingGame(private val players: List<Player>) {

    fun play() {
        for (frameIndex in 1..10) {
            for (player in players) {
                println("Frame $frameIndex for ${player.name}:")

                // Generate rolls for the current player
                if (Random.nextInt(100) < 30) {  // 30% chance for a strike or use if(Random.nextBoolean()) 50% chance for a strike
                    player.roll(10)
                    println("Roll: 10 (Strike)")
                } else {
                    val firstRoll = Random.nextInt(0, 11)
                    val secondRoll = if (firstRoll == 10) 0 else Random.nextInt(0, 11 - firstRoll)
                    player.roll(firstRoll)
                    player.roll(secondRoll)
                    println("Rolls: $firstRoll, $secondRoll")
                }
            }
        }
        printFinalScores()
    }

    private fun printFinalScores() {
        val nameLength = 20     // Length for player name
        val frameLength = 78    // Length for displaying frames
        val scoreLength = 15    // Length for total score

        println("\nFinal Scores:")
        println("Player Name${" ".repeat(nameLength - 11)}| Frames${" ".repeat(frameLength - 6)}| Total Score")
        println("-".repeat(nameLength + frameLength + scoreLength))

        for (player in players) {
            val totalScore = player.calculateScore()
            val rolls = player.getRolls()
            val cumulativeScores = player.getCumulativeScores()

            // Display rolls for each frame
            print("${player.name.padEnd(nameLength)}| ")
            for (frame in rolls) {
                val (first, second) = frame
                val frameDisplay = when {
                    first == 10 -> "X   "         // Strike
                    first + second == 10 -> "$first /" // Spare
                    else -> "$first $second"    // Open frame
                }
                print("$frameDisplay\t| ")
            }
            println()

            // Display cumulative scores for each frame
            print(" ".repeat(nameLength) + "| ")
            for (score in cumulativeScores) {
                print("${score.toString().padEnd(5)}\t| ")
            }
            // Display the total score
            print("${totalScore.toString().padEnd(10)} ")  // Display total score
            println("\n" + "-".repeat(nameLength + frameLength + scoreLength))
        }
    }
}