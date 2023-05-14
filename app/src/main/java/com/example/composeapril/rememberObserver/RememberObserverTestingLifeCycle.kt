package com.example.composeapril.rememberObserver

import androidx.compose.runtime.RememberObserver

class RememberObserverTestingLifeCycle: RememberObserver {

    /**
     * Интерфейс RememberObserver имеет следующие методы:
     *
     * onRemembered - remember создал и запомнил объект.
     *
     * onForgotten - remember забыл объект
     *
     * onAbandoned - что-то в Compose пошло не так, значение будет забыто
     */

    init{
        println("@@@@ start init")
    }
    override fun onAbandoned() {
        println("@@@@ onAbandoned - что-то в Compose пошло не так, значение будет забыто")
    }

    override fun onForgotten() {
        println("@@@@ onForgotten - remember забыл объект")
    }

    override fun onRemembered() {
        println("@@@@ onRemembered - remember создал и запомнил объект.")
    }
}