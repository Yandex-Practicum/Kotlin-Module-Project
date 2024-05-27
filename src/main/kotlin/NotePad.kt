object NotePad {

    private val notePad: MutableList<Archive> = mutableListOf()

    fun addArchive(name : String){
        val archive = Archive(name)
        notePad.add(archive)
    }

    fun getArchive(i: Int):Archive{
        return notePad[i]
    }

    fun sizeNotePad():Int{
        return notePad.size
    }
}