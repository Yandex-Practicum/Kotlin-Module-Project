package dataBase.repository

import dataBase.DataBaseSingleton
import model.Archive
import model.Node

class NodeRepositoryImpl: AbstractCRUDRepository<Node>(DataBaseSingleton.nodes), NodeRepository {
    override fun findByArchive(archive: Archive): List<Node> {
        return DataBaseSingleton.nodes.filter { it.archives == archive }
    }

    override fun findByArchiveAndId(archive: Archive, id: Int): Node? {
        val nodeList = DataBaseSingleton.nodes
            .filter { it.archives == archive }
        return nodeList.getOrNull(id)
    }
}