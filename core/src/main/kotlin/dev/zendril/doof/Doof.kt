package dev.zendril.doof

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.PooledEngine
import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.FitViewport
import dev.zendril.doof.ecs.system.RenderSystem
import dev.zendril.doof.screen.DoofScreen
import dev.zendril.doof.screen.GameScreen
import ktx.app.KtxGame
import ktx.log.logger

const val UNIT_SCALE = 1/16f

class Doof : KtxGame<DoofScreen>() {
    companion object {
        val log = logger<Doof>()
    }

    val gameViewport = FitViewport(9f, 16f)
    val batch: Batch by lazy { SpriteBatch() }
    val engine: Engine by lazy { PooledEngine().apply {
        addSystem(RenderSystem(batch, gameViewport))
    } }

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG
        log.debug { "create called" }
        addScreen(GameScreen(this))
        setScreen<GameScreen>()
    }

    override fun dispose() {
        super.dispose()
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