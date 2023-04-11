package my.id.hariyogi.base

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.TextureRegion

object AnimationUtils {
    @JvmStatic
    fun loadFromFiles(
        fileNames: Array<String>,
        frameDuration: Float,
        loop: Boolean,
    ): Animation<TextureRegion> {
        val textureArray: com.badlogic.gdx.utils.Array<TextureRegion> = com.badlogic.gdx.utils.Array()

        for(fileName in fileNames) {
            val texture = Texture(Gdx.files.internal(fileName))
            texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)
            textureArray.add(TextureRegion(texture))
        }

        val animation: Animation<TextureRegion> = Animation(frameDuration, textureArray)

        animation.playMode = if (loop) Animation.PlayMode.LOOP else Animation.PlayMode.NORMAL

        return animation
    }

    fun loadFromSpreadSheet(
        fileName: String,
        rows: Int,
        cols: Int,
        frameDuration: Float,
        loop: Boolean
    ): Animation<TextureRegion> {
        val texture = Texture(Gdx.files.internal(fileName), true)
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)
        val frameWidth = texture.width / cols
        val frameHeight = texture.height / rows

        val temp = TextureRegion.split(texture, frameWidth, frameHeight)
        val textureArray: com.badlogic.gdx.utils.Array<TextureRegion> = com.badlogic.gdx.utils.Array()

        for(row in 0 until rows) {
            for(col in 0 until cols) {
                textureArray.add(temp[row][col])
            }
        }

        val animation: Animation<TextureRegion> = Animation(frameDuration, textureArray)

        animation.playMode = if (loop) Animation.PlayMode.LOOP else Animation.PlayMode.NORMAL

        return animation
    }

    fun loadSingleTexture(filename: String): Animation<TextureRegion> {
        val filenames = arrayOf(filename)
        return loadFromFiles(filenames, 1f, true)
    }
}