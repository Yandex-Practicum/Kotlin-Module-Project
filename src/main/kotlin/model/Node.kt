package model

data class Node(override val name: String, val archives: Archive): BaseModel(name)
