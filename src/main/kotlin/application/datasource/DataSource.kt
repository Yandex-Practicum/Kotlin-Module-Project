package main.kotlin.application.datasource

import main.kotlin.application.model.Archive
import main.kotlin.application.model.Note
import java.util.*

interface DataSource<T, E> {
    fun put(model: T)
    fun get(id: E): T?
    fun remove(model: T? = null, id: E? = null)
}

object NoteDataSource : DataSource<Note, UUID> {
    private val cachedModel = mutableMapOf<UUID, Note>()

    override fun put(model: Note) {
        cachedModel[model.id] = model
    }

    override fun get(id: UUID): Note? {
        if (!cachedModel.contains(id)) return null
        return cachedModel[id]
    }

    override fun remove(model: Note?, id: UUID?) {
        id?.let {
            if (cachedModel.contains(it)) {
                cachedModel.remove(it)
            }
        }
        model?.let {
            if (cachedModel.contains(it.id)) {
                cachedModel.remove(id)
            }
        }
    }
}

object ArchiveDataSource : DataSource<Archive, UUID> {
    private val cachedModel = mutableMapOf<UUID, Archive>()

    override fun put(model: Archive) {
        cachedModel[model.id] = model
    }

    override fun get(id: UUID): Archive? {
        if (!cachedModel.contains(id)) return null
        return cachedModel[id]
    }

    override fun remove(model: Archive?, id: UUID?) {
        id?.let {
            if (cachedModel.contains(it)) {
                cachedModel.remove(it)
            }
        }
        model?.let {
            if (cachedModel.contains(it.id)) {
                cachedModel.remove(id)
            }
        }
    }

    fun getAll(): List<Archive> {
        if (cachedModel.isEmpty()) return emptyList()
        return cachedModel.map { it.value }
    }
}