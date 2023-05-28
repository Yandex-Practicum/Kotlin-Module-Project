package datastructure

//класс по созданию структуры хренения данных
class Container {

    private val container = mutableListOf<Archive>()

    fun addArc(arch: Archive) {
        container.add(arch)
    }


    fun getArchTitles(): List<String> {
        return container.map { it.nameArchive }
    }


    fun getArch(id: Int): Archive {
        return container[id]
    }


}