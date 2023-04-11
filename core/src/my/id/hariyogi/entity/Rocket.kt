package my.id.hariyogi.entity

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Vector2
import my.id.hariyogi.base.AnimationUtils
import my.id.hariyogi.base.BaseActor

class Rocket(x: Float, y: Float) : BaseActor(x, y) {

    var velocityVec = Vector2(0f, 0f)

    var accelerationVec = Vector2(0f, 0f)
    var acceleration = 400f

    var maxSpeed = 100f
    var deceleration = 400f

    init {
        val rocketPathFile = "ship.png"
        initTexture(AnimationUtils.loadSingleTexture(rocketPathFile))
        setSizeAndOrigin(60f, 60f)
    }

    override fun act(delta: Float) {
        super.act(delta)

        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            accelerateAtAngle(180f)
        }

        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            accelerateAtAngle(0f)
        }

        if(Gdx.input.isKeyPressed(Keys.UP)) {
            accelerateAtAngle(90f)
        }

        if(Gdx.input.isKeyPressed(Keys.DOWN)) {
            accelerateAtAngle(270f)
        }

        applyPhysics(delta)

        animationPaused = !isMoving()

        if(getSpeed() > 0) {
            rotation = getMotionAngle()
        }
    }

    fun setSpeed(speed: Float) {
        if(velocityVec.len() == 0f) {
            velocityVec.set(speed, 0f)
        }else {
            velocityVec.setLength(speed)
        }
    }

    fun getSpeed() = velocityVec.len()
    fun setMotionAngle(angle: Float) {
        velocityVec.setAngleDeg(angle)
    }

    fun getMotionAngle() = velocityVec.angleDeg()
    fun isMoving() = getSpeed() > 0

    fun accelerateAtAngle(angle: Float) {
        accelerationVec.add(Vector2(acceleration, 0f).setAngleDeg(angle))
    }

    fun accelerationForward() {
        accelerateAtAngle(rotation)
    }

    fun applyPhysics(dt: Float) {
        velocityVec.add(accelerationVec.x * dt, accelerationVec.y * dt)
        var speed = getSpeed()

        if(accelerationVec.len() == 0f) {
            speed -= deceleration * dt
        }

        speed = MathUtils.clamp(speed, 0f, maxSpeed)

        setSpeed(speed)

        moveBy(velocityVec.x * dt, velocityVec.y * dt)

        accelerationVec.set(0f, 0f)
    }
}