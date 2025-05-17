package service

import model.BaseModel

interface ValidationService<T:BaseModel> {
    fun validationModel(items:List<T>, name: String): Boolean
    fun validationModel(name: String): Boolean
}