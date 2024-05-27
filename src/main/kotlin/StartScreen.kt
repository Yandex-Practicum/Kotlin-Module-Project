enum class Screen{CHOOSE_ARCHIVE, CHOOSE_NOTE, EXIT}

fun startScreen (screen: Screen, param: Int){

        when (screen) {
            Screen.CHOOSE_ARCHIVE -> chooseArchive()
            Screen.CHOOSE_NOTE -> chooseNote(param)
            Screen.EXIT -> return
        }

}