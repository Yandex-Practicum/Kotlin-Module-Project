import Archive.Archive
import ArchiveCollection.ArchiveCollection

enum class Menu(val menuList: String) {
    CHOSEARCHIVE(menuList = "0. Create a new archive \n1. Chose one \n2. Exit"),
    CREATEARCHIVE(menuList = "Enter name of new archive, or 0 to Go Back..."),
    CHOSENOTE(menuList = "0. Create a new note \n1. Chose one  \n2. Go Back"),
    CREATENOTE(menuList = "Enter a text of the Note, or 0 to Go Back"),
    NOTEVIEW(menuList = "Type 0 to go back");

    override fun toString(): String = "- - - - - -\n\n" + menuList + "\n\n- - - - - -"

    val createArchive: (String) -> Unit = { ArchiveCollection.addArchive(Archive(name = it)) } //Ф-ия добавляющая новый архив

    val createNote: (String) -> Note = { Note(textOfNote = it) } // Ф-ия добавления новой записки

    // ф-ия, которая в зависимости от типа меню возвращает лямбду, для выполнения действия
    fun createActivity() = when {
        this == CHOSEARCHIVE -> createArchive
        this == CHOSENOTE -> createNote
        else -> println("")
    }

    // Ф-ия возвращает выбранный пользователем архив. Выбор производится по средствам ввода названия архива
    val choseArchive: (name: String) -> Archive? =
        { name -> ArchiveCollection.choseArchive(name) }
    // Ф-ия возращает выбранную пользователем записку. Выбор производится по средствам ввода названия записки
    val choseNote: (name: String, archive: Archive) -> Note? =
        { name, archive -> archive.choseNote(name) }

    fun choseActivity() = when {
        this == CHOSEARCHIVE -> choseArchive
        this == CHOSENOTE ->choseNote
        else -> println("")
    }

}

