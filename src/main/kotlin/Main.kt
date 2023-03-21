import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val dataManager = ProgramManager()
    while (true){
        val listMainCommand = dataManager.getMainMenuOption()
        println("Список архивов:")
        for((index, value) in listMainCommand.withIndex()){
            println("$index. $value")
        }
        val input = scanner.nextLine()

        if(!dataManager.isStringInt(input)){
            println("Необходимо ввести число!")
            continue
        }
        else{
            val number = input.toInt()
            val checkCommand = dataManager.checkUserInput(number, listMainCommand)
            if(!checkCommand){
                continue
            }
            when(listMainCommand[number]){
                ProgramManager.EXIT_WORLD -> {
                    println("Пока пока")
                    break
                }
                ProgramManager.CREATE_ARCHIVE -> {
                    Archive.createArchive(dataManager, listMainCommand)
                    continue
                }
                else -> {
                    val archive = dataManager.getArchive(listMainCommand[number])
                    archive.workWithNotes(dataManager)
                }
            }
        }
    }
}




