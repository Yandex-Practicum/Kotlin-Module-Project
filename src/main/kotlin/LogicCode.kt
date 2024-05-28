import kotlin.system.exitProcess

object Object {
    private val mutableArchive = mutableMapOf<Int, Archive>()
    private var integer : Int? = null

    fun checkArchives() {
        println(" ")
        menuArchive()
        val number = readln().toIntOrNull() ?: return checkArchives()
        when (number) {
            1 -> createArchive() /*Создать Архив*/
            2 -> if (mutableArchive.isEmpty()) {
                println("Архив еще не создан")
                checkArchives()
            } else {
                for (i in mutableArchive) {
                    println(" ${i.key} - ${i.value.title}")
                }
                println("Выберите архив")
                val number = readln().toIntOrNull() ?: return checkArchives()
                if (number <= 0 || number > mutableArchive.size) {
                    println("Такого номера нет")
                    checkArchives()
                } else {
                    checkNotes(number)
                }

            }

            3 -> exitProcess(3)
            else -> {
                println("Выберите пункт меню -1")
                checkArchives()
            }
        }
    }

    fun createArchive() {
        println("Введите название архива ")
        val string = readlnOrNull() ?: return createArchive()
        val put = mutableArchive.put(mutableArchive.size + 1, Archive(string))
        println("архив $string создана")
        checkArchives()
    }

    fun checkNotes(int : Int?) {
        println("Архив - ${mutableArchive[int]!!.title}")
        menuNote()
        val n = readln().toIntOrNull() ?: return checkNotes(int)
        when (n) {
            1 -> createNote(int)
            2 -> if (mutableArchive[integer]?.map?.isEmpty() == true) {
                println("Заметки еще не созданы")
                checkNotes(int)
            } else {
                readNote()
            }

            3 -> checkArchives()
            else -> {
                println("Выберите пункт меню")
                checkNotes(int)
            }
        }
    }

    fun createNote(int : Int?) {
        integer = int
        println("Введите название заметки")
        val string = readlnOrNull()
        println("Введите текст заметки")
        val text = readlnOrNull()
        val itn = mutableArchive[integer]?.map?.size
        println("Размер ${mutableArchive.values.size}")
        val put =
                mutableArchive[integer]?.archiveAddMap(
                    itn!!,
                    Note(string.toString(), text.toString())
                )
        println("заметка $string добавлена в архив ${mutableArchive[int]!!.title}")
        checkNotes(int)
    }

    fun readNote() {
        println(" ")
        println("Архив ${mutableArchive[integer]?.title}")
        mutableArchive[integer]?.getNot().toString()
        println("Выберите пункт меню")
        menuFoNote()
        val number = readln().toIntOrNull() ?: return println("введите значение")
        when (number) {
            1 -> {
                println("Выберите заметку")
                mutableArchive[integer]?.getNot().toString()
                val number = readln().toIntOrNull() ?: return readNote()
                println("Заметка - ${mutableArchive[integer]?.map?.get(number - 1)?.title}")
                println("Текст - ${mutableArchive[integer]?.map?.get(number - 1)?.content}")
                Thread.sleep(5000)
                println(" ")
                readNote()
            }

            2 -> checkNotes(1)
            else -> {
                println("Выберите пункт меню")
                checkNotes(1)
            }
        }
    }
}

