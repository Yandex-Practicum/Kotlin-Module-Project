package service

import dataBase.repository.ArchiveRepository
import dataBase.repository.ArchiveRepositoryImpl
import dataBase.repository.NodeRepository
import dataBase.repository.NodeRepositoryImpl
import model.*

class HandlerServiceImpl: HandlerService {

    private var baseModelList: MutableList<BaseModel> = mutableListOf()
    private var archiveRepository: ArchiveRepository = ArchiveRepositoryImpl()
    private var nodeRepository: NodeRepository = NodeRepositoryImpl()
    private val outputService = OutputServiceImpl<BaseModel>()

    override fun consoleHandler() {
    baseModelList = archiveRepository.list().toMutableList()
    var isExit = false
    while (!isExit) {
        outputService.consoleOutput(baseModelList);
        when (val index = readlnOrNull()?.toIntOrNull()){
            0 -> println("Добавление")
            in 1..baseModelList.size -> println("Выбираем пункт")
            baseModelList.size+1 -> isExit = true
            null -> println("Ошибка. Повторите ввод")
        }
    }
//    println(baseModelList.size)
//    baseModelList = archiveRepository.save(Archive("TEMP")).toMutableList()
//    println(baseModelList.size)
//    baseModelList = nodeRepository.list().toMutableList()
//    println(baseModelList.size)
//
//    while (!isExit) {

//    }
//        var isExit = false
//        var items: List<BaseModel>
//        var currentArchive = null as Archive?;
//        items = getItems(currentArchive);
//        while (!isExit) {
//            outputService.consoleOutput(currentArchive, items);
//            when (val index = readlnOrNull()?.toIntOrNull()) {
//                0 -> addItem(currentArchive);
//                in 1..items.size -> {
//                    currentArchive = getCurrentArchive(currentArchive, index);
//                    items = getItems(currentArchive);
//                }
//                items.size+1 -> isExit = true
//                null -> println("Ошибка: повторите ввод")
//                else -> println("Неверный пункт, выберите от 0 до ${items.size + 1}")
//            }
//        }
    }

//    private fun addItem(currentArchive: Archive?) {
//        outputService.consoleCreateOutput(currentArchive);
//        val name = readlnOrNull();
//        if (validateName(name)){
//            if (currentArchive == null)
//                name?.let { Archive(it) }?.let { DataBaseSingleton.archives.add(it) };
//            else
//                name?.let { Node(it, currentArchive) }?.let { DataBaseSingleton.nodes.add(it) }
//        }
//
//    }
//
//    private fun validateName(name: String?):Boolean {
//        return if (name != null)
//            true;
//        else
//            false;
//    }
//
//    private fun getCurrentArchive(currentArchive: Archive?, index: Int?): Archive? {
//        if ((currentArchive == null) && (index != null)) {
//            return DataBaseSingleton.archives[index-1];
//        };
//        return null;
//    }
//
//    private fun getItems(currentArchive: Archive?): List<BaseModel> {
//        if (currentArchive == null)
//            return DataBaseSingleton.archives;
//        return DataBaseSingleton.nodes;
//    }
}