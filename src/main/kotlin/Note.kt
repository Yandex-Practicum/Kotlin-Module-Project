class Note (val content:String){
    var name: String = ""

    init {
        if(content.length<=20) {
          name = content
        }
        else{
            name = content.substring(0,20)
        }

    }
    fun printContent(){
        println("--------------------\n" + "СОДЕРЖИМОЕ ЗАМЕТКИ")
        println(content)
    }
}