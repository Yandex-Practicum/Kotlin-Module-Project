interface MenuInterface<T> {
    fun showMenu(
        recordListMessage: String,
        createRecordMessage: String,
        exitMessage: String,
        mapOfRecords: MutableMap<Int, T>?
    )

    fun getRecordId(mapOfRecords: MutableMap<Int, T>?): Int
    fun checkRecordDescription(recordDescription: String)
    fun addRecord(recordId: Int, record: T, mapOfRecords: MutableMap<Int, T>?)
    fun getMenuOption(): Int
    fun menuOptionValidate(menuOption: Int, mapOfRecords: MutableMap<Int, T>?)
    fun exitFromMenuOption(mapOfRecords: MutableMap<Int, T>?): Int
}