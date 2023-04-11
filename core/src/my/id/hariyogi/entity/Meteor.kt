package my.id.hariyogi.entity

import com.badlogic.gdx.scenes.scene2d.Action
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import my.id.hariyogi.base.AnimationUtils
import my.id.hariyogi.base.BaseActor

class Meteor(x: Float, y: Float): BaseActor(x, y) {

    init {
        val texturePath = "meteor.png"
        initTexture(AnimationUtils.loadSingleTexture(texturePath))

        setSizeAndOrigin(60f, 60f)

        val action = Actions.rotateBy(30f, 1f)
        addAction(Actions.forever(action))
    }
}