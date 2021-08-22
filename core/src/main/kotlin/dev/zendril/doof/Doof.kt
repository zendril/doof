package dev.zendril.doof

import com.badlogic.gdx.Game

/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms.  */
class Doof : Game() {
    override fun create() {
        setScreen(FirstScreen())
    }
}