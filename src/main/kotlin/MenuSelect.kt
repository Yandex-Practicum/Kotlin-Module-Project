import java.util.*

class MenuSelect (val level : MenuLevel) {

    fun createMenu(level: MenuLevel, mapNotes: MapNotes, mapArhiv: MapArhiv) {

        println("Введите число соответствующее пункту меню: ") //
        if (level == MenuLevel.MainMenu) {
            println("1. Создать архив")
            println("2. Открыть имеющийся архив")
            println("3. Выход из программы")

        } else if (level == MenuLevel.NoteMenu) {
            val numPoints = mapNotes.mapNotes.size
            println("1. ${level.menuPoint()}")
            for (i in 2..numPoints + 1) {
                val notes = mapNotes.mapNotes.keys.toList()[i - 2]
                println("$i. $notes")
            }
            println("${numPoints + 2}. Возврат в предыдущее меню")

        } else if (level == MenuLevel.ArhivMenu) {
            val numPoints = mapArhiv.mapArhiv.size
            println("1. ${level.menuPoint()}")
            for (i in 2..numPoints + 1) {
                val arhives = mapArhiv.mapArhiv.keys.toList()[i - 2]
                println("$i. $arhives")
            }
            println("${numPoints + 2}. Возврат в предыдущее меню")
        }

    }


    fun readMenu(numPoints: Int): Int {
        val input = Scanner(System.`in`)

        while (true) {
            if (input.hasNextInt()) {
                val SelectPoint = (input.nextInt())
                for (i in 1..numPoints) {
                    if (SelectPoint == i) {
                        println("Запускаем пункт $i")
                    }
                    return SelectPoint
                }
                if (SelectPoint == numPoints + 1) {
                    println("Возврат на предыдущее меню")
                    return SelectPoint
                }
                if (SelectPoint > numPoints + 1) {
                    println("Введите другое число")
                }
            } else {
                println("Введите число!")
                input.next()
            }
        }
    }

}

enum class MenuLevel (val level: String) // конструктор
{
    MainMenu    ("Главное меню"),
    ArhivMenu   ("Архив"),
    NoteMenu    ("Заметка"),
;
    // метод класса
    fun menuPoint(): String {
        return when (this) {
            MainMenu    -> "Главное меню"
            ArhivMenu   -> "Создать архив"
            NoteMenu -> "Создать заметку"
        }
    }
}