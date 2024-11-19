
package com.lesa

import com.lesa.model.Archive
import com.lesa.model.Note
import java.util.*

class InputManager(private val menuManager: MenuManager) {
    fun readIntInput(): Int {
        print(WRITE_NUMBER)
        val input = readln().toIntOrNull()
        return if (input != null) input else {
            println(WRONG_INT_INPUT)
            readIntInput()
        }
    }

    fun navigateBack() {
        menuManager.navigateBack()
    }

    fun navigateTo(screen: MenuManager.Screen) {
        menuManager.navigateTo(screen)
    }
}