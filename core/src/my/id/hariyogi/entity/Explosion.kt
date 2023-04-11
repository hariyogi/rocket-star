package my.id.hariyogi.entity

import my.id.hariyogi.base.AnimationUtils
import my.id.hariyogi.base.BaseActor

class Explosion(x: Float, y: Float): BaseActor(x, y) {

    init {
        val texturePacks = arrayOf("explosion_1.png", "explosion_2.png")
        initTexture(AnimationUtils.loadFromFiles(texturePacks, 0.1f, false))
        setSizeAndOrigin(30f, 30f)
    }
}