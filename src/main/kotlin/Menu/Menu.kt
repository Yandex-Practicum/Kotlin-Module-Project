import Archive.Archive
import ArchiveCollection.ArchiveCollection

enum class Menu(val menuList: String) {
    CHOSEARCHIVE(menuList = "0. Create a new archive \n1. Chose one \n2. Exit"),
    CREATEARCHIVE(menuList = "Enter name of new archive, or 0 to Go Back..."),
    CHOSENOTE(menuList = "0. Create a new note \n1. Chose one  \n2. Go Back"),
    CREATENOTE(menuList = "Enter a text of the Note, or 0 to Go Back"),
    NOTEVIEW(menuList = "Type 0 to go back");

    override fun toString(): String = "- - - - - -\n\n" + menuList + "\n\n- - - - - -"

    val createArchiveAct0: (String) -> Archive = { Archive(name = it) }
    val goBack: () -> Unit = {}
    val createNoteAct0: (String) -> Note = { Note(textOfNote = it) }

    fun zeroActivity() = when {
        this == CHOSEARCHIVE -> createArchiveAct0
        this == CREATEARCHIVE -> goBack
        this == CHOSENOTE -> createNoteAct0
        this == CREATENOTE -> goBack
        else -> goBack
    }

    val choseArchive: (name: String, archiveCollection: ArchiveCollection) -> Archive? =
        { name, archiveCollection -> archiveCollection.choseArchive(name) }
    val choseNote: (name: String, archive: Archive) -> Note? =
        { name, archive -> archive.choseNote(name) }
    val errorOfAction: () -> Unit = { println("Error") }

    fun firstActivity() = when {
        this == CHOSEARCHIVE -> choseArchive
        this == CHOSENOTE ->choseNote
        else ->errorOfAction
    }

}

