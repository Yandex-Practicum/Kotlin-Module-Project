class CreateNoteScreen(private val archive: Archive):Screen{
    override fun show(repo:Repository,input:InputReader):NavCommand{
        println("Создание заметки (архив: ${archive.name})")
        println("Введите название заметки (0 — назад)")
        val title: String
        while (true){
            val t = input.readLine("Название: ").trim()
            if (t=="0")return NavCommand.Pop
            if(t.isBlank()){
                println("Название не может быть пустым. Попробуйте ещё раз.\n")
                continue
            }
            title = t
            break
        }
        println("\nВведите текст заметки (0 — назад)")
        val content:String
        while(true){
            val c = input.readLine("Текст: ")
            if (c.trim()=="0") return NavCommand.Pop
            if (c.isBlank()){
                println("Текст не может быть пустым. Попробуйте ещё раз.\n")
                continue
            }
            content = c
            break
        }
        archive.notes.add(Note(title,content))
        println("\nЗаметка \"$title\" создана.\n")
        return NavCommand.Pop
    }
}