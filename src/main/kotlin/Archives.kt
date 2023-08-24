class Archives {
    companion object {
         var archives: MutableList<Archive> = mutableListOf()
        fun viewArchivesList() {
            for (i in this.archives.indices) {
                println("${i}.${this.archives[i].name}")
            }
        }




    }
}