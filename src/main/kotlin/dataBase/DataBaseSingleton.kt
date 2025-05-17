package dataBase

import model.Archive
import model.Node

internal object DataBaseSingleton {
    var archives = mutableListOf<Archive>()
    var nodes = mutableListOf<Node>()
}