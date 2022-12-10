object Storage {

    private val storage: LinkedHashMap<String, MutableList<String>> = linkedMapOf()
    fun getStorage(): LinkedHashMap<String, MutableList<String>>{
        return storage
    }
}