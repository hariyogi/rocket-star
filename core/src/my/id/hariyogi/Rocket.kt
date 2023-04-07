package my.id.hariyogi

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input.Keys

class Rocket: ActorBeta() {

    override fun act(delta: Float) {
        super.act(delta)

        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            moveBy(-1f, 0f)
        }

        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            moveBy(1f, 0f)
        }

        if(Gdx.input.isKeyPressed(Keys.UP)) {
            moveBy(0f, 1f)
        }

        if(Gdx.input.isKeyPressed(Keys.DOWN)) {
            moveBy(0f, -1f)
        }
    }
}