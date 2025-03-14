package com.github.dz.ktx01water

import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.async.KtxAsync
import ktx.inject.Context

import com.github.dz.ktx01water.frontend.Frontend

/// 我这是想说明，game = frontend
class CoreMain : Frontend(
    context = Context()
) {
    // 用来存放各种全局变量
    val context = Context()

    override fun create() {
        KtxAsync.initiate()
        // 特定强调调用的是frontend的create
        super<Frontend>.create()
    }

    override fun dispose() {
        super<Frontend>.dispose()
        context.dispose()
    }
}

