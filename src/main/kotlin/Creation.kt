class Creation {
    companion object {
        fun createArchive(name: String): Boolean {
            println("Архив $name создан")
            return Archive.archives.add(Archive(name))
        }
    }
}