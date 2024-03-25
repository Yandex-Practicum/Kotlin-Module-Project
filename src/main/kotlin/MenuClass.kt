import java.util.Scanner
open class MenuClass() {
    var menuText = ""
    private var scanner = Scanner(System.`in`)

    constructor(menuText: String) : this() {
        this.menuText = menuText
    }
    open fun printMenu(){
        print(menuText)
    }
    open fun getUserCommand(): String {
        val command : String
        command = scanner.nextLine()
        return command
    }
}
