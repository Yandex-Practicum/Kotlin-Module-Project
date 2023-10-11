class CreateAndChoice {
    val archives = mutableListOf<Archives>()

    fun showAllArchive() {
        println("Введите номер архива, который хотите открыть")
        if (archives.isEmpty()){
            println("У вас нет еще ни одного архива.Вернитесь назад и создайте архив")
        }
        for (i in archives.indices) {
            var number=i+1
            println("$number- ${archives.map { it.nameA }[i]}" )
        }
        println("${archives.size+1}  Назад  ")
     //   println("0- Назад")
    }

    fun createArchive(nameA:String) {
        archives.add(Archives(nameA, mutableListOf()))
        println("Архив \"$nameA\" добавлен")
    }
    fun addNoteToArchive(numberA: Int, name: String, text: String) {
        archives[numberA].notes.add(Note(name, text))
    }

    fun getNoteList(numberA: Int):List<String>{
         return archives[numberA].notes.map { it.nameN }
    }

       fun showText (numberA:Int, numberN: Int):String {
        return archives[numberA].notes[numberN].text
    }


    }





