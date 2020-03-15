package com.frogobox.frogopixabayapi

import android.content.Context
import com.frogobox.frogopixabayapi.callback.PixabayResultCallback
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
 * com.frogobox.frogopixabayapi
 *
 */

interface ConsumePixabayApiView {

    // Switch For Using Chuck Interceptor
    fun usingChuckInterceptor(context: Context)

    // Search for Image
    fun searchImage(query: String, callback: PixabayResultCallback<Response<Image>>)

    // Search for Video
    fun searchVideo(query: String, callback: PixabayResultCallback<Response<Video>>)

}
