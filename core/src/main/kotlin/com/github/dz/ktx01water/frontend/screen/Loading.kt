package com.github.dz.ktx01water.frontend.screen


import com.badlogic.gdx.audio.Music
import kotlinx.coroutines.launch
import ktx.app.KtxScreen
import ktx.async.KtxAsync

import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import ktx.graphics.use
import ktx.inject.*
import ktx.assets.async.AssetStorage

class Loading(
    context: Context,
    private val _onLoaded: (KtxScreen) -> Unit = {},
) : KtxScreen {
    var loaded = false
    override fun show() {
        if (loaded) return
        loadAssets()
    }

    fun loadAssets() {
        KtxAsync.launch {
            assetStorage.load<Texture>("background.png")
            assetStorage.load<Texture>("bucket.png")
            assetStorage.load<Texture>("drop.png")
            assetStorage.load<Music>("drop.mp3")
            assetStorage.load<Music>("music.mp3")


            loaded = true
        }
    }

    override fun render(delta: Float) {
        if (loaded) {
            onLoaded()
        }
        draw()
    }

    fun onLoaded() = _onLoaded(this)

    val batch: SpriteBatch
    val font: BitmapFont
    val camera = OrthographicCamera()

    val assetStorage: AssetStorage

    init {
        context.register {
            bindSingleton(SpriteBatch())
            bindSingleton(BitmapFont())
            bindSingleton(AssetStorage())
        }
        batch = context.inject()
        font = context.inject()

        camera.apply {
            setToOrtho(false, 800f, 480f)
        }

        assetStorage = context.inject()
    }

    fun draw() {
        batch.use(camera) {
            font.draw(it, "Loading...", 100f, 100f)
        }
    }


}
