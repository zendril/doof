package dev.zendril.doof.screen

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.MathUtils
import dev.zendril.doof.Doof
import dev.zendril.doof.ecs.component.*
import ktx.ashley.entity
import ktx.ashley.with
import ktx.log.logger

class GameScreen(game: Doof) : DoofScreen(game) {

    companion object {
        val log = logger<Doof>()
    }

    override fun show() {
        log.debug { "Game Screen is shown" }

        engine.entity {
            with<TransformComponent>() {
                position.set(MathUtils.random(0f, 9f), MathUtils.random(0f, 16f), 0f)
            }
            with<MoveComponent>()
            with<GraphicComponent>()
            with<PlayerComponent>()
            with<FacingComponent>()
        }
    }

    override fun render(delta: Float) {
//        (game.batch as SpriteBatch).renderCalls = 0
        engine.update(delta)
//        log.debug { "Rendercalls: ${(game.batch as SpriteBatch).renderCalls}" }
    }

}