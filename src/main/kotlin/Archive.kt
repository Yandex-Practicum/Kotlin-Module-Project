/*
класс Архив содержит поле название архива, и контент - изменяемый список заметок.
заметки first и second введены для тестов, чтобы можно было посмотреть на работу функции showContent
функция showContent в перспективе предположительно должна использоваться для создания меню
*/

class Archive(
    val name: String
) {
    val first = Note("Заметка 1", "Текст Заметки один")
    val second: Note = Note("Заметка 2", "Текст заметки Два")
    val content: MutableList<Note> = mutableListOf(first, second)

    fun showContent() {
        for(i in content) {
            println("${content.indexOf(i)}: ${i.name}")
        }
    }
}