import java.util.Scanner

fun createMenu(fn:()->Unit):Int{
    var itemMenu: Int
    while (true){
        println("******************")
        fn()
        itemMenu = userInput()

        if (itemMenu >= 0){
            return (itemMenu)
        }
        else {
            println()
            println("!!! Неправильный ввод!")
            println("!!! Введите номер пункта меню")
            println()
        }
    }
}

fun userInput(): Int{
    val scanner = Scanner(System.`in`)
    println()
    println("-> Выберите пункт меню")
    if (scanner.hasNextInt()){
        return scanner.nextInt()
    }
    return -1
}

fun getText(txtName: String):String{
    val scanner = Scanner(System.`in`)
    while (true){
        println("-> Введите $txtName")
        if (scanner.hasNextLine()){
            val res = scanner.nextLine()
            if (res!=""){
                return res
            }
            println()
            println("!!! $txtName не может быть пустым")
            println()
        }
    }

}

fun anyKey(){
    val scanner = Scanner(System.`in`)
    println("-> Для выхода в меню введите любой символ")
    while(true){
        if (scanner.hasNext()) {
            return
        }
    }
}

fun printMenuError(){
    println()
    println("!!! Несуществующий пункт меню")
    println()
}