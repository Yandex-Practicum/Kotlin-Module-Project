package screens

abstract class CreateScreenAbstract {
    abstract val startOfCreationLine: String
    abstract val endOfCreationLine: String
    abstract fun readElement(parentId: Int)

    fun start(parentId: Int) {
        println(startOfCreationLine)
        readElement(parentId)
        println(endOfCreationLine)
    }
}