class ArchiveArr {
    private val scan: GeneralScanner = GeneralScanner()
    private var arr :MutableList<Archive> = mutableListOf()

    private fun printMenu(){
        println("Доброго времени суток")
        println("1.Посмотреть Архивы")
        println("2.Выбрать Архив")
        println("3.Создать Архив")
        println("4.Выйти")
    }

    fun start(){
        printMenu()
        var inpu : Int  = -1
        while(true) {
            scan.takeInt { it -> inpu = it}
            when (inpu) {
                1 -> {
                    println("Смотрим архивы")
                    viewingArchives()
                }
                2 -> selectArchives()
                3 -> addArchive()
                4 -> return
                else -> println("Невернный ввод")
            }
        }
    }

    private fun addArchive(){
        scan.takeName { it -> arr.add(Archive(it)) }
    }

    private fun selectArchives(){
        println("Выберите архив")
        var inpu : Int  = -1
        println("0. Вернутся назад")
        viewingArchives()
        while(true){
            scan.takeInt { it -> inpu = it}
            if(inpu == 0 ) {
                return
            } else {
                if (inpu >= 1 && inpu <= arr.size) {
                    arr[inpu-1].menu(scan,{it->deletingArchive(it)})
                    return
                }else {
                    println("Неверный ввод")
                }
            }
        }
    }

    private fun viewingArchives(){
        var i = 1
        if(arr.size == 0){
            println("Пусто")
        } else {
            arr.forEach() {
                println(i.toString()+ ". " + it.name)
                i++
            }
        }
    }
    private fun deletingArchive(archive: Archive){
        arr.remove(archive)
    }
}