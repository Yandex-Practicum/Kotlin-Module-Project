package ui.console.screens

import bl.Note
import ui.console.Dialog
import ui.console.actions.CommonAction
import ui.console.nextLineNotEmpty
import java.util.Scanner

sealed class  Screens {
    class Archives(override val onMoveNext: () -> Unit,
                   override val onExit: () -> Unit): CommonScreen("Архивы"){

        init{
            val initialDialog = Dialog(mapOf(
                0 to CommonAction("Создать архив", ::createArchiveHandler),
                1 to CommonAction("Это мой уже созданный архив", ::openArchiveHandler),
                2 to CommonAction("Выход", onExit)))
            dialogsStack.push(initialDialog)
        }

        private fun createArchiveHandler(){
            println("Введите название архива")
            val archiveName = Scanner(System.`in`)
                .nextLineNotEmpty("Название архива не может быть пустым")
            val archive = archiveService.Create(archiveName)
            archiveService.Add(archive)
            println("Архив $archiveName создан")
        }

        private fun openArchiveHandler(){
            val actions = mutableMapOf<Int, CommonAction>()
            val action: (idx: Int) -> Unit = {
                selectedArchiveId = it
                onMoveNext()
            }
            if(archiveService.List().isEmpty()){
                println("\t[Архивы отсутствуют]")
            }
            archiveService.List().forEachIndexed{ idx, archive ->
                actions[idx] = CommonAction(archive.title) { action(idx) }
                if(dialogsStack.isNotEmpty()){
                    dialogsStack.push(Dialog(actions))
                    dialogsStack.push(dialog)
                }else{
                    dialogsStack.push(dialog)
                    dialogsStack.push(Dialog(actions))
                }
            }
        }
    }
    class Archive(override val onMoveNext: () -> Unit,
                  override val onExit: () -> Unit): CommonScreen("Открыть архив"){
        init{
            val initialDialog = Dialog(mapOf(
                0 to CommonAction("Создать заметку", ::createNoteHandler),
                1 to CommonAction("Выбрать заметку", ::selectNoteHandler),
                2 to CommonAction("Выход", onExit)))
            dialogsStack.push(initialDialog)
        }

        private fun createNoteHandler(){
            val archive = archiveService.List()[selectedArchiveId]
            println("Введите текст заметки")
            val noteText = Scanner(System.`in`)
                .nextLineNotEmpty("Название заметки не может быть пустым")
            val note = Note(noteText)
            archiveService.AddNote(archive, note)
        }

        private fun selectNoteHandler(){
            val archive = archiveService.List()[selectedArchiveId]
            archive.notes.forEachIndexed { idx, note -> println("$idx. ${note.text}") }
            println("Введите номер заметки")
            val noteId = Scanner(System.`in`).nextInt()
            selectedNoteId = noteId
            onMoveNext()
        }
    }

    class OpenNote(override val onMoveNext: () -> Unit, override val onExit: () -> Unit): CommonScreen("Открыть заметку") {
        init{
            val initialDialog = Dialog(mapOf(0 to CommonAction("Выход", onExit)))
            dialogsStack.push(initialDialog)
        }
        override fun show() {
            val archive = archiveService.List()[selectedArchiveId]
            val note = archive.notes[selectedNoteId]
            println("Заметка")
            println(note.text)
            super.show()
        }
    }

    companion object{
        private var selectedArchiveId: Int = -1
        private var selectedNoteId: Int = -1
    }
}

