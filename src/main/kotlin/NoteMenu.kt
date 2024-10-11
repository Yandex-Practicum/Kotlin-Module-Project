class NoteMenu(private val note: Note, private val ioHandler: IOHandler) {//меню заметок

    fun show() {
        while (true) {
            ioHandler.showMessage("Заметка: ${note.name}")
            ioHandler.showMessage("Текст: ${note.body}\n")
            ioHandler.showMessage("0. Назад")
            val choice = ioHandler.getUserChoice()
            if(choice==0){
                break
            }else{
                ioHandler.showMessage("Неверный ввод. Попробуйте снова.\n")
            }
        }
    }
}