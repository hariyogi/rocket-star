package my.id.hariyogi.entity

import my.id.hariyogi.base.AnimationUtils
import my.id.hariyogi.base.BaseActor

class Meteor(x: Float, y: Float): BaseActor(x, y) {

    init {
        val texturePath = "meteor.png"
        initTexture(AnimationUtils.loadSingleTexture(texturePath))
    }
}