package entity

data class Note(
    val id: Int,
    var idGroup: Int,
    var group: String,
    var name: String,
    var description: String,
    var date: String
)