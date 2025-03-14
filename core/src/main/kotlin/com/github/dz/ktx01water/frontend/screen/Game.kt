package com.github.dz.ktx01water.frontend.screen

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import ktx.app.KtxScreen
import ktx.assets.async.AssetStorage
import ktx.graphics.use
import ktx.inject.Context

class Game(
    private val context: Context
): KtxScreen {
    val assetStorage = context.inject<AssetStorage>()
    val camera = OrthographicCamera()

    lateinit var background: Texture
    lateinit var batch: SpriteBatch

    override fun show() {
        camera.setToOrtho(false, 800f, 480f)

        background = assetStorage["background.png"]

        batch = context.inject()
    }

    override fun render(delta: Float) {
        batch.use(camera) {
            it.draw(background, 0f, 0f)
        }
    }
}
