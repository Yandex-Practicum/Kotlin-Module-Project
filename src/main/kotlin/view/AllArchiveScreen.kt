package view

import presenter.Presenter

private const val SCREEN_1_TITLE = "Screen #1______основное меню_______"
private const val CREATION_COMMAND = "+"
private const val EXIT_COMMAND = "0"
private const val EXIT = "$EXIT_COMMAND - выход"
private const val CREATE_ARCHIVE = "$CREATION_COMMAND - создать архив"
private const val CHOOSE_ARCHIVE = "выберите архив по номеру:"
private const val NOT_CORRECT_INPUT = "некорректное значение"
private const val THERE_IS_NO_VALUE = "нет такого значения"


class AllArchiveScreen(presenter: Presenter, function: () -> (Unit)) : Screen(presenter, function) {
    override fun show() {
        println(SCREEN_1_TITLE)
        println(CREATE_ARCHIVE)
        println(EXIT)
        println(CHOOSE_ARCHIVE)
        presenter.showAllArchives()
        println("_______________")
        while (true) {
            when (val command = scanner.nextLine()) {
                EXIT_COMMAND -> {
                    onBackPressed.invoke()
                }
                CREATION_COMMAND -> {
                    ArchiveCreationScreen(presenter, ::show).show()
                }
                else -> {
                    try {
                        val archive = presenter.chooseArchive(command.toInt())
                        NoteListScreen(archive, presenter, ::show).show()
                    } catch (e: NumberFormatException) {
                        println(NOT_CORRECT_INPUT)
                    } catch (e: IndexOutOfBoundsException) {
                        println(THERE_IS_NO_VALUE)
                    }
                }
            }
        }
    }
}