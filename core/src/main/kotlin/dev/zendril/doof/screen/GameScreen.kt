package dev.zendril.doof.screen

import com.badlogic.gdx.math.MathUtils
import dev.zendril.doof.Doof
import dev.zendril.doof.ecs.component.FacingComponent
import dev.zendril.doof.ecs.component.GraphicComponent
import dev.zendril.doof.ecs.component.PlayerComponent
import dev.zendril.doof.ecs.component.TransformComponent
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
            with<GraphicComponent>()
            with<PlayerComponent>()
            with<FacingComponent>()
        }

    }

    override fun render(delta: Float) {
        engine.update(delta)
    }

}