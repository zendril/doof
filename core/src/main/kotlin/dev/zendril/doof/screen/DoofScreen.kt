package dev.zendril.doof.screen

import com.badlogic.gdx.graphics.g2d.Batch
import dev.zendril.doof.Doof
import ktx.app.KtxScreen

abstract class DoofScreen(
    private val game: Doof,
    val batch: Batch = game.batch
) : KtxScreen