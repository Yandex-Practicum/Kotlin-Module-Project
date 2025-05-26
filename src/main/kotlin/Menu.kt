import kotlin.system.exitProcess

class Menu () {

    private val listArchive = mutableListOf<Archive>()

    private val textItemMenu:String = "Укажите пункт меню: "
    private val textErrorItemMenu:String = "Данный пункт меню отсутствует. Попробуйте еще раз:"

    fun viewMenu() {
        while (true) {
            println("*** ГЛАВНОЕ МЕНЮ ***")
            println("1. Создать архив")
            println("2. Просмотреть архивы")
            println("0. Выход")

            print(textItemMenu)

            while (true){
                when (CheckingDataEntry().checking()) {
                    0 -> exitProcess(0)
                    1 -> createArchive()
                    2 -> showArchive()
                    else -> print(textErrorItemMenu)
                }
            }
        }
    }

    private fun createArchive() {
        println("Укажите название архива:")
        val nameArchive = CheckingDataEntry().inputStringName()

        listArchive.add(Archive(nameArchive))
        println("Создан архив '$nameArchive'.")
    }

    private fun showArchive() {
        if (CheckingDataEntry().checkingCollection(listArchive)) {
            listArchive.forEachIndexed{ index, archive ->
                println("${index + 1}. ${archive.name}")
            }
            selectArchive()
        }
    }

    private fun selectArchive() {
        print("Выберите 'элемент' для просмотра (или 0 - для возврата):")
        val res = CheckingDataEntry().checking()

        when(res) {
            0 -> viewMenu()
            else ->
                if (res >= 1) {
                    val numberArchive = res - 1
                    if (listArchive.elementAtOrNull(numberArchive) != null) {
                        val archive = listArchive[numberArchive]
                        menuArchive(archive)
                    }
                    else println("Указанный элемент отсутствует")
                }
        }
    }

    private fun menuArchive(archive: Archive) {
        while (true) {
            println("Архив '${archive.name}':")
            println("1. Добавить заметку")
            println("2. Просмотреть заметки")
            println("0. Возврат")

            print(textItemMenu)
            when (CheckingDataEntry().checking()) {
                0 -> showArchive()
                1 -> archive.createNote()
                2 -> archive.displayNotes()
                else -> print(textErrorItemMenu)
            }
        }
    }

}