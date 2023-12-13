import java.util.Scanner

fun main(args: Array<String>) {

    val list : MutableMap<Int, Archive> = mutableMapOf()


    fun showMenu(): Unit {
        println("Список архивов:\n0. Создать архив")
        for ((key, value) in list) {
            println("$key. ${value.name}")
        }
        println("${list.size + 1}. Выйти")
    }

    fun open (number: Int){

        fun showNote(numberOfNote: Int) {
            println(list[number]?.listOfNotes?.get(numberOfNote)?.text)
        }

        while (true){
            list[number]?.showListOfNotes()
            try {
                val chooseNote = Scanner(System.`in`).nextInt()
                if ((chooseNote<0) or (chooseNote> list[number]?.listOfNotes?.size?.plus(1)!!)){
                    println("Введите число от 0 до ${list[number]?.listOfNotes?.size?.plus(1)!!}")
                }else{
                    when (chooseNote){
                        0 -> {
                            println("Введите название заметки")
                            val nameNote = Scanner(System.`in`).nextLine()
                            if (nameNote.isNotEmpty()) {
                                val note = Note(nameNote)
                                list[number]?.listOfNotes?.put((list[number]?.listOfNotes?.size!! + 1), note)

                                println("Введите текст для заметки")
                                while (true){
                                    val textInNote = Scanner(System.`in`).nextLine()
                                    if (textInNote.isNotEmpty()) {
                                        list[number]?.listOfNotes?.get(list[number]?.listOfNotes?.size!!)?.text = textInNote
                                        break
                                    } else{
                                        println("Содержание заметки не может быть пустым. Введите ещё раз")
                                    }
                                }
                            } else{
                                println("Название заметки не может быть пустым. Попробуйте создать ещё раз")
                            }
                        }
                        in 1..list[number]?.listOfNotes?.size!! -> showNote(chooseNote)
                        (list[number]?.listOfNotes?.size?.plus(1)) -> break
                    }
                }
            }catch (e: java.util.InputMismatchException){
                println("Введите число")
            }



        }

    }

    while (true) {
        showMenu()
        try {
            val choose = Scanner(System.`in`).nextInt()
            if ((choose<0) or (choose>list.size+1) ){
                println("Введите число от 0 до ${list.size+1}")
            } else{
                when (choose){
                    0 -> {
                        println("Введите название архива")
                        val nameA = Scanner(System.`in`).nextLine()
                        if(nameA.isNotEmpty()){
                            val archive = Archive(nameA)
                            list[(list.size+1)] = archive
                        } else{
                            println("Название архива не может быть пустым")
                        }


                    }
                    in 1..list.size -> open(choose)
                    (list.size + 1) -> break
                }
            }
        } catch (e: java.util.InputMismatchException){
            println("Введите число")
        }


    }



}

