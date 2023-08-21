package services

import Strings
import java.util.Scanner

class InputService {
    private val scanner: Scanner = Scanner(System.`in`)
    fun getInt(): Int {
        while (true) {
            val input = getString()
            try {
                return input.toInt()
            } catch (e: NumberFormatException) {
                println(Strings.ERROR_INCORRECT_ENTER)
            }
        }
    }

    fun getString(): String{
        while (true){
            val input = scanner.nextLine()
            if (input.isNotBlank()){
                return input
            } else {
                println(Strings.ERROR_EMPTY_INPUT)
            }
        }
    }
}