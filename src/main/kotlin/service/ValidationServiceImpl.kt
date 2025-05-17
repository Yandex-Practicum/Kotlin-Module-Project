package service

import model.BaseModel

class ValidationServiceImpl<T:BaseModel> :ValidationService<T> {
    override fun validationModel(items: List<T>, name: String): Boolean {
        return !(!validationModel(name)||!findByName(items, name))
    }

    override fun validationModel(name: String): Boolean {
        if (name.isEmpty()) {
            println("Значение не может быть пустым")
            println("Повторите ввод")
            return false
        }
        return true
    }

    private fun findByName(items: List<T>, name: String): Boolean {
        if (items.find { it.name == name } != null) {
            println("Объект с таким именем уже существует")
            println("Повторите ввод")
            return false
        }
        return true
    }
}