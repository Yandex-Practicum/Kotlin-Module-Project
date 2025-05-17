package dataBase.repository

import model.BaseModel

interface CRUDRepository<T:BaseModel> {
    fun list(): List<T>
    fun findById(index: Int): T
    fun save(model: T): List<T>
}