
fun main() {
    //структура хранения архивов типа List
    val userArchive = mutableListOf<UserArchives>()

    //for tests
/*    val zamArch1 = mutableListOf<UserNotes>()
    zamArch1.add(UserNotes("arch1_zam1","text11"))
    zamArch1.add(UserNotes("arch1_zam2","text12"))
    zamArch1.add(UserNotes("arch1_zam3","text13"))
    val zamArch2 = mutableListOf<UserNotes>()
    zamArch2.add(UserNotes("arch2_zam1","text21"))
    zamArch2.add(UserNotes("arch2_zam2","text22"))
    zamArch2.add(UserNotes("arch2_zam3","text23"))
    val zamArch3 = mutableListOf<UserNotes>()
    zamArch3.add(UserNotes("arch3_zam1","text31"))
    zamArch3.add(UserNotes("arch3_zam2","text32"))
    zamArch3.add(UserNotes("arch3_zam3","text33"))
    val zamArch4 = mutableListOf<UserNotes>()
    zamArch4.add(UserNotes("arch4_zam1","text41"))
    zamArch4.add(UserNotes("arch4_zam2","text42"))
    zamArch4.add(UserNotes("arch4_zam3","text43"))
    zamArch4.add(UserNotes("arch5_zam1","text51"))
    zamArch4.add(UserNotes("arch5_zam2","text52"))
    zamArch4.add(UserNotes("arch6_zam3","text53"))

    userArchive.add( UserArchives("111", zamArch1))
    userArchive.add( UserArchives("222", zamArch2))
    userArchive.add( UserArchives("333", zamArch3))
    userArchive.add( UserArchives("444", zamArch4))*/

    //заголовок
    NoteTools.printContext(TitleTypes.HEAD)
    //переход в меню "Архивы" и переходим по: Архивы <-> Заметки
    while (true) {
        WorkArchives( userArchive ).onCreate()
    }
}

//структура хранения архивов: list(archiveName, list(noteName, noteText))
data class UserArchives(val archiveName: String, val notesList: MutableList<UserNotes>)
//структура хранения заметок: list(noteName, noteText)
data class UserNotes(val noteName : String, val noteText : String)

