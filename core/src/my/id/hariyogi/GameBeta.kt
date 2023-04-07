package my.id.hariyogi

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Stage

abstract class GameBeta: Game() {

    protected lateinit var mainStage: Stage

    abstract fun initialize()
    abstract fun update(deltaTime: Float)

    override fun create() {
        mainStage = Stage()
        initialize()
    }

    override fun render() {
        val deltaTime = Gdx.graphics.deltaTime

        mainStage.act(deltaTime)
        update(deltaTime)

        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        mainStage.draw()
    }
}