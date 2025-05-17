package model

data class Node(override val name: String, val text: String, val archives: Archive?): BaseModel(name)
