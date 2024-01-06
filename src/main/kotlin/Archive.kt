 class Archive(override val name:String) : Folder(){
    constructor():this("")

    val noteSet:MutableSet<Folder> = mutableSetOf()
     override var caseName: String = "архивов"
     override val itemsName: String
         get() = "архив"
     override val exitName: String
         get() = "Выход"
     override val correctName: String
         get() = "Название архива"

}