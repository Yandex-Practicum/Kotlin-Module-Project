abstract class Folder(open val name:String){
    constructor():this("")
    abstract var caseName : String
    abstract val itemsName: String
    abstract val exitName: String
    abstract val correctName: String

}