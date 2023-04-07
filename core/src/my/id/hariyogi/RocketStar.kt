package my.id.hariyogi

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.scenes.scene2d.Stage

class RocketStar: Game() {

    private lateinit var rocket: ActorBeta
    private lateinit var meteor: ActorBeta
    private lateinit var stage: Stage

    private var isWin = false


    override fun create() {
        stage = Stage()

        rocket = Rocket()
        rocket.setTexture(Texture(Gdx.files.internal("ship.png")))
        rocket.setPosition(20f, 20f)
        stage.addActor(rocket)

        meteor = ActorBeta()
        meteor.setTexture(Texture(Gdx.files.internal("meteor.png")))
        meteor.setPosition(380f, 380f)
        stage.addActor(meteor)
    }

    override fun render() {

        stage.act(1/60f)

        if(rocket.isOverlaps(meteor)) {
            meteor.remove()
        }

        Gdx.gl.glClearColor(0f,0f,0f,1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        stage.draw()
    }
}