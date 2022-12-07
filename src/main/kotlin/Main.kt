fun main() {

    val mainBox = BoxCase()  // Хранилище архивов
    var archive : Archive    // Выбранный архив
    var note : Note          // Выбранная заметка

    println("Консольное приложение для заметок")
    while(true) {
        when (mainBox.actionMenu()) {                       // Обработать действия пользователя при работе с архивами
            0 -> mainBox.createStorageUnit(Archive())           // Создать архив
            1 -> if (mainBox.selectStorageUnit()) {             // Выбрать архив
                    archive = mainBox.getUnit()                     // Получить архив из хранилища
                    while(true) {
                        when (archive.actionMenu()) {                // Обработать действия пользователя при работе с заметками
                            0 -> archive.createStorageUnit(Note())       // Создать заметку
                            1 -> if (archive.selectStorageUnit()) {      // Выбрать заметку
                                note = archive.getUnit()                     // Получить заметку из архива
                                note.createForEmpty(mainBox.keyName, archive.keyName) // Создать текст заметки, если пустая
                                note.view(mainBox.keyName, archive.keyName)           // Вывести название архива, название и текст заметки
                                }
                            2 -> break      // Выход
                        }
                    }
                }
            2 -> break      // Выход
        }
    }
    println("Окончание работы консольного приложения для заметок")
}

