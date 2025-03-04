import java.util.Scanner
fun main() {
    val archives = mutableListOf<Archive>()
    while (true){
        val option = MenuHelper.getUserOption(
            """
    Введите 0, чтобы создать архив
    Введите 1, чтобы посмотреть созданные архивы
    Введите 2, чтобы выйти
    """.trimIndent(), 0, 2
        )


        when (option){
            0 -> createArchive(archives)
            1 -> showArchives(archives)
            2 -> {
                println("Завершаем программу")
                break
            }
            else -> println("Некоректный ввод, введите цифру от 0 до 2")

        }
    }
}
fun createArchive(archives: MutableList<Archive>){

    while (true){
        println("Введите имя архива")
        val name = readLine() ?: ""
        if (archives.any { it.name == name }) {
            println("Архив с таким именем уже существует. Выберите другое имя.")
            continue
        }
        if (name.isEmpty()){
            println("Имя архива не может быть пустым")
            continue
        }else{
            archives.add(Archive(name))
            println("Архив $name создан")
            break
        }

    }

}
fun showArchives(archives: MutableList<Archive>){
    if (archives.isEmpty()) {
        println("У вас пока нет созданных архивов.")
        return
    }
    println("Ваши архивы:")
    archives.forEach{
            i -> println(i.name)
    }
    val put = MenuHelper.getUserOption(
        """
Введите номер архива, чтобы управлять им, или введите -1 для возврата:
""".trimIndent(), -1, archives.size - 1
    )
    if (put == -1){
        return
    }
    val archive = archives[put]
    manage(archive)

}
fun manage(archive: Archive) {
    while (true) {
        val option = MenuHelper.getUserOption(
            """
            Введите 0, чтобы добавить заметку
            Введите 1, чтобы просмотреть заметки
            Введите 2, чтобы вернуться назад
            """.trimIndent(), 0, 2
        )
        when (option) {
            0 -> createNote(archive)
            1 -> showNotes(archive)
            2 -> return
        }
    }
}
fun createNote(archive: Archive) {
    var title: String
    while (true) {
        println("Введите название заметки")
        title = readLine() ?: ""
        if (archive.notes.any { it.title == title }) {
            println("Заметка с таким названием уже существует в этом архиве. Пожалуйста, выберите другое название.")
            continue
        }
        if (title.isEmpty()) {
            println("Название заметки не может быть пустым")
            continue
        }else {break}

    }
    while (true){
        println("Введите содержание заметки")
        val content = readLine() ?: ""
        if (content.isEmpty()){
            println("заметка не может быть пустой")
            continue
        }else{
            archive.notes.add(Note(title, content))
            println("Заметка \"$title\" добавлена в архив \"${archive.name}\".")
            break
        }

    }
}

fun showNotes(archive: Archive){
    archive.notes.forEach{
            i -> println("Название заметки ${i.title}. Содержание: ${i.content}")
    }
}


