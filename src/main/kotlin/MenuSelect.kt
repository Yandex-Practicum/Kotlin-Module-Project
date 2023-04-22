import java.util.*

class MenuSelect (val level : MenuLevel) {

    // Функция для создания разных уровней меню. Уровень меню опредлеяется параметром level
    // Функция принимект на вход массив Map, содержащий заметки для построения их списка
    // Функция возвращает количество созданных пунктов меню.

    fun makeMenu(level: MenuLevel, mapArhiv: MapArhiv, keyForMap: String) : Any? {
        println("Меню "+ level.levelName)
        println("Введите число, соответствующее пункту меню: ")

        if (level == MenuLevel.ArhivMenu) {                         // Уровень меню архивов
            val numPointsInMap = mapArhiv.mapArhiv.size             //размер архива
            println("0. ${level.menuPoint()}")                      //0 пункт. Создать.. Название берез из класса Enum
            for (i in 1..numPointsInMap) {                    // 1... и далее список Map в архиве
                val arhives = mapArhiv.mapArhiv.keys.toList()[i - 1]
                println("$i. $arhives")
            }
            println("${numPointsInMap + 1}. Выход из программы")    // печать последнего пункта. В режиме архивов - это выход из программы

            // далее вызываем считывание выбранного пункта:
            val pointMenu = readMenu(numPointsInMap + 1)
            // АНАЛИЗИРУЕМ ВЫБОР ПОЛЬЗОВАТЕЛЯ:
            if (pointMenu == 0) {                                   //если пользователь выбрал 0
                mapArhiv.makeArhiv()                                // создаем еще один архив
                return "archiveСreated"                             // возврат "archiveСreated" что Архив создан
            } else if (pointMenu == numPointsInMap + 1) {           // если пользовательвыбрал последний пункт
                return "exitApp"                                    //возвращаем фразу "exitApp" для выхода из программы
            } else {                                                // возвращаем название выбранного архива для последующего его открытия
                return mapArhiv.mapArhiv.keys.toList()[pointMenu - 1]
            }

        } else if (level == MenuLevel.NoteMenu) {                                   // Уровень меню заметок
            val numOfNotes = mapArhiv.mapArhiv[keyForMap]?.mutableMapNotes?.count()
            println("0. ${level.menuPoint()}")                                      //0 пункт. Создать.. Название берез из класса Enum
            for (i in 1..numOfNotes!!) {
                val notes = mapArhiv.mapArhiv[keyForMap]?.mutableMapNotes?.keys?.toList()?.get(i - 1)
                println("$i. $notes")
            }
            println("${numOfNotes + 1}. Возврат в предыдущее меню")

            // далее вызываем считывание выбранного пункта:
            val pointMenu = readMenu(numOfNotes + 1)
            // АНАЛИЗИРУЕМ ВЫБОР ПОЛЬЗОВАТЕЛЯ:
            if (pointMenu == 0) {
                mapArhiv.mapArhiv[keyForMap]?.makeNote(mapNotes = mapArhiv.mapArhiv[keyForMap]!!)   // создать новую заметку в makeNote
                return "noteCreated"
            } else if (pointMenu == numOfNotes + 1) {                               // если пользовательвыбрал последний пункт
                return "exitMenu"                                                   //возвращаем фразу "exitMenu"
            } else {                                                                // если пользователь выбрал конкретную заметку
                return mapArhiv.mapArhiv[keyForMap]?.mutableMapNotes?.keys?.toList()?.get(pointMenu - 1)         // возвращаем название выбранной заметки
            }
        } else {
            return 0
        }
    }

/*
Функция readMenu(numPoints: Int): Int "читает" ввод пользователя и проверяет его правильность
Затем возвращает выбранный пункт
 */
    fun readMenu(numPoints: Int): Int {
        val input = Scanner(System.`in`)

        while (true) {
            if (input.hasNextInt()) {
                val SelectPoint = (input.nextInt())

                if (SelectPoint in 0.. numPoints) {
                      return SelectPoint
                } else {
                    println("Введите другое число")
                }

            } else {
                println("Введите число!")
                input.next()
            }
        }
    }
}

enum class MenuLevel (val levelName: String) // класс Enum будет хранить названия и свойства разных меню
{
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
