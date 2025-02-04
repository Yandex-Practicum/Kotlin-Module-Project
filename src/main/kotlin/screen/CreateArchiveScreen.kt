package screen

import data.Storage
import navigation.Navigator

class CreateArchiveScreen : Screen() {

    override fun showMenu() {
        printInfo("Введите название архива или 0 для возврата назад \n")
    }

    override fun nextStep() {
        while (true) {
            when (val step = Storage.sc.nextLine()) {
                "0" -> {
                    Navigator.pop()
                }

                else -> {

                    if (step.isEmpty()) {
                        printError("Название архива обязательно для заполнения\n")
                    } else {
                        Storage.createArchive(step)
                        Navigator.pop()
                    }
                }
            }
        }
    }
}