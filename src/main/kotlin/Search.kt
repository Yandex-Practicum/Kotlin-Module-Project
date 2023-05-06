import java.io.File
import java.lang.Exception
import java.nio.file.Files
import java.nio.file.Paths
enum class SearchType{
    CHECK, // проверяем, существует ли в архиве файл под названием 'title' 
    IF_EMPTY, // проверяем содержит ли архив заметки или архивы 
    SEARCH // отображает список заметок и архивов в архиве
}

val path: String = System.getProperty("user.dir")
fun search(title: String, filename: String, isNote1: Boolean, type: SearchType): Boolean {
    val target = if (isNote1) ".txt" else ""
    File("$path$filename").walk().forEach { file ->
        var relativePath = file.toRelativeString(File("$path$filename"))
        val isNote = relativePath.endsWith(".txt")
        if ((isNote != isNote1 && type != SearchType.SEARCH) || relativePath.contains("\\") || (relativePath == "Main.kt" || relativePath == "Search.kt" || relativePath == "Class.kt" || relativePath == "")) return@forEach
        when (type) {
            SearchType.CHECK -> if (relativePath == "$title$target") return true
            SearchType.IF_EMPTY -> return true
            SearchType.SEARCH -> {
                if (isNote) {
                    relativePath = relativePath.substring(0, relativePath.length - 4)
                }
                println("${if (isNote) "Заметка" else "Архив"}: $relativePath")
            }
        }
    }
    return false
}

fun createTxt(title: String, textItself: String, filename1: String) {
    try {
        val filename = "$path$filename1/$title.txt"
        val myFile = File(filename)
        myFile.printWriter().use { out ->
            out.println(textItself)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        println("Заметка создана")
        println()
    }
}

fun readTxt(title: String, filename1: String) {
    try {
        val filename = "$path$filename1/$title.txt"
        println("Заметка: $title")
        val lines: List<String> = File(filename).readLines()
        lines.forEach { line -> println(line) }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        println()
    }
}

fun createArchive(title: String, filename: String) {
    Files.createDirectory(Paths.get("$path$filename/$title"))
}

fun selectArchive(title: String, filename1: String): String {
    return "$filename1/$title"
}
