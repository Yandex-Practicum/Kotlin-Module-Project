package service

import dataBase.repository.ArchiveRepository
import dataBase.repository.ArchiveRepositoryImpl
import dataBase.repository.NodeRepository
import dataBase.repository.NodeRepositoryImpl
import model.*

class HandlerServiceImpl: HandlerService {

    private var baseModelList: MutableList<BaseModel> = mutableListOf()
    private var archiveRepository: ArchiveRepository = ArchiveRepositoryImpl()
    private var currentItem: BaseModel? = null
    private var nodeRepository: NodeRepository = NodeRepositoryImpl()
    private val outputService = OutputServiceImpl<BaseModel>()
    private val validationService = ValidationServiceImpl<BaseModel>()

    override fun consoleHandler() {
        baseModelList = archiveRepository.list().toMutableList()
        var isExit = false
        while (!isExit) {
            outputService.consoleOutput(baseModelList, currentItem, false)
            when (val index = readlnOrNull()?.toIntOrNull()){
                0 -> saveBaseModel()
                in 1..baseModelList.size -> currentItem(index!!)
                baseModelList.size+1 -> isExit = quit()
                null -> println("Ошибка. Следует вводить только цифры")
                else -> println("Ошибка. Число за пределами допустимого диапазона. Допустимый диапазон от 0 до ${baseModelList.size+1} включительно")
            }
        }
    }

    private fun saveBaseModel(){
        outputService.consoleOutput(baseModelList, currentItem, true)
        var isValidation = false
        if (currentItem == null){
            while (!isValidation) {
                val name = readln()
                if (validationService.validationModel(baseModelList, name)) {
                    isValidation = true
                    baseModelList = archiveRepository.save(Archive(name)).toMutableList()
                }
            }
        } else {
            while (!isValidation) {
                val name = readln()
                if (validationService.validationModel(baseModelList, name)) {
                    outputService.consoleOutput(name)
                    var text: String
                    do {
                        text = readln()
                    } while (!validationService.validationModel(text))
                    baseModelList = nodeRepository.save(Node(name, text, currentItem as Archive)).toMutableList()
                    isValidation = true
                }
            }
        }
    }

    private fun currentItem(index: Int) {
        if (currentItem == null) {
            currentItem = archiveRepository.findById(index - 1)
            baseModelList = nodeRepository.findByArchive(currentItem as Archive).toMutableList()
        } else {
            outputService.consoleOutput(nodeRepository.findByArchiveAndId(currentItem as Archive, index - 1))
            var i = -1
            while (i!=0){
                i = readlnOrNull()?.toIntOrNull()!!
            }
        }
    }

    private fun quit(): Boolean {
        if (currentItem != null) {
            currentItem = null
            baseModelList = archiveRepository.list().toMutableList()
            return false
        }
        return true
    }
}