package dev.zendril.doof.ecs.component

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.utils.Pool
import ktx.ashley.mapperFor
import kotlin.properties.Delegates

const val MAX_LIFE = 100f
const val MAX_SHIELD = 100f

class PlayerComponent: Component, Pool.Poolable {

    var life by Delegates.notNull<Float>()
    var maxLife by Delegates.notNull<Float>()
    var shield by Delegates.notNull<Float>()
    var maxShield by Delegates.notNull<Float>()
    var distance by Delegates.notNull<Float>()

    init {
        reset()
    }

    override fun reset() {
        life = MAX_LIFE
        maxLife = MAX_LIFE
        shield = 0f
        maxShield = MAX_SHIELD
        distance = 0f
    }

    companion object {
        val mapper = mapperFor<PlayerComponent>()
    }
}