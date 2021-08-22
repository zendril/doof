package dev.zendril.doof.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.Screen
import dev.zendril.doof.Doof
import ktx.app.KtxScreen
import ktx.log.logger

class FirstScreen(game: Doof) : DoofScreen(game) {

    companion object {
        val log = logger<Doof>()
    }

    override fun show() {
        SecondScreen.log.debug { "First Screen is shown"}
        super.show()
    }

    override fun render(delta: Float) {
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
            game.setScreen<SecondScreen>()
        }
//        super.render(delta)
    }
}