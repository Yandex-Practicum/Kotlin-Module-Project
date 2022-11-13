

class Note (val name: String,
            private val content :String){
fun showContent(){
    println("Заметка $name")
    println(content)
}
}