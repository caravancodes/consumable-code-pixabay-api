package com.frogobox.frogopixabayapi

import android.content.Context
import com.frogobox.frogopixabayapi.callback.PixabayResultCallback
import com.frogobox.frogopixabayapi.data.model.Image
import com.frogobox.frogopixabayapi.data.model.Video
import com.frogobox.frogopixabayapi.data.response.ResponseImage
import com.frogobox.frogopixabayapi.data.response.ResponseVideo
import com.frogobox.frogopixabayapi.data.source.PixabayDataSource
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
class ConsumePixabayApi(private val apiKey: String) : ConsumePixabayApiView {

    private val pixabayRepository = PixabayRepository(PixabayRemoteDataSource)

    override fun usingChuckInterceptor(context: Context) {
        pixabayRepository.usingChuckInterceptor(context)
    }

    override fun searchImage(query: String, callback: PixabayResultCallback<ResponseImage>) {
        pixabayRepository.searchImage(
            apiKey,
            query,
            object : PixabayDataSource.GetRemoteCallback<ResponseImage> {
                override fun onSuccess(data: ResponseImage) {
                    callback.getResultData(data)
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    callback.failedResult(statusCode, errorMessage)
                }
            })
    }

    override fun searchVideo(query: String, callback: PixabayResultCallback<ResponseVideo>) {
        pixabayRepository.searchVideo(
            apiKey,
            query,
            object : PixabayDataSource.GetRemoteCallback<ResponseVideo> {
                override fun onSuccess(data: ResponseVideo) {
                    callback.getResultData(data)
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    callback.failedResult(statusCode, errorMessage)
                }
            })
    }
}