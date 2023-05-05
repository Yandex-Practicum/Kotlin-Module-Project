fun main() {
    var keepGoing = true
    val newMenu = Menu()
    while (keepGoing){
        keepGoing = newMenu.screen("/src/main/kotlin")
    }
}