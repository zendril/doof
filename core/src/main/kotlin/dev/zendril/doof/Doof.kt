package dev.zendril.doof

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import dev.zendril.doof.screen.DoofScreen
import dev.zendril.doof.screen.GameScreen
import ktx.app.KtxGame
import ktx.log.logger

const val UNIT_SCALE = 1/16f

class Doof : KtxGame<DoofScreen>() {
    companion object {
        val log = logger<Doof>()
    }

    val batch: Batch by lazy { SpriteBatch() }

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG
        log.debug { "create called" }
        addScreen(GameScreen(this))
        setScreen<GameScreen>()
    }

    override fun dispose() {
        log.debug { "dispose called" }
        log.debug { "Sprites in batch: ${(batch as SpriteBatch).maxSpritesInBatch}"}
        batch.dispose()
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