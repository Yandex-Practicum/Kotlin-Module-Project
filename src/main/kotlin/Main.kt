
import java.util.*
import kotlin.random.Random

fun main(args: Array<String>) {
    println("Приложение Заметки. Добрый день!") // поздоровайтесь с пользователем
    var levelMenu = MenuLevel.ArhivMenu  // Задаем уровень меню - уровни описаны в Enum class MenuLevel (val level: String)

    //val mapNotes = MapNotes(mutableMapOf<String, String>())

    val mapArhiv = MapArhiv(mutableMapOf<String, MapNotes>())

    // Создаем обьект класса MenuSelect
    val menu = MenuSelect(levelMenu)
    var keyReturned : Any? = ""

    //Зацикливаем всю работу по вызову разных меню до момента выбора пункта меню Выход из программы в Главном меню
    do {
        println(" ")
        if (levelMenu == MenuLevel.ArhivMenu){
            // 1. Создаем меню выбранного уровня. Функция makeMenu возвращает выбор пользователя в переменную keyReturned

             keyReturned = menu.makeMenu(levelMenu, mapArhiv, "")

             if (mapArhiv.mapArhiv.contains(keyReturned)) {   //проверка если есть такой архив
                 levelMenu = MenuLevel.NoteMenu                 // то открываем его:
             }
          }
        val keyForMap = keyReturned.toString()                  // сохраним ключ только что переданного архива для его открытия

        if (levelMenu == MenuLevel.NoteMenu){
            // 1. Создаем меню ЗАМЕТОК. Функция makeMenu возвращает выбор пользователя в переменную keyReturned

            var keyReturned = menu.makeMenu(levelMenu, mapArhiv, keyForMap)
            if (keyReturned=="exitMenu") {
                levelMenu = MenuLevel.ArhivMenu                     // если вернет exitMenu -> перейти в меню Архивов
            } else {
                println("Содержание заметки $keyReturned :")
                println(mapArhiv.mapArhiv[keyForMap]?.mutableMapNotes?.get(keyReturned)?.toString())
            }
        }

        println ("================================")
    } while (keyReturned!="exitMenu")
    println("Вы вышли из программы")
}


/*
Критерии успешного выполнения задания:
+ Есть меню с возможностью добавления и просмотра архивов.
+ Есть меню с возможностью добавления и просмотра заметок.
+ Есть возможность добавлять и просматривать текст заметок.
Не должно быть повторений одного и того же кода. Вся логика по считыванию ввода пользователя и вывода пунктов на экран должна переиспользовать один и тот же код.
+ Ошибочный ввод пользователя должен корректно обрабатываться.
+ Из любого меню можно выйти и попасть на предыдущее меню или выйти из программы, если это просмотр архива.
+ Приложение успешно компилируется и выполняется без ошибок.
+ Весь код не написан в одном файле Main.
+ Весь код приложения написан на Kotlin.*/

