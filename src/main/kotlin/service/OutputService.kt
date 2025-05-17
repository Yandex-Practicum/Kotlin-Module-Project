package service

import model.Archive
import model.BaseModel

interface OutputService<T:BaseModel> {
    fun consoleOutput(items: List<T>)
//    fun consoleCreateOutput(currentArchive: Archive?)
}