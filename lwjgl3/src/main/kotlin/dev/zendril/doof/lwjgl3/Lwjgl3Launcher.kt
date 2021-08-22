package dev.zendril.doof.lwjgl3

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import dev.zendril.doof.Doof

fun main() {
    Lwjgl3Application(Doof(), Lwjgl3ApplicationConfiguration().apply {
        setTitle("Doof")
        setWindowedMode(640, 480)
        setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png")
    })
}