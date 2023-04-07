package my.id.hariyogi

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture

class RocketStar: GameBeta() {

    private lateinit var rocket: ActorBeta
    private lateinit var meteor: ActorBeta

    override fun initialize() {
        rocket = Rocket()
        rocket.setTexture(Texture(Gdx.files.internal("ship.png")))
        rocket.setPosition(20f, 20f)
        mainStage.addActor(rocket)

        meteor = ActorBeta()
        meteor.setTexture(Texture(Gdx.files.internal("meteor.png")))
        meteor.setPosition(380f, 380f)
        mainStage.addActor(meteor)
    }

    override fun update(deltaTime: Float) {
        if(rocket.isOverlaps(meteor)) {
            meteor.remove()
        }
    }
}