import java.util.*
import kotlin.collections.HashMap

class ArchiveCollector(val _name : String): MenuObject<Archive>() {

    override var FIRST: String = "Создать архив"
    override var LAST: String = "Выход"
    val name = _name

    fun createArchive(){

        println("Введите имя архива")

            val sc: Scanner = Scanner(System.`in`)
            collection.add(Archive(sc.nextLine()))


    }

    override fun executeCommand(index: Int, hs: HashMap<Int, String>) {

        var command = hs.getValue(index);

        when (command){
            "Выход" -> return;
            "Создать архив"-> createArchive()
            else -> collection.find { archive -> archive.name == command}
                ?.createMenu()

        }
        createMenu()
    }


}
