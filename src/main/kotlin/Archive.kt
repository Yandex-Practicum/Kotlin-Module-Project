class Archive(var name: String?, var notes: MutableList<Note>) {


fun showAllNotes(){
    println("Список заметок в архиве $name:")
    if (notes.isNotEmpty()){
        for (i in notes.indices){
            val note = notes.get(i)
            println("$i. ${note.name}")
        }
    } else println("Заметок нет")
}
}
