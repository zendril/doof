package dev.zendril.doof.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.utils.viewport.FitViewport
import dev.zendril.doof.Doof
import dev.zendril.doof.UNIT_SCALE
import ktx.graphics.use
import ktx.log.logger

class GameScreen(game: Doof) : DoofScreen(game) {

    companion object {
        val log = logger<Doof>()
    }

    private val viewport = FitViewport(9f, 16f)
    private val texture = Texture(Gdx.files.internal("graphics/ship_base.png"))
    private val sprite = Sprite(texture).apply {
        setSize(1f, 1f)
    }

    override fun show() {
        log.debug { "Game Screen is shown" }
        sprite.setPosition(1f, 1f)
//        super.show()
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height, true)
//        super.resize(width, height)
    }

    override fun render(delta: Float) {
//        batch.begin()
//        batch.projectionMatrix = viewport.camera.combined
//        sprite.draw(batch)
//        batch.end()
        viewport.apply()
        batch.use(viewport.camera.combined) {
            sprite.draw(it)
        }
//        super.render(delta)
    }

    override fun dispose() {
        texture.dispose()
//        super.dispose()
    }
}