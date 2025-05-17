package service
//
//import model.Archive
import model.Archive
import model.BaseModel
//import model.CurrentModel
//
class OutputServiceImpl<T : BaseModel>: OutputService<T> {
    override fun consoleOutput(baseModelList: List<T>) {
        var index = 0;
        println("Выберите пункт меню:");
        println("$index. Создать ${convertTypeToString(baseModelList)}")
        index++
        for (baseModel in baseModelList) {
            println("$index. ${baseModel.name}")
            index++;
        }
        println("$index. Выход")
    }

    private fun convertTypeToString(baseModelList: List<T>): String{
        return if (baseModelList.isEmpty()||baseModelList[0] is Archive)
            "Архив"
        else "Заметка"
    }
}
//
//    override fun consoleCreateOutput(currentArchive: Archive?) {
//        println("Создание ${getFirstString(currentArchive)}:");
//        println("Введите название ${getFirstString(currentArchive)}:");
//    }
//
//    private fun getFirstString(currentArchive: Archive?): String{
//        return if (currentArchive == null)
//            "архив";
//        else
//            "замет";
//    }
//}