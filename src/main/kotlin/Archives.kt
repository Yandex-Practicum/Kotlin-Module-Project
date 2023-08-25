class Archives {
    companion object {
         var archives: MutableList<Archive> = mutableListOf()
        fun viewArchivesList() {
            println("Список архивов: ")
            for (i in this.archives.indices) {
                println("${i}.${this.archives[i].name}")
            }
        }




    }
}