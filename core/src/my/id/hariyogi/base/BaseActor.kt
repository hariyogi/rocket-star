package my.id.hariyogi.base

import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.Actor

class BaseActor(var x: Float, var y: Float): Actor() {

    var animation: Animation<TextureRegion>? = null
    private var elapsedTime: Float = 0f
    var animationPaused: Boolean = false

    init {
        setPosition(x, y)
    }

    fun initAnimation(animation: Animation<TextureRegion>) {
        this.animation = animation
        val textureRegion = animation.getKeyFrame(0f)
        val width = textureRegion.regionWidth
        val height = textureRegion.regionHeight
        setSize(width.toFloat(), height.toFloat())
        setOrigin(width.toFloat() / 2, height.toFloat() / 2)
    }

    fun isAnimationFinished() = animation?.isAnimationFinished(elapsedTime) ?: true

    override fun act(delta: Float) {
        super.act(delta)

        if(!animationPaused) {
            elapsedTime += delta
        }
    }

    override fun draw(batch: Batch?, parentAlpha: Float) {
        super.draw(batch, parentAlpha)

        batch?.setColor(color.r, color.g, color.b, color.a)

        if(animation != null && isVisible) {
            batch?.draw(animation?.getKeyFrame(elapsedTime),
                x, y, originX, originY, width, height, scaleX, scaleY, rotation)
        }
    }
}