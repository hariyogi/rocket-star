package my.id.hariyogi

import com.badlogic.gdx.Gdx
import my.id.hariyogi.base.AnimationUtils
import my.id.hariyogi.base.BaseActor
import my.id.hariyogi.entity.Explosion
import my.id.hariyogi.entity.Meteor
import my.id.hariyogi.entity.Rocket

class RocketStar: GameBeta() {

    private lateinit var rocket: BaseActor
    private lateinit var meteor: BaseActor
    private lateinit var background: BaseActor
    private lateinit var explosion: BaseActor

    override fun initialize() {
        background = BaseActor(0f, 0f)
        background.initTexture(AnimationUtils.loadSingleTexture("background.png"))
        background.setSize(Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat())
        mainStage.addActor(background)

        rocket = Rocket(20f, 20f)
        mainStage.addActor(rocket)

        meteor = Meteor(380f, 380f)
        mainStage.addActor(meteor)

        explosion = Explosion(80f, 80f)
        mainStage.addActor(explosion)

    }

    override fun update(deltaTime: Float) {
        if(rocket.isOverlaps(meteor)) {
            meteor.remove()
        }
    }
}