package dev.zendril.doof.ecs.component

import com.badlogic.ashley.core.Component
import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.gdx.utils.Pool
import ktx.ashley.mapperFor
import java.util.*

class FacingComponent : Component, Pool.Poolable {

    lateinit var direction: FacingDirection

    init {
        reset()
    }

    override fun reset() {
        direction = FacingDirection.DEFAULT
    }

    companion object {
        val mapper = mapperFor<FacingComponent>()
    }

}

enum class FacingDirection {
    LEFT, DEFAULT, RIGHT
}