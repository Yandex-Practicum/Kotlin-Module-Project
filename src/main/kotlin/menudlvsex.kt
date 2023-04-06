class Logika {

    fun logika() {
        val menu = Menu()
        val app = AppArhiveNote()

        while (true) {
            val choice = menu.showMenuArhive()
            when (choice) {
                0 -> app.createArchive()
                1 -> {
                    if (app.showArchives() == null) {

                    } else {
                        val archive = app.selectArchive()
                        while (true) {
                            val noteChoice = menu.notesMenu()
                            when (noteChoice) {
                                0 -> app.createNoteInArchive(archive)
                                1 -> {
                                    if (app.selectNoteInArchive(archive) == null) {

                                    } else {
                                        val note = app.showNotesInArchive(archive)
                                        app.showNoteDetails(note)
                                    }
                                }
                                2 -> break
                                else -> menu.showError()
                            }

                        }
                    }
                }
                2 -> {
                    println("До свидания!")
                    return
                }
                else -> menu.showError()
            }
        }
    }
}