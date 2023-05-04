import java.io.File
import java.lang.Exception
import java.nio.file.Files
import java.nio.file.Paths

val path: String = System.getProperty("user.dir")
fun search(title: String, filename: String, isNote1 : Boolean, type : String) : Boolean{
    var folderOrTxt : String
    var result2 : String
    var check = true
    var count : Int
    var isNote = false
    result2=""
    File("$path$filename").walk().forEach {
        folderOrTxt = it.toString()
        var array = "$path$filename/".toCharArray()
        var chars = folderOrTxt.toCharArray()
        var result = ""
        for (i in chars.indices) {
            if (i >= array.size){
                result += chars[i]
            }
        }
        count = 0
        if(result!=""&&result2!=""){
            array = result.toCharArray()
            chars = (result2+"\\").toCharArray()
            for (i in chars.indices) {
                if (i < array.size){
                    if (chars[i] == array[i]) {
                        count += 1
                    }
                }
            }
        }
        if ((result2+"\\").length == count){
            check = false
        }
        if (result == "Main.kt"||result=="Search.kt"||result=="Class.kt"||result==""){
            check = false
        }
        var array2 = result.toCharArray()
        var result3 = ""
        for (i in array2.indices.reversed()) { // итерируемся по массиву в обратном направлении
            result3 += array2[i]
            if (!isNote){
                isNote = result3=="txt."
            }
        }
        if (isNote){
            array2=result3.toCharArray()
            result3 =""
            for (i in array2.indices) {
                if (i>3){
                    result3 += array2[i]
                }
            }
            array2=result3.toCharArray()
            result3 =""
            for (i in array2.indices.reversed()) { // итерируемся по массиву в обратном направлении
                result3 += array2[i]
            }
            result=result3
        }
        array2 = result.toCharArray()
        for (i in array2.indices){
            if (array2[i] == '\\'){
                check=false
            }
        }
        when (type) {
            "Check" -> {
                if (check){
                    if (isNote){
                        if (isNote1){
                            if (result==title){
                                return true
                            }
                        }
                    }else{
                        if (!isNote1){
                            if (result==title){
                                return true
                            }
                        }
                    }
                }
            }
            "IfEmpty" -> {
                if (check){
                    if (isNote){
                        if(isNote1){
                            return true
                        }
                    }else{
                        if (!isNote1){
                            return true
                        }
                    }
                }
            }
            "Search" -> {
                if (check) {
                    if (isNote) {
                        println("Заметка: $result")
                    } else {
                        println("Архив: $result")
                    }
                }
            }
        }
        result2 = result
        check = true
        isNote=false
    }
    return false
}

fun createTxt(title : String, textItself : String, filename1 : String) {
    try{
        val filename = "$path$filename1/$title.txt"
        val myFile = File(filename)
        myFile.printWriter().use {
                out -> out.println(textItself)
        }
    }catch (e: Exception){
        e.printStackTrace()
    } finally {
        println("Заметка создана")
        println()
    }
}

fun readTxt(title : String, filename1 : String){
    try{
        val filename = "$path$filename1/$title.txt"
        println("Заметка: $title")
        val lines:List<String> = File(filename).readLines()
        lines.forEach{ line -> println(line) }
    }catch (e: Exception){
        e.printStackTrace()
    } finally {
        println()
    }
}

fun createArchive(title: String, filename : String){
    Files.createDirectory(Paths.get("$path$filename/$title"))
}

fun selectArchive(title: String, filename1: String): String {
    return "$filename1/$title"
}