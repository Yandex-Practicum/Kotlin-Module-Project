import java.util.Scanner
import kotlin.system.exitProcess

class MainMenu(scanner: Scanner) : Menu(scanner) {
    init {
        items.add(Item(0, "Выход", ::goExit))
        items.add(Item(1, "Архив", ::archiveMenu))
        items.add(Item(2, "Заметка", ::noteMenu))
    }


    private fun goExit(archives: HashMap<String, HashMap<String, String>>) {
        println("До свидания!")
        System.exit(1)
    }


    private fun archiveMenu(archives: HashMap<String, HashMap<String, String>>) {
        val archiveMenu = ArchiveMenu(scanner)
        archiveMenu.show(archives)
    }

    private fun noteMenu(archives: HashMap<String, HashMap<String, String>>) {
        val noteMenu = NoteMenu(scanner, archives)
        noteMenu.show(archives)
    }
}