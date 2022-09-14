package main.kotlin.application

import main.kotlin.application.ui.ArchiveScreen
import main.kotlin.framework.app.KApplication
import main.kotlin.framework.navigation.Navigation
import main.kotlin.framework.navigation.NavigationListener
import main.kotlin.framework.navigation.WidgetNavigation


class TodoApplication : KApplication {
    private val navigation: Navigation = WidgetNavigation()

    private val navigationListener = NavigationListener {
        destroy()
    }

    override fun start() {
        navigation.navigationListener = navigationListener
        navigation.navigate(ArchiveScreen(navigation))
    }

    override fun destroy() {
        navigation.navigationListener = null
        println("Finish work ---------------------")
    }
}