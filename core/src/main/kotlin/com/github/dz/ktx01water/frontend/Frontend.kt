package com.github.dz.ktx01water.frontend


import com.github.dz.ktx01water.frontend.screen.Game
import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.inject.*

import com.github.dz.ktx01water.frontend.screen.Loading


open class Frontend(
    private val context: Context
): KtxGame<KtxScreen>() {
    override fun create() {
        super.create()
        context.register {
            bindSingleton(this@Frontend)
        }
        addScreen(Loading(context) {
            setScreen<Game>()
            removeScreen<Loading>()
            it.dispose()
        })
        addScreen(Game(context))


        setScreen<Loading>()
    }
}
