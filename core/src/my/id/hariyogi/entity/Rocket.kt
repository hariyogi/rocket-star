package my.id.hariyogi.entity

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input.Keys
import my.id.hariyogi.base.AnimationUtils
import my.id.hariyogi.base.BaseActor

class Rocket(x: Float, y: Float) : BaseActor(x, y) {

    init {
        val rocketPathFile = "ship.png"
        initTexture(AnimationUtils.loadSingleTexture(rocketPathFile))
    }

    override fun act(delta: Float) {
        super.act(delta)

        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            moveBy(-1f, 0f)
        }

        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            moveBy(1f, 0f)
        }

        if(Gdx.input.isKeyPressed(Keys.UP)) {
            moveBy(0f, 1f)
        }

        if(Gdx.input.isKeyPressed(Keys.DOWN)) {
            moveBy(0f, -1f)
        }
    }
}