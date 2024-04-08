import java.util.Scanner


fun main(args: Array<String>) {
    var archiveList = mutableListOf<Archive>()
    val scanner: Scanner = Scanner(System.`in`)
    val appNavi = AppNavigation()
    appNavi.appNavi(scanner, archiveList)
}

