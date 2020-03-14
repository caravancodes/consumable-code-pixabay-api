package com.frogobox.frogopixabayapi

import android.content.Context
import com.frogobox.frogopixabayapi.data.source.PixabayRemoteDataSource
import com.frogobox.frogopixabayapi.data.source.PixabayRepository

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * PixabayAPI
 * Copyright (C) 14/03/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogopixabayapi
 *
 */
class ConsumePixabayApi (private val apiKey: String) : ConsumePixabayApiView {

    private val pixabayRepository = PixabayRepository(PixabayRemoteDataSource)

    override fun usingChuckInterceptor(context: Context) {
        pixabayRepository.usingChuckInterceptor(context)
    }

}