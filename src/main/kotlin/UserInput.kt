import java.util.Scanner

class UserInput {
    private val input = Scanner(System.`in`)

    fun getUserAnswerMenu(): Int? {
        val answer: Int? = if (input.hasNextInt()) input.nextInt() else null
        input.nextLine()
        return answer
    }

    fun getUserAnswerStringName(): String {
        var answer: String
        while (true) {
            answer = input.nextLine()
            if (answer.isNotEmpty() ) return answer
            else println("Введена пустая строка, повторите ввод")
        }
    }

}