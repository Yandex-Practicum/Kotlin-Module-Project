import java.util.Scanner
import kotlin.system.exitProcess


abstract class Screen (var header:String="header", var text:String="content"){
    val menu:ArrayList<MenuItem> = arrayListOf(MenuItem("выйти", {this.close()}))
    protected val scanner= Scanner(System.`in`)
    var previousScreen:Screen=this
    open fun show(previousScreen:Screen=this){
        this.previousScreen=previousScreen
        println(header)
        println("===========================")
        println(text)
        println("___________________________")
        printMenu()
        println()
        getCommand()
    }

    protected open fun getCommand(){
        while (true){
            if(!scanner.hasNextInt()){
                println("Пожалуйста, введите желаемый пункт меню:")
                scanner.next()
                printMenu()
            }else{
                val command=scanner.nextInt()
                if(command<=menu.lastIndex)menu[command].onDo()
                else {
                    println("В меню такого пункта нет. Пожалуйста, введите номер пункта меню:")
                    printMenu()
                }
            }
        }
    }
    private fun printMenu(){
        for (i in 0..menu.lastIndex){
            print("Чтобы ${menu[i].name} введите <$i>. ")
        }
    }

    open protected fun close(){
        previousScreen.show(this)
    }
    protected fun <T:Menuable>fullfillMenuAndTextWithArrayItems(items:ArrayList<T>,sender:Screen,screenToGoForward:ListVeiwer,screenToGoBack:Screen) {//receiver for screen to go if you need it inside menu
        if (items.isNotEmpty()) {
            with(sender) {
                this.text = ""
                if (this.menu.size > 1) {
                    this.menu.clear()
                    this.menu.add(MenuItem("вернуться назад", { this.close() }))
                }
                for (i in 0..items.lastIndex) {
                    this.text += "${i + 1}. ${items[i].name}" + '\n'
                    this.menu.add(MenuItem("окрыть \"${items[i].name}\"", { screenToGoForward.getCurentItemIndex(screenToGoBack, i) }))
                }
            }
        }
    }
    override fun equals(other: Any?): Boolean {
        return this.toString()==other.toString()
    }

    override fun toString(): String {
        return "screen: "+this.header+this.text
    }
}

object MainScreen:Screen("Архивы", "Пока не созданы"){
    init {
        this.menu[0].onDo={ exitProcess(-1) }
        this.menu.add(MenuItem("cоздать архив",{createAnArchiveScreen.show(this)}))
    }
    val archivesMenu:ArrayList<MenuItem> = arrayListOf()
    private val createAnArchiveScreen:CreateAnArchiveScreen=CreateAnArchiveScreen()
    val chooseAnArchiveScreen:ChooseAnArchiveScreen=ChooseAnArchiveScreen()
    val viewAnArchiveScreen:ViewAnArchiveScreen=ViewAnArchiveScreen()
    val createANoteScreen:CreateANoteScreen=CreateANoteScreen()
    val viewANoteScreen:ViewANoteScreen=ViewANoteScreen()
    val chooseANoteScreen:ChooseANoteScreen=ChooseANoteScreen()
    var currentArchiveIndex=-1
    var currentNoteIndex=-1
    override fun show(previousScreen: Screen){
        this.previousScreen=previousScreen
        if (Vault.archives.isNotEmpty()){
            if (menu.size<3)this.menu.add(MenuItem("открыть архив",{chooseAnArchiveScreen.show(this)}))
            text=""
            Vault.archives.forEach { text+=it.name+'\n' }
        }
        super.show(previousScreen)
    }
}
class CreateAnArchiveScreen:Screen("Создание архива",""){
    init {
        this.text="Чтобы создать архив введите название для него."
    }

    override fun getCommand() {
        while(scanner.hasNext()){
            if(scanner.hasNextInt())super.getCommand()
            else {
                val command: String = scanner.nextLine()
                Vault.archives.add(Archive(command))
                println("Архив $command создан")
                this.close()
            }
        }
    }
}
class ChooseAnArchiveScreen:Screen( "Введите номер архива для просмотра","",){

    override fun show(previousScreen: Screen) {
        this.previousScreen=previousScreen
        //super.fullfillMenuAndTextWithArrayItems(Vault.archives,this, MainScreen.viewAnArchiveScreen, this)
        this.menu.clear()
        this.menu.add(MenuItem("вернуться назад", { super.close() }))
        this.text = ""
        for (i in 0..Vault.archives.lastIndex) {
            this.text += "${i + 1}. ${Vault.archives[i].name}" + '\n'
            this.menu.add(MenuItem("окрыть \"${Vault.archives[i].name}\"", { MainScreen.viewAnArchiveScreen.getCurentItemIndex(MainScreen, index = i) }))
        }
        super.show(previousScreen)
    }
}
class ViewAnArchiveScreen:Screen("Просмотр архива", ""),ListVeiwer{
    init {
        this.menu.add(MenuItem("cоздать заметку",{MainScreen.createANoteScreen.show(this)}))
    }
    override fun getCurentItemIndex(previousScreen: Screen, index: Int) {
        MainScreen.currentArchiveIndex=index
        this.show(MainScreen)
    }
    override fun show(previousScreen: Screen) {//indexY здесь для совместимости с интерфейсом
        val indexX=MainScreen.currentArchiveIndex
        this.header="Архив \"${Vault.archives[indexX].name}\""
        if (Vault.archives[indexX].notes.isEmpty()){text="Заметок в архиве ещё нет"}
        else {
             this.text=""
            Vault.archives[indexX].notes.forEach { this.text+=it.name+'\n' }
            if (this.menu.size<3)this.menu.add(MenuItem("выбрать заметку",{MainScreen.chooseANoteScreen.show(this)}))
        }
        super.show(MainScreen)
    }
    override fun close(){
        this.show(MainScreen)
    }
}
class CreateANoteScreen():Screen("Создание заметки","Чтобы создать заметку введите название для неё."){
    override fun getCommand() {
        while(scanner.hasNext()){
            if(scanner.hasNextInt())super.getCommand()
            else {
                val name: String = scanner.nextLine()
                println("Пожалуйста, введите текст заметки")
                val text:String=scanner.nextLine()
                Vault.archives[MainScreen.currentArchiveIndex].notes.add(Note(name,text))
                println("Заметка ${Vault.archives[MainScreen.currentArchiveIndex].notes.last().name } создана")
                //передать в окно просмотра со ссылкой на view
                this.close()
            }
        }
    }
    override fun show(previousScreen: Screen) {
        val indexX=MainScreen.currentArchiveIndex
        val currentArchive=Vault.archives[indexX]
        this.header="Создаем заметку в архиве \"${currentArchive.name}\""
        // super.fullfillMenuAndTextWithArrayItems(currentArchive.notes,this, MainScreen.createANoteScreen)
        super.show(previousScreen)
    }
}
class ViewANoteScreen:Screen("Просмотр архива", ""),ListVeiwer{
    override fun getCurentItemIndex(previousScreen: Screen, index: Int) {
        MainScreen.currentNoteIndex=index
        this.show(previousScreen)
    }
    override fun show(previousScreen: Screen) {
        val indexY=MainScreen.currentNoteIndex
        val currentNote=Vault.archives[MainScreen.currentArchiveIndex].notes[indexY]
        this.header="Заметка \"${currentNote.name}\""
        this.text=currentNote.text
        super.show(previousScreen)
    }
}
class ChooseANoteScreen:Screen("Выбирите заметку для просмотра","Заметок в этом архиве пока нет"){
        override fun show(previousScreen: Screen) {
        this.previousScreen=previousScreen
        this.menu.clear()
        this.menu.add(MenuItem("вернуться назад", { super.close() }))
        this.text = ""
        for (i in 0..Vault.archives[MainScreen.currentArchiveIndex].notes.lastIndex) {
            this.text += "${i + 1}. ${Vault.archives[MainScreen.currentArchiveIndex].notes[i].name}" + '\n'
            this.menu.add(MenuItem("просмотреть \"${Vault.archives[MainScreen.currentArchiveIndex].notes[i].name}\"", {MainScreen.viewANoteScreen.getCurentItemIndex(MainScreen.chooseAnArchiveScreen, index = i) }))
        }
        super.show(previousScreen)

    }
}
class MenuItem(var name:String="item",var onDo:() -> Unit={})
interface ListVeiwer{//One who show some items
abstract fun getCurentItemIndex(previousScreen: Screen, index:Int=-1)
}
