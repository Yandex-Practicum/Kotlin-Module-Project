var listOfArchives: MutableList<String> = mutableListOf()   //список созданных архивов
var listOfListOfNotes: MutableList<MutableList<String>> = mutableListOf(mutableListOf())    //список списков созданных заметок
var listOfListOfContents: MutableList<MutableList<String>> = mutableListOf(mutableListOf())   //список списков текстов созданных заметок
var archiveNum:Int=2                                                                            //номер архива, стартовое значение

val archives: MutableMap<String,MutableMap<String,String>> = mutableMapOf()
var menu1: Menu = Menu("Архивы", "Создать архив", "Открыть архив", listOfArchives)
var menu3: Menu = Menu("Заметки", "Создать заметку", "Открыть заметку"/*, listOfListOfNotes[archiveNum]*/)
var currentMenu: Menu = menu1
var lastMenu: Menu = menu1

fun printMenu() {
    while (true) {                                                           //Вывод любого меню на экран
        Menu.printCurrentMenu(currentMenu)
        //ввод и проверка на число
            val answerConverted = Menu.answerConverted()
            println()

        when (answerConverted){
            1 -> { lastMenu = currentMenu       //Первый пункт меню
                if (currentMenu==menu1){
                    screen2()           //Откроет экран 2: Создание архива
                    menu1 = Menu.openScreen(listOfArchives,"Архивы","Создать архив", "Открыть архив"/*, ::screen2*/)
                }
                else if (currentMenu==menu3){
                    screen4(archiveNum)    //Откроет экран 4: Создание заметки1
                    menu3 = Menu.openScreen(listOfListOfNotes[archiveNum-2],"Заметки", "Создать заметку", "Открыть заметку")
                }
            }
            currentMenu.newMenuArray.size -> {      //Последний пункт меню
                if (currentMenu == menu1) {         //завершение работы
                    println("Программа завершает работу...")
                    return
                }  else if (currentMenu==menu3) currentMenu = menu1   //или выход на предыдущее меню
            }
            else -> {
                if (answerConverted !in 1..currentMenu.newMenuArray.size && answerConverted!=1000) println("Вы не ввели номер пункта меню. Повторите ввод номера\n")
                else if(answerConverted==1000) {println("ОШИБКА: Введите цифру!")}
                else {
                    if (currentMenu == menu1){
                        archiveNum=answerConverted
                        lastMenu = currentMenu
                        //открываем архив с названием из выбранного пункта меню:
                        menu3 = Menu("Заметки", "Создать заметку", "Открыть заметку", listOfListOfNotes[archiveNum-2])
                        currentMenu = menu3
                        println("")
                        }
                    else if (currentMenu==menu3){                                           //Открыть заметку
                        lastMenu = currentMenu
                        screen5(answerConverted)
                        currentMenu = lastMenu
                    }
                }
            }
        }
    }
}