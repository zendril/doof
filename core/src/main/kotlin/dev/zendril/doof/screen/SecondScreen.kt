package dev.zendril.doof.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import dev.zendril.doof.Doof
import ktx.app.KtxScreen
import ktx.log.logger

class SecondScreen(game: Doof) : DoofScreen(game) {
    companion object {
        val log = logger<Doof>()
    }

    override fun show() {
        log.debug { "Second Screen is shown"}
//        super.show()
    }
    override fun render(delta: Float) {
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
            game.setScreen<FirstScreen>()
        }
//        super.render(delta)
    }

}