package dataBase.repository

import model.BaseModel

abstract class AbstractCRUDRepository<T: BaseModel>(private val baseModelList: MutableList<T>): CRUDRepository<T> {

    override fun list(): List<T> {
        return baseModelList.toList()
    }

    override fun findById(index: Int): T {
        if (index in baseModelList.indices) {
            return baseModelList[index]
        } else {
            throw NoSuchElementException("Ошибка: Индекс за пределами массива")
        }
    }
    override fun save(model: T):List<T> {
        baseModelList.add(model)
        return baseModelList
    }
}