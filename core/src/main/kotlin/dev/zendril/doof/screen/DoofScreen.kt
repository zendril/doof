package dev.zendril.doof.screen

import com.badlogic.ashley.core.Engine
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.utils.viewport.Viewport
import dev.zendril.doof.Doof
import ktx.app.KtxScreen

abstract class DoofScreen(
//    private val game: Doof,
    val game: Doof,
    val batch: Batch = game.batch,
    val gameViewPort: Viewport = game.gameViewport,
    val engine: Engine = game.engine
) : KtxScreen {
    override fun resize(width: Int, height: Int) {
        gameViewPort.update(width, height, true)
//        super.resize(width, height)
    }
}