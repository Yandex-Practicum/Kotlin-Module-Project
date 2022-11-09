package screens.interfaces

import screenLogic.EntityScreenLogic

interface EntityScreen: Screen {
    val entityScreenLogic: EntityScreenLogic
}