package objects

data class Archives(val name: String, val notes: MutableList<Notes> = mutableListOf())