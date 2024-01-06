class Note(override val name:String) : Folder() {
    constructor() : this("")
var content : String= ""
    override var caseName: String = "заметок"
    override val itemsName: String
        get() = "заметку"
    override val exitName: String
        get() = "Назад"
    override val correctName: String
        get() = "Название заметки"

}
