data class DataArchive(val name: String) {
    val notes = mutableListOf<Note>()
}

data class Note(val name: String, val text: String)//я решил их совместить в 1 пакете, они узко связаны между собой, да и засорять проект