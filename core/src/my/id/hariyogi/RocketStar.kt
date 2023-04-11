package my.id.hariyogi

import my.id.hariyogi.base.BaseActor
import my.id.hariyogi.entity.Meteor
import my.id.hariyogi.entity.Rocket

class RocketStar: GameBeta() {

    private lateinit var rocket: BaseActor
    private lateinit var meteor: BaseActor

    override fun initialize() {
        rocket = Rocket(20f, 20f)
        mainStage.addActor(rocket)

        meteor = Meteor(380f, 380f)
        mainStage.addActor(meteor)
    }

    override fun update(deltaTime: Float) {
        if(rocket.isOverlaps(meteor)) {
            meteor.remove()
        }
    }
}