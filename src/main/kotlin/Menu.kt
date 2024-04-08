import kotlin.system.measureNanoTime

object Menu {
    var mainMenuList = mutableMapOf<Int, String>(
        1 to "Создать архив",
        2 to "Список Архивов",
        3 to "выход"
    )
    var archiveMenuMap = mutableMapOf<Int, String>(
        1 to "Создать земетку",
        2 to "Открыть список заметок данного архива",
        3 to "выход"
    )
    var noteMenuMap = mutableMapOf<Int, String>(
        1 to "посмотреть содержимое заметки",
        2 to "дополнить заметку",
        3 to "выход"
    )
    var inArchiveListMap = mutableMapOf<Int, String>(
        1 to "Введите: - номер архива, который надо открыть...",
        2 to "Введите: - ВЫХОД, чтобы покинуть список архивов.."
    )

    fun stringForArchiveOpen() {
        println("\nВведите номер архива, который надо открыть:")
    }

    fun stringNoteOpen(name: String) {
        println("\nАрхив ${name} открыт")
    }

    fun stringArchiveNotExist() {
        println("\nДанного архива не существует..")
    }

    fun stringNoteNotHere() {
        println("\nВ даннос архиве пока-что заметок нет.")
    }

    fun strinAdditioanalInput() {
        println("\nВведите дополнительный текст:")
    }

    fun exitFromWhere() {
        println("Был использова ВЫХОД.")
    }

    fun exitFromApp() {
        println("\nВыход осуществлён. Ждём вас с нетерпением в следующий раз....Ваши ЗАМЕТКИ....")
    }

    fun inputActionNumber() {
        println("\nВведите номер действия:")
    }

    fun stringBeforArchiveList(condition: Boolean) {
        if (condition) println("\nСписок созданных архивов:")
    }

    fun archiveIsReady_infoMessege(titel: String) {
        println("\nАрхив ${titel} создан.\n")
    }

    fun need_titel_Messega_for_user() {
        println("\nВведите название архива.")
    }

    fun inputNoteTitel() {
        println("\nВведите название.")
    }

    fun inputNoteText() {
        println("\"Введите текст заметки\"")
    }

    fun noteListInputForArchive(name: String) {
        println("\nСписок заметок архива: ${name}")
    }

    fun writeNoteNumForLook(condition: Boolean) {
        if (condition) {
            println("\nВведите номер заметки для её просмотра")
            println("Введите: ВЫХОД, чтобы покинуть список заметок.")
        } else {
            println("Введите: ВЫХОД, чтобы покинуть список заметок.")
        }
    }

    fun noteName(name: String) {
        println("\nЗаметка: ${name}")
    }

    fun mainScreeenMenu() {
        for (mapValue in mainMenuList) {
            println("${mapValue.key} - ${mapValue.value}")
        }
        println("\nВведите номер дальнейшего действия: ")
    }

    fun allArchiveMenu(condition: Boolean) {
        if (condition) {
            for (mapValue in inArchiveListMap) {
                println("${mapValue.value}")
            }
        } else {
            println("Введите: - ВЫХОД, чтобы покинуть список архивов..\"")
        }
    }

    fun newArchiveMenu() {
        for (mapValue in archiveMenuMap) {
            println("${mapValue.key} - ${mapValue.value}")
        }
    }

    fun noteMenu() {
        for (mapValue in noteMenuMap) {
            println("${mapValue.key} - ${mapValue.value}")
        }
    }
}
