class Archives {
    companion object {
         var archives: MutableList<Archive> = mutableListOf()     //Лист где хранятся архивы
        fun viewArchivesList() {                                 //Функция выводящая список архивов
            println("Список архивов: ")
            for (i in this.archives.indices) {
                println("${i}.${this.archives[i].name}")
            }
        }
    }
}