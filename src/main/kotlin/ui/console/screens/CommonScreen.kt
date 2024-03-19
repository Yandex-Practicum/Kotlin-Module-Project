package ui.console.screens

import bl.ArchiveService
import bl.IArchives
import ui.console.Dialog
import ui.IScreen
import ui.console.exceptions.CommandNotFoundException
import java.util.Stack

@Suppress("NAME_SHADOWING")
abstract class CommonScreen(override val title: String) : IScreen {
    protected val archiveService: IArchives = ArchiveService

    var dialog: Dialog = Dialog(emptyMap())
    val dialogsStack: Stack<Dialog> = Stack()
    override fun show() {
        println(title)
        println()
        if(dialogsStack.isNotEmpty()){
            dialog = dialogsStack.pop()
        }
        dialog.showDialog()
    }

     override fun readCommand(command: () -> Int){
        val command = command()
        if(dialog.actions.containsKey(command)){
            commandHandler(command)
        } else {
            throw CommandNotFoundException(command)
        }
    }
    override fun commandHandler(command: Int){
        if(dialog.actions.containsKey(command)){
            dialog.actions[command]!!.action()
        } else {
            throw CommandNotFoundException(command)
        }
    }
}