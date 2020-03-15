package com.frogobox.frogopixabayapi.data.source

import android.content.Context
import com.frogobox.frogopixabayapi.data.model.Image
import com.frogobox.frogopixabayapi.data.model.Video
import com.frogobox.frogopixabayapi.data.response.Response

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
 * com.frogobox.frogopixabayapi.data.source
 *
 */

class PixabayRepository (private val remoteDataSource: PixabayRemoteDataSource) : PixabayDataSource {

    override fun usingChuckInterceptor(context: Context) {
        remoteDataSource.usingChuckInterceptor(context)
    }

    override fun searchImage(
        apiKey: String,
        query: String,
        callback: PixabayDataSource.GetRemoteCallback<Response<Image>>
    ) {
        remoteDataSource.searchImage(apiKey, query, callback)
    }

    override fun searchVideo(
        apiKey: String,
        query: String,
        callback: PixabayDataSource.GetRemoteCallback<Response<Video>>
    ) {
        remoteDataSource.searchVideo(apiKey, query, callback)
    }
}