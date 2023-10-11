class Archive (override var name: String):Menuable{
    val notes:ArrayList<Note> = arrayListOf()
}
class Note(override var name: String, var text:String=""):Menuable{
}
 object Vault{
        val archives:ArrayList<Archive> = arrayListOf()
 }
interface Menuable{
    abstract var name:String
}