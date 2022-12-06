class Archive(val archiveName: String) {
    var archiveData: MutableList<Note> = mutableListOf()
    override fun toString(): String {
        return "archiveName = `${this.archiveName}` archiveData = ${this.archiveData}"
    }
    fun newNote(index: Int){
        println("Введите название заметки")
        val name = sc.nextLine()
        if(archiveData.map{element -> element.noteName}.contains(name)){
            println("Заметка с таким именем уже существует!")
            newNote(index)
        }
        println("Введите текст заметки")
        val text = sc.nextLine()
        archiveData.add(Note(name, text))
        println("Заметка успешно создана!")
        dm.askAction(index)

    }
    fun readNote(index: Int){
        println("Выберите заметку:")
        for(i in archiveData){
            println(i.noteName)
        }
        val response = sc.nextLine()
        val notesNames = archiveData.map{element -> element.noteName}
        if(response in notesNames){
            val workWith: Note = archiveData.get(notesNames.indexOf(response))
            println("Название заметки: ${workWith.noteName} \nТекст: ${workWith.noteText}")
            dm.askAction(index)
        } else {
            println("Заметки с таким названием не найдено! Пожалуйста, попробуйте снова.")
            this.readNote(index)
        }
    }
}