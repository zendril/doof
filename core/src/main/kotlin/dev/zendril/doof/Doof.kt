package dev.zendril.doof

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import dev.zendril.doof.screen.FirstScreen
import dev.zendril.doof.screen.SecondScreen
import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.log.*

class Doof : KtxGame<KtxScreen>() {
    companion object {
        val log = logger<Doof>()
    }

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG
        log.debug { "create called" }
        addScreen(FirstScreen(this))
        addScreen(SecondScreen(this))
        setScreen<FirstScreen>()
    }

    override fun dispose() {
        log.debug { "dispose called" }
    }

    override fun pause() {
        log.debug { "paused" }
        super.pause()
    }

    override fun resume() {
        log.debug { "resumed" }
        super.resume()
    }
}