package ui.console

import ui.IScreen
import java.util.Queue
import java.util.Scanner
import java.util.Stack

fun Scanner.nextLineNotEmpty(repeatMessage: String): String{
    var result = ""
    while(result.isEmpty()){
        result = this.nextLine()
        if(result.isEmpty())
            println(repeatMessage)
    }
    return result
}

fun Scanner.nextIntTry(repeatMessage: String): Int{
    var result: Int? = null
    while(result === null){
        try {
            val input = readln()
            result = Integer.parseInt(input)
        }catch (ex: Exception) {
            println(repeatMessage)
        }
    }
    return result
}
infix fun Queue<IScreen>.move(to: Stack<IScreen>): IScreen {
    try{
        val screen = this.remove()
        to.add(screen)
        return this.peek()
    }catch (ex:Exception){
        throw Exception("Невозможно получить элемент из очереди")
    }
}
infix fun Stack<IScreen>.move(to: Queue<IScreen>): IScreen {
    try {
        val screen = this.pop()
        to.add(screen)
        return screen
    }catch (ex:Exception){
        throw Exception("Невозможно получить элемент из стэка")
    }
}