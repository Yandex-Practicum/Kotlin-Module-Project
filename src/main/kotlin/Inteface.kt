
interface GeneralScreen{
    fun <T> toGeneralScreen(obj : T){}
}
interface Input{
    fun <T> toInput(obj: T, MaxChoose: Int): Int
}

interface select{
    fun <T> toSelect(obj : T){}
}

interface readNote{
    fun <T> toReadNote(obj : T, actualArchive : Archive){}
}

interface createNew{
    fun <T> toCreateNew(obj : T){}
}
interface Go{
    fun <T> toGo(obj: T, number: Int) {
    }
}