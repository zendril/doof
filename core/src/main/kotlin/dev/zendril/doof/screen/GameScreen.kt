package dev.zendril.doof.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import dev.zendril.doof.Doof
import dev.zendril.doof.UNIT_SCALE
import dev.zendril.doof.ecs.component.GraphicComponent
import dev.zendril.doof.ecs.component.TransformComponent
import ktx.ashley.entity
import ktx.ashley.with
import ktx.log.logger

class GameScreen(game: Doof) : DoofScreen(game) {

    companion object {
        val log = logger<Doof>()
    }


    private val playerTexture = Texture(Gdx.files.internal("graphics/ship_base.png"))

    private val player = this.engine.entity {
        with<TransformComponent>() {
            position.set(1f, 1f, 0f)
        }
        with<GraphicComponent>() {
            sprite.texture = playerTexture
            sprite.run {
                setRegion(playerTexture)
                setSize(texture.width * UNIT_SCALE, texture.height * UNIT_SCALE)
                setOriginCenter()
            }
        }
    }

    override fun show() {
        log.debug { "Game Screen is shown" }
//        super.show()
    }

    override fun render(delta: Float) {
        engine.update(delta)
    }

    override fun dispose() {
        playerTexture.dispose()
//        super.dispose()
    }
}