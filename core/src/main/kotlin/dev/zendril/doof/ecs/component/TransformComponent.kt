package dev.zendril.doof.ecs.component

import com.badlogic.ashley.core.Component
import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.math.Vector3
import com.badlogic.gdx.utils.Pool
import ktx.ashley.get
import ktx.ashley.mapperFor

class TransformComponent : Component, Pool.Poolable, Comparable<TransformComponent> {
    val position = Vector3()
    val size = Vector2()
    var rotationDeg = 0f

    init {
        reset()
    }

    override fun reset() {
        position.set(Vector3.Zero)
        size.set(1f, 1f)
        rotationDeg = 0f
    }

    override fun compareTo(other: TransformComponent): Int {
        val zDiff = other.position.z.compareTo(position.z)
        return if (zDiff == 0) other.position.y.compareTo(position.y) else zDiff
    }

    companion object {
        val mapper: ComponentMapper<TransformComponent> = mapperFor<TransformComponent>()
    }
}