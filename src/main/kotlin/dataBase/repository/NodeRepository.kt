package dataBase.repository

import model.Archive
import model.Node

interface NodeRepository:CRUDRepository<Node> {
    fun findByArchive(archive: Archive):List<Node>
    fun findByArchiveAndId(archive: Archive, id: Int): Node?
}