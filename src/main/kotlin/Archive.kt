class Archive (val name : String) {

    var archive: MutableList<Note> = mutableListOf()

    fun addNote(note : Note){
        archive.add(note)
    }

    fun getNote(i:Int):Note{
        return archive[i]
    }

    fun sizeArchive():Int{
        return archive.size
    }

}