package dev.zendril.doof

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.PooledEngine
import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.utils.viewport.FitViewport
import dev.zendril.doof.ecs.system.*
import dev.zendril.doof.screen.DoofScreen
import dev.zendril.doof.screen.GameScreen
import ktx.app.KtxGame
import ktx.log.logger

const val UNIT_SCALE = 1/16f
const val V_WIDTH = 9
const val V_HEIGHT = 16

class Doof : KtxGame<DoofScreen>() {
    companion object {
        val log = logger<Doof>()
    }

//    private val defaultRegion by lazy { TextureRegion(Texture(Gdx.files.internal("graphics/ship_base.png"))) }
//    private val leftRegion by lazy { TextureRegion(Texture(Gdx.files.internal("graphics/ship_left.png"))) }
//    private val rightRegion by lazy { TextureRegion(Texture(Gdx.files.internal("graphics/ship_right.png"))) }
    val graphicsAtlas by lazy { TextureAtlas(Gdx.files.internal("graphics/graphics.atlas"))}

    val gameViewport = FitViewport(V_WIDTH.toFloat(), V_HEIGHT.toFloat())
    val batch: Batch by lazy { SpriteBatch() }
    val engine: Engine by lazy { PooledEngine().apply {
        addSystem(PlayerInputSystem(gameViewport))
        addSystem(MoveSystem())
        addSystem(
            PlayerAnimationSystem(
                graphicsAtlas.findRegion("ship_base"),
                graphicsAtlas.findRegion("ship_left"),
                graphicsAtlas.findRegion("ship_right")
            )
        )
        addSystem(RenderSystem(batch, gameViewport))
        addSystem(RemoveSystem())
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

        graphicsAtlas.dispose()
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