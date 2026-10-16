data class Zametka(
    val title: String,
    val text: String
)

data class Archive(
    val name: String,
    val zametki: MutableList<Zametka> = mutableListOf()
)