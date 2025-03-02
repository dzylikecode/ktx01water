package com.github.dz.ktx01water

import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.async.KtxAsync

/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms. */
class CoreMain : KtxGame<KtxScreen>() {
    override fun create() {
        KtxAsync.initiate()
    }
}

