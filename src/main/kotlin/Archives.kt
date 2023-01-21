import java.util.Scanner

var listOfArchive: MutableSet<String> = mutableSetOf()
var currentArchiveName:String = String()
//двумерный массив, где хранятся: имя архива (String) и названия Заметок (Notes) этого архива
val archiveAndNotes:MutableMap<String,MutableList<String>> = mutableMapOf()

class Archives  {

    fun createOfArchive() {
        println("NEW ARCHIVE MENU")
        println("To create a new archive, type the archive name:")
        val inputName=Scanner(System.`in`).nextLine()
        //проверяем, что не введена пустая строка или пробел
        if (inputName.isNullOrEmpty()|| inputName.isBlank()) println("Invalid input")
        else {
            listOfArchive.add(inputName)
            println("Archive '$inputName created")

        }

    }


}

