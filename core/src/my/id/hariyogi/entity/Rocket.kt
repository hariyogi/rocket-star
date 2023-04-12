package my.id.hariyogi.entity

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Vector2
import my.id.hariyogi.base.AnimationUtils
import my.id.hariyogi.base.BaseActor
import my.id.hariyogi.base.Velocity

class Rocket(x: Float, y: Float) : BaseActor(x, y) {

    val velocity: Velocity = Velocity(100f, 100f, 400f)

    init {
        val rocketPathFile = "ship.png"
        initTexture(AnimationUtils.loadSingleTexture(rocketPathFile))
        setSizeAndOrigin(60f, 60f)
    }

    override fun act(delta: Float) {
        super.act(delta)

        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            velocity.accelerateAtAngle(180f)
        }

        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            velocity.accelerateAtAngle(0f)
        }

        if(Gdx.input.isKeyPressed(Keys.UP)) {
            velocity.accelerateAtAngle(90f)
        }

        if(Gdx.input.isKeyPressed(Keys.DOWN)) {
            velocity.accelerateAtAngle(270f)
        }

        velocity.applyPhysics(delta)
        moveBy(velocity.velocityVec.x * delta, velocity.velocityVec.y * delta)

        animationPaused = !velocity.isMoving

        if(velocity.speed > 0) {
            rotation = velocity.motionAngle
        }
    }

}