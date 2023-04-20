
import java.util.*
import kotlin.random.Random

fun main(args: Array<String>) {
    println("Приложение Заметки. Добрый день!") // поздоровайтесь с пользователем
    var levelMenu = MenuLevel.ArhivMenu  // Задаем уровень меню - уровни описаны в Enum class MenuLevel (val level: String)

    var exitApp = false                     // Переменная, определяющая выход из программы

    val mapNotes = MapNotes(mutableMapOf<String, String>())
    //mapNotes.addMapNotes(mapNotes, "Заметка 2", "Это содержание второй заметки")
    val mapArhiv = MapArhiv(mutableMapOf<String, MapNotes>())
    // Создаем обьект класса MenuSelect
    val menu = MenuSelect(levelMenu)
    var keyReturned : Any? = ""
    //Зацикливаем всю работу по вызову разных меню до момента выбора пункта меню Выход из программы в Главном меню


    println("НАЧИНАЕТСЯ ВТОРАЯ ЧАСТЬ ПРОГРАММЫ - первую впоследствии удалить!")

    //Зацикливаем всю работу по вызову разных меню
    do {

        if (levelMenu == MenuLevel.ArhivMenu){
            // 1. Создаем меню выбранного уровня. Функция makeMenu возвращает выбор пользователя в переменную keyReturned
            // Если makeMenu вернет
             keyReturned = menu.makeMenu(levelMenu, mapArhiv, "")

            println (mapArhiv.mapArhiv.contains(keyReturned))
                                                                        //mapArhiv.mapArhiv[keyReturned]?.addNote()
            if (mapArhiv.mapArhiv.contains(keyReturned)) {
                                                                        println("ПЕРЕВОДИМ УРОВЕНЬ МЕНЮ на NoteMenu")
                levelMenu = MenuLevel.NoteMenu

                println(mapArhiv.mapArhiv[keyReturned])
                //println(mapArhiv.mapArhiv.values)
                                                                    //println(mapArhiv.mapArhiv.entries.toList())
                                                                    //println(mapArhiv.mapArhiv.entries.toList()[0])
            }
          }
        val keyForMap = keyReturned.toString()

        if (levelMenu == MenuLevel.NoteMenu){
            // 1. Создаем меню выбранного уровня. Функция makeMenu возвращает выбор пользователя в переменную keyReturned
            // Если makeMenu вернет

            var keyReturned = menu.makeMenu(levelMenu, mapArhiv, keyForMap)
            if (keyReturned=="exitMenu") {
                levelMenu = MenuLevel.ArhivMenu

            } else {
                println("ЗДЕСЬ Напечатем содержание заметки keyReturned: $keyReturned")
                println(mapArhiv.mapArhiv[keyForMap]?.mutableMapNotes?.get(keyReturned)?.toString())
            }
        }
             println("Здесь напечатем название выбранного массива заметок:")
             println( mapArhiv.mapArhiv.keys)
             //mapNotes.mutableMapNotes.keys.toList()[pointMenu - 1]

        println ("================================")
             // Это контроль значений
             println("Возврат функции makeMenu : $keyReturned")
             println("Уровень levelMenu : $levelMenu")


         println ("================================")
    } while (keyReturned!="exitMenu")

}


/*
Критерии успешного выполнения задания:
Есть меню с возможностью добавления и просмотра архивов.
Есть меню с возможностью добавления и просмотра заметок.
Есть возможность добавлять и просматривать текст заметок.
Не должно быть повторений одного и того же кода. Вся логика по считыванию ввода пользователя и вывода пунктов на экран должна переиспользовать один и тот же код.
Ошибочный ввод пользователя должен корректно обрабатываться.
Из любого меню можно выйти и попасть на предыдущее меню или выйти из программы, если это просмотр архива.
Приложение успешно компилируется и выполняется без ошибок.
Весь код не написан в одном файле Main.
Весь код приложения написан на Kotlin.*/



// do { //программа будет работать до тех пор пока в Главном меню пользователь не выберет пункт 3
//            // 1. Создаем меню выбранного уровня. Функция createMenu возвращает выбор пользователя
//            var pointMenu = menu.createMenu(levelMenu, mapNotes, mapArhiv)
//
//            if (levelMenu == MenuLevel.ArhivMenu) {
//                if (pointMenu == 0) {
//                    mapArhiv.makeArhiv()
//                    println("СОЗДАЕМ запись в архиве")
//                } else if (pointMenu == mapArhiv.mapArhiv.count() + 1) {
//                    exitApp = true    // условия для выхода из программы
//                } else if (pointMenu <= mapArhiv.mapArhiv.count()) {
//                    println(mapArhiv.mapArhiv.keys)
//                    println(mapArhiv.mapArhiv.values)
//                    println(mapArhiv.mapArhiv.entries.toList())
//                    println(mapArhiv.mapArhiv.entries.toList()[0])
//                    println(mapArhiv.mapArhiv.entries.toList()[1])
//                    val keyArhiv = mapArhiv.mapArhiv.keys.toList()[pointMenu - 1]
//                    println(mapArhiv.mapArhiv[keyArhiv])
//                }
//
//            } else if (levelMenu == MenuLevel.NoteMenu) {
//                if (pointMenu == 0) {
//                    mapNotes.makeNote(mapNotes)
//                    println("СОЗДАЕМ запись в карте")
//                } else if (pointMenu == mapArhiv.mapArhiv.count() + 1) {
//                    levelMenu = MenuLevel.ArhivMenu     // переходим на уровень выше
//                } else if (pointMenu <= mapArhiv.mapArhiv.count()) {
//                    println(mapArhiv.mapArhiv.keys.toString())
//                }
//            }
//
//
//
//            println("Здесь напечатем название выбранного массива заметок:")
//            println(mapArhiv.mapArhiv.keys)
//            //mapNotes.mutableMapNotes.keys.toList()[pointMenu - 1]
//
//            // Это контроль значений
//            println("Возврат функции readMenu : $pointMenu")
//            println("Уровень levelMenu : $levelMenu")
//
//            println("================================")
//        } while (!exitApp)*/
// */
