import java.util.Scanner
import kotlin.system.exitProcess


abstract class Screen (var header:String="header", var text:String="content"){
    val menu:ArrayList<MenuItem> = arrayListOf(MenuItem("вернуться", {this.close()}))
    protected val scanner= Scanner(System.`in`)
    open fun show(){
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
    abstract fun close()

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
}

object MainScreen:Screen("Архивы", "Пока не созданы"){
    init {
        this.menu[0]=MenuItem("завершить программу",{this.close() })
        this.menu.add(MenuItem("cоздать архив",{createAnArchiveScreen.show()}))
    }
    private val createAnArchiveScreen:CreateAnArchiveScreen=CreateAnArchiveScreen()
    val chooseAnArchiveScreen:ChooseAnArchiveScreen=ChooseAnArchiveScreen()
    val viewAnArchiveScreen:ViewAnArchiveScreen=ViewAnArchiveScreen()
    val createANoteScreen:CreateANoteScreen=CreateANoteScreen()
    val viewANoteScreen:ViewANoteScreen=ViewANoteScreen()
    val chooseANoteScreen:ChooseANoteScreen=ChooseANoteScreen()
    var currentArchiveIndex=-1
    var currentNoteIndex=-1
    override fun show(){
        if (Vault.archives.isNotEmpty()){
            if (menu.size<3)this.menu.add(MenuItem("открыть архив",{chooseAnArchiveScreen.show()}))
            text=""
            Vault.archives.forEach { text+=it.name+'\n' }
        }
        super.show()
    }
    override fun close() {
        exitProcess(-1)
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

    override fun close() {
        MainScreen.show()
    }
}
class ChooseAnArchiveScreen:Screen( "Введите номер архива для просмотра","",){
    override fun show() {
        //super.fullfillMenuAndTextWithArrayItems(Vault.archives,this, MainScreen.viewAnArchiveScreen, this)
        this.menu.clear()
        this.menu.add(MenuItem("вернуться к основному экрану", {this.close() }))
        this.text = ""
        for (i in 0..Vault.archives.lastIndex) {
            this.text += "${i + 1}. ${Vault.archives[i].name}" + '\n'
            this.menu.add(MenuItem("окрыть \"${Vault.archives[i].name}\"", { MainScreen.viewAnArchiveScreen.getCurentItemIndex(MainScreen, index = i) }))
        }
        super.show()
    }

    override fun close() {
        MainScreen.show()
    }
}
class ViewAnArchiveScreen:Screen("Просмотр архива", ""),ListVeiwer{
    init {
        this.menu.add(MenuItem("cоздать заметку",{MainScreen.createANoteScreen.show()}))
    }
    override fun getCurentItemIndex(previousScreen: Screen, index: Int) {
        MainScreen.currentArchiveIndex=index
        this.show()
    }
    override fun show() {
        val indexX=MainScreen.currentArchiveIndex
        this.header="Архив \"${Vault.archives[indexX].name}\""
        if (Vault.archives[indexX].notes.isEmpty()){text="Заметок в архиве ещё нет"}
        else {
            this.text=""
            Vault.archives[indexX].notes.forEach { this.text+=it.name+'\n' }
            if (this.menu.size<3)this.menu.add(MenuItem("выбрать заметку",{MainScreen.chooseANoteScreen.show()}))
        }
        super.show()
    }
    override fun close(){
        MainScreen.chooseAnArchiveScreen.show()
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
                this.close()
            }
        }
    }
    override fun show() {
        val indexX=MainScreen.currentArchiveIndex
        val currentArchive=Vault.archives[indexX]
        this.header="Создаем заметку в архиве \"${currentArchive.name}\""
        // super.fullfillMenuAndTextWithArrayItems(currentArchive.notes,this, MainScreen.createANoteScreen)
        super.show()
    }

    override fun close() {
        MainScreen.viewAnArchiveScreen.show()
    }
}
class ViewANoteScreen:Screen("Просмотр архива", ""),ListVeiwer{
    init {
        this.menu.add(MenuItem("вернуться к экрану выбора заметок",{this.close()}))
    }
    override fun getCurentItemIndex(previousScreen: Screen, index: Int) {
        MainScreen.currentNoteIndex=index
        this.show()
    }
    override fun show() {
        val indexY=MainScreen.currentNoteIndex
        val currentNote=Vault.archives[MainScreen.currentArchiveIndex].notes[indexY]
        this.header="Заметка \"${currentNote.name}\""
        this.text=currentNote.text
        super.show()
    }

    override fun close() {
        MainScreen.chooseANoteScreen.show()
    }
}
class ChooseANoteScreen:Screen("Выбирите заметку для просмотра","Заметок в этом архиве пока нет"){
    override fun show() {
        this.menu.clear()
        this.menu.add(MenuItem("вернуться к просмотру архива \"${Vault.archives[MainScreen.currentArchiveIndex].name}\"", { this.close() }))
        this.text = ""
        for (i in 0..Vault.archives[MainScreen.currentArchiveIndex].notes.lastIndex) {
            this.text += "${i + 1}. ${Vault.archives[MainScreen.currentArchiveIndex].notes[i].name}" + '\n'
            this.menu.add(MenuItem("просмотреть \"${Vault.archives[MainScreen.currentArchiveIndex].notes[i].name}\"", {MainScreen.viewANoteScreen.getCurentItemIndex(MainScreen.chooseAnArchiveScreen, index = i) }))
        }
        super.show()
    }

    override fun close() {
        MainScreen.viewAnArchiveScreen.show()
    }
}
class MenuItem(var name:String="item",var onDo:() -> Unit={})
interface ListVeiwer{//One who show some items
fun getCurentItemIndex(previousScreen: Screen, index:Int=-1)
}
