class Note (var name: String, val content:String){
    fun printContent(){
        println("--------------------\n" + "СОДЕРЖИМОЕ ЗАМЕТКИ с названием \"${name}\":")
        println(content)
    }
}