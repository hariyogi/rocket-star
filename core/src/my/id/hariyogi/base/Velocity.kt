package my.id.hariyogi.base

import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Vector2

class Velocity(
    var maxSpeed: Float = 0f,
    var decelarion: Float = 0f,
    var acceleration: Float = 100f
) {

    var velocityVec = Vector2(0f, 0f)
    var accelerationVec = Vector2(0f, 0f)
    var speed: Float
        set(value) {
            if(velocityVec.len() == 0f) {
                velocityVec.set(value, 0f)
            }else {
                velocityVec.setLength(value)
            }
        }
        get() = velocityVec.len()

    val motionAngle: Float
        get() = velocityVec.angleDeg()

    val isMoving: Boolean
        get() = speed > 0

    fun accelerateAtAngle(angle: Float) {
        accelerationVec.add(Vector2(acceleration, 0f).setAngleDeg(angle))
    }

    fun applyPhysics(dt: Float) {
        velocityVec.add(accelerationVec.x * dt, accelerationVec.y * dt)

        var speed = this.speed

        if(accelerationVec.len() == 0f) {
            speed -= decelarion * dt
        }

        speed = MathUtils.clamp(speed, 0f, maxSpeed)

        this.speed = speed
        accelerationVec.set(0f, 0f)
    }
}
