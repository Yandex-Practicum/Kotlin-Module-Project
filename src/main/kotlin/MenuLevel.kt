enum class MenuLevel (val levelName: String){
// класс Enum будет хранить названия и свойства разных меню

    MainMenu    ("Главное меню"),
    ArhivMenu   ("АРХИВ"),
    NoteMenu    ("ЗАМЕТКИ"),
    ;
    // метод класса
    fun menuPoint(): String {
        return when (this) {
            MainMenu    -> "Главное меню"
            ArhivMenu   -> "Создать архив"
            NoteMenu    -> "Создать заметку"
        }
    }
}