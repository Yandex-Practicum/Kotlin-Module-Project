interface MenuInterface {
    abstract val parent: MenuInterface
    abstract val title: String

    abstract fun addContent(title: String)

    fun getPrevious(): MenuInterface {
        return parent
    }

    fun getTitles(): MutableList<String>

    fun getContent(userChoice: Int) : Any

//    abstract val contentList: MutableList<Any>
//    abstract fun addContent(title: String)
//
//    fun getTitles(): String  {
//        return contentList[index].title
//    }
//
//    fun getContent(userChoice: Int) : Any {
//        return contentList[userChoice - 1]
//    }
//
//    fun getPrevious(): MenuInterface? {
//        return parent
//    }

}