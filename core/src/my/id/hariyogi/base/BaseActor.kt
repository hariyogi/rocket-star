package my.id.hariyogi.base

import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.scenes.scene2d.Actor

open class BaseActor(x: Float, y: Float) : Actor() {

    var animation: Animation<TextureRegion>? = null
    var animationPaused: Boolean = false
    private var elapsedTime: Float = 0f

    var rectangle: Rectangle? = null

    init {
        setPosition(x, y)
    }

    fun initTexture(animation: Animation<TextureRegion>) {
        this.animation = animation
        val textureRegion = animation.getKeyFrame(0f)
        val width = textureRegion.regionWidth
        val height = textureRegion.regionHeight
        setSize(width.toFloat(), height.toFloat())
        setOrigin(width.toFloat() / 2, height.toFloat() / 2)
        rectangle = Rectangle(x, y, width.toFloat(), height.toFloat())
    }

    /**
     * Konfigurasi size dan originnya.
     */
    fun setSizeAndOrigin(width: Float, height: Float) {
        setSize(width, height)
        setOrigin(width / 2, height / 2)
    }

    override fun setSize(width: Float, height: Float) {
        super.setSize(width, height)
        rectangle?.setSize(width, height)
    }

    fun isAnimationFinished() = animation?.isAnimationFinished(elapsedTime) ?: true
    fun isOverlaps(baseActor: BaseActor) = rectangle?.overlaps(baseActor.rectangle) ?: false

    override fun act(delta: Float) {
        super.act(delta)

        if (!animationPaused) {
            elapsedTime += delta
        }

        rectangle?.setPosition(x, y)
    }

    override fun draw(batch: Batch?, parentAlpha: Float) {
        super.draw(batch, parentAlpha)

        batch?.setColor(color.r, color.g, color.b, color.a)

        if (animation != null && isVisible) {
            batch?.draw(
                animation?.getKeyFrame(elapsedTime),
                x, y, originX, originY, width, height, scaleX, scaleY, rotation
            )
        }
    }
}