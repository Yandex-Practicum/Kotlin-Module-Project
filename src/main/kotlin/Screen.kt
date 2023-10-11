import java.util.Scanner
class Screen {
    val work=CreateAndChoice()
    val scanner = Scanner(System.`in`)
    fun screen() {
        println("Добро пожаловать в мои заметки (o˘◡˘o)")
        println("Введите число для дальнейших действий")
        while (true) {
            println("1-Создать архив \n2-Посмотреть мои архивы\n3-Выход")
            val choise = readLine()
            while(true){
                if(choise.equals("1")) {
                    screen11()
                    break
                }else if(choise.equals("2")){
                    work.showAllArchive()
                    screen2()
                    break
                }else if(choise.equals("3")){
                    break
                }else{ println("Неверный ввод,повторите снова")
                    break
                }
              }
           }
        }
    fun screen2() {
        val choice = scanner.next().toInt()
        when(choice){
          work.archives.size+1->screen()
        }
        if(work.archives[choice-1].notes.isEmpty()){
            println("Архив пуст\n1-Создать заметку\n2-Назад")
            when (scanner.next().toInt()){
                1-> { println("Введите имя заметки")
                    val name = scanner.next()
                    println("Введите текст заметки")
                   val text=scanner.next()
                  work.addNoteToArchive(choice-1,name,text)
                   println("Заметка $name создана")
                    }
                2-> screen()
            }
        }else{
            println("Ваши созданные заметки:\nВведите цифру,чтоб прочитать заметку или вернуться назад")
            work.getNoteList(choice-1)
            val noteA=work.getNoteList(choice-1)
            println("1-Добавить заметку")
            for (r in noteA.indices) {
              val number = r + 2
                println("$number- ${noteA[r]}")
            }
            println("${noteA.size + 2}-Назад")
        when(val sc=scanner.next().toInt()) {
         1 -> {     println("Введите имя заметки")
                    val name1 = scanner.next()
                    println("Введите текст заметки")
                    val text = scanner.next()
                    work.addNoteToArchive(choice - 1, name1, text)
                    println("Заметка $name1 создана")
         }
         noteA.size + 2 -> { work.showAllArchive()
                             screen2()
         }
        noteA.indices.step+1-> {
          val newnumber=noteA.indices.step-1
          val name:String=noteA[newnumber]
          val text=work.showText(choice-1,sc-2)
           println("Заметка '$name'. Текст заметки:$text ")
          }
        }
       }
    }
    fun screen11() {
        println("Введите название архива")
        val choice = scanner.nextLine()
         work.createArchive(choice)
    }
   }


