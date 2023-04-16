
import java.util.*
import kotlin.random.Random

fun main(args: Array<String>) {
    println("Приложение Заметки. Добрый день!") // поздоровайтесь с пользователем
    var levelMenu  = MenuLevel.ArhivMenu   // Задаем уровень меню - уровни описаны в Enum class MenuLevel (val level: String)
    var pointMenu = 0                       // Задаем возвращаемый пункт мюню выбранного уровня

    val mapNotes = MapNotes ("Заметка 1", "Это содержание первой заметки")
    mapNotes.addMapNotes(mapNotes.mapNotes,"Заметка 2", "Это содержание второй заметки")
    val mapArhiv = MapArhiv ("1 архив", mapNotes)
    // Создаем обьект класса MenuSelect
    val menu = MenuSelect(levelMenu)
    val sizeMap = mapNotes.mapNotes.size

    //Зацикливаем всю работу по вызову разных меню до момента выбора пункта меню Выход из программы в Главном меню
     do { //программа будет работать до тех пор пока в Главном меню пользователь не выберет пункт 3
        // 1. Создаем меню выбранного уровня
        menu.createMenu(levelMenu, mapNotes, mapArhiv)

        // 2. Считываем выбор пользователя, возвращаемый функцией readMenu
        val pointMenu = menu.readMenu(mapNotes.mapNotes.size)

        // 3. Если выбрано создание нового архива или заметки
        if (levelMenu==MenuLevel.NoteMenu  && pointMenu==1) { mapNotes.makeNote()    }
        if (levelMenu==MenuLevel.ArhivMenu && pointMenu==1) { mapArhiv.makeArhiv()   }

        // Это контроль значений
        println("Возврат функции readMenu : $pointMenu")
        println("Уровень levelMenu : $levelMenu")
        println ("================================")

        // 4. Если изменен уровень меню (выбран соответствующий, последний пункт):
         if (levelMenu==MenuLevel.NoteMenu  && pointMenu==2+mapNotes.mapNotes.size) { levelMenu  = MenuLevel.ArhivMenu  }
         if (levelMenu==MenuLevel.ArhivMenu && pointMenu==2+mapArhiv.mapArhiv.size) { levelMenu  = MenuLevel.MainMenu   }

    } while (!(levelMenu==MenuLevel.MainMenu  &&  pointMenu==3))

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
