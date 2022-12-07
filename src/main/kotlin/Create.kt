fun create(name: String){
    if(name == "Архив"){
        println("Введите название архива:")
        val n = scanner.nextLine()
        arhive[n] = mutableListOf()
    } else{
        println("Введите текст заметки:")
        val note = scanner.nextLine()
        arhive[archiveName]!!.add(note)
    }
}