package ui

import java.util.Scanner

object ConsoleReader {
    private val scanner = Scanner(System.`in`)

    fun readLine(prompt: String): String {
        print(prompt)
        return scanner.nextLine().trim()
    }

    fun readInt(prompt: String): Int? {
        print(prompt)
        return try {
            scanner.nextLine().toInt()
        } catch (e: NumberFormatException) {
            null
        }
    }
}