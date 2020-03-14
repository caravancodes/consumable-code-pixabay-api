package com.frogobox.frogopixabayapi.data.source

import android.content.Context
import com.frogobox.frogopixabayapi.base.BasePixabayDataSource
import com.frogobox.frogopixabayapi.data.model.Image
import com.frogobox.frogopixabayapi.data.model.Video
import com.frogobox.frogopixabayapi.data.response.ResponseImage
import com.frogobox.frogopixabayapi.data.response.ResponseVideo

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

interface PixabayDataSource {

    // Switch For Using Chuck Interceptor
    fun usingChuckInterceptor(context: Context)

    // Search for Image
    fun searchImage(apiKey: String, query: String, callback: GetRemoteCallback<ResponseImage>)

    // Search for Video
    fun searchVideo(apiKey: String, query: String, callback: GetRemoteCallback<ResponseVideo>)

    // Response Callback
    interface GetRemoteCallback<T> : BasePixabayDataSource.ResponseCallback<T>

}
