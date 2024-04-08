import java.util.Scanner

class AppNavigation() {

    fun appNavi(
        scannerVar: Scanner,
        archiveListVar: MutableList<Archive>
    ) {
        var archiveList = archiveListVar
        var scanner: Scanner = scannerVar
        var mark: Boolean = true
        var mark2: Boolean = true
        var mark3: Boolean = true

        val archiveListOutput: (MutableList<Archive>) -> Unit = {
            if (it.isNotEmpty()) {
                for ((index, archive) in it.withIndex()) {
                    println("${index + 1} ${archive.titel}")
                }
            } else {
                println("Список пуст. Созданных архивов нет.")
            }
        }

        while (mark) {
            Menu.mainScreeenMenu()
            var choise = AppInput.integerInput(scanner, Menu.mainMenuList.size)
            when (choise) {
                1 -> {
                    mark2 = true
                    Menu.need_titel_Messega_for_user()
                    //     scanner = Scanner(System.`in`)
                    var name = AppInput.stringInput(scanner)
                    archiveList.add(Archive(name))
                    Menu.archiveIsReady_infoMessege(name)
                }

                2 -> {
                    mark2 = true
                    Menu.stringBeforArchiveList(archiveList.isNotEmpty())
                    archiveListOutput(archiveList)
                    println("\n")
                    Menu.allArchiveMenu(archiveList.isNotEmpty())
                    if (archiveList.isEmpty()) {
                        while (choise != 5_555_555_55) {
                            choise = AppInput.integerInput(scanner, 0)
                        }
                    } else {
                        choise = AppInput.integerInput(scanner, Menu.inArchiveListMap.size)
                    }
                    if (archiveList.size >= choise) {
                        Menu.stringNoteOpen(archiveList[choise - 1].titel)
                        while (mark2) {
                            Menu.newArchiveMenu()
                            Menu.inputActionNumber()
                            var choiseForNote =
                                AppInput.integerInput(scanner, Menu.archiveMenuMap.size)
                            when (choiseForNote) {
                                1 -> {
                                    Menu.inputNoteTitel()
                                    var name = AppInput.stringInput(scanner)
                                    Menu.inputNoteText()
                                    var str = AppInput.stringInput(scanner)
                                    archiveList[choise - 1].addMoreNote(name, str)
                                    println(archiveList[choise - 1].noteList.size)
                                }

                                2 -> {
                                    mark3 = true
                                    Menu.noteListInputForArchive(archiveList[choise - 1].titel)
                                    if (archiveList[choise - 1].noteList.size > 0) {
                                        archiveList[choise - 1].readNoteList()
                                        Menu.writeNoteNumForLook(archiveList[choise - 1].noteList.isNotEmpty())
                                        var noteChoise = AppInput.integerInput(
                                            scanner,
                                            archiveList[choise - 1].noteList.size
                                        )
                                        if (archiveList[choise - 1].noteList.size >= noteChoise) {
                                            Menu.noteName(archiveList[choise - 1].noteList[noteChoise - 1].titel)
                                            while (mark3) {
                                                Menu.noteMenu()
                                                Menu.inputActionNumber()
                                                var noteChangeNum = AppInput.integerInput(
                                                    scanner,
                                                    Menu.noteMenuMap.size
                                                )
                                                when (noteChangeNum) {
                                                    1 -> {
                                                        Menu.noteName(archiveList[choise - 1].noteList[noteChoise - 1].text)
                                                    }

                                                    2 -> {
                                                        Menu.strinAdditioanalInput()
                                                        var strForNote =
                                                            AppInput.stringInput(scanner)
                                                        archiveList[choise - 1].noteList[noteChoise - 1].continueNote(
                                                            strForNote
                                                        )
                                                    }

                                                    3 -> {
                                                        mark3 = false
                                                    }

                                                    5_555_555_55 -> {
                                                        mark3 = false
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        Menu.stringNoteNotHere()
                                    }
                                }

                                3 -> {
                                    mark2 = false
                                }
                            }
                        }
                    } else if (choise == 5_555_555_55) {
                        Menu.exitFromWhere()
                    } else {
                        Menu.stringArchiveNotExist()
                    }
                }

                3 -> {
                    Menu.exitFromWhere()
                    return
                }
            }
        }
    }
}




