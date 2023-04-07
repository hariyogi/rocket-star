package my.id.hariyogi

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.scenes.scene2d.Actor

open class ActorBeta:Actor() {
    var textureRegion = TextureRegion()
    private val rectangle: Rectangle = Rectangle()
        get() {
            field.setPosition(x, y)
            return field
        }

    fun setTexture(texture: Texture) {
        textureRegion.setRegion(texture)
        setSize(texture.width.toFloat(), texture.height.toFloat())
        rectangle.setSize(texture.width.toFloat(), texture.height.toFloat())
    }

    fun updateRectangle() {
        rectangle.setPosition(x, y)
    }

    fun isOverlaps(actor: ActorBeta): Boolean = rectangle.overlaps(actor.rectangle)

    override fun draw(batch: Batch, parentAlpha: Float) {
        super.draw(batch, parentAlpha)

        batch.setColor(color.r, color.g, color.b, color.a)
        if(isVisible) {
            batch.draw(textureRegion, x, y, originX, originY, width, height, scaleX, scaleY, rotation)
        }
    }
}