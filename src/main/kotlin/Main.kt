fun main(args: Array<String>) {
    var keepGoing = true
// /src/main/kotlin
    val newMenu = Menu()
    while (keepGoing){
        keepGoing = newMenu.screen("/src/main/kotlin")
    }
}