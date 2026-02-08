data class Note (val name: String, val text: String){
    internal fun knowContent(){
        println(text)
    }
}