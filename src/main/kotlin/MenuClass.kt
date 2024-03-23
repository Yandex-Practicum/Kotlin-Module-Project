import java.util.Scanner
open class MenuClass() {
    var menuText = ""
    constructor(menuText: String) : this() {
        this.menuText = menuText
    }
    open fun printMenu(){
        print(menuText)
    }
    open fun getUserCommand(): String {
        val command : String
        command = Scanner(System.`in`).nextLine()
        return command
    }
}
