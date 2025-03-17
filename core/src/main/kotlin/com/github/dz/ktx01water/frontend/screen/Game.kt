package com.github.dz.ktx01water.frontend.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.viewport.FitViewport
import ktx.app.KtxInputAdapter
import ktx.app.KtxScreen
import ktx.assets.async.AssetStorage
import ktx.graphics.use
import ktx.inject.Context

class Game(
    private val context: Context
): KtxScreen {
    val assetStorage = context.inject<AssetStorage>()
    val camera = OrthographicCamera()
    val viewport = FitViewport(640f, 480f, camera)

    lateinit var background: Texture
    lateinit var batch: SpriteBatch
    lateinit var bucket: Sprite

    override fun show() {

        background = assetStorage["background.png"]

        batch = context.inject()

        bucket = Sprite(assetStorage["bucket.png"] as Texture)
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height, true)
    }

    override fun render(delta: Float) {
        input()
        batch.use(camera) {
            it.draw(background, 0f, 0f)
            bucket.draw(it)
        }
    }

    val speed = 400f

    fun input() {
        val delta = Gdx.graphics.deltaTime
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            bucket.translateX(-speed * delta)
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            bucket.translateX(speed * delta)
        }
        if (Gdx.input.isTouched) {
            val pos = Vector2(Gdx.input.x.toFloat(), Gdx.input.y.toFloat())
            viewport.unproject(pos)
            bucket.setCenterX(pos.x)
        }
    }

}
