enum class AllScreens {
    ARCH, CREATE_ARCH, OPEN_ARCH, CREATE_NOTE, OPEN_NOTE, VIEW_NOTE
}

class Navigator(
    val createArch: (Arch) -> Unit,
    val getArches: () -> List<Arch>
) {
    val screens = mutableListOf<Screen>()

    fun exit() {
        screens.removeLast()
        screens.lastOrNull()?.printContent()
    }

    fun nextScreen(screen: AllScreens, params: Any? = null) {
        val screenObject = when (screen) {
            AllScreens.ARCH -> StartScreen(::nextScreen, ::exit)
            AllScreens.CREATE_ARCH -> CreateArchScreen(
                createArch,
                ::nextScreen,
                ::exit
            )
            AllScreens.OPEN_ARCH -> OpenArchScreen(getArches(), ::nextScreen, ::exit)
            AllScreens.CREATE_NOTE -> {
                val param = (params as Arch)
                CreareNote(::nextScreen, ::exit, param)
            }
            AllScreens.OPEN_NOTE -> {
                val param = (params as Arch)
                OpenNote(::nextScreen, ::exit, param)
            }
            AllScreens.VIEW_NOTE -> {
                val param = (params as Note)
                ViewNote(::nextScreen, ::exit, param)
            }
        }
        screens.add(screenObject)
        screenObject.printContent()
    }
}