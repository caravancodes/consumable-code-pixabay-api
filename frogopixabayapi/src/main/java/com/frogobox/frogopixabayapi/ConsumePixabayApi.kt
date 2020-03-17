package com.frogobox.frogopixabayapi

import android.content.Context
import com.frogobox.frogopixabayapi.callback.PixabayResultCallback
import com.frogobox.frogopixabayapi.data.model.Image
import com.frogobox.frogopixabayapi.data.model.Video
import com.frogobox.frogopixabayapi.data.response.Response
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

    override fun searchImage(query: String, callback: PixabayResultCallback<Response<Image>>) {
        pixabayRepository.searchImage(
            apiKey,
            query,
            object : PixabayDataSource.GetRemoteCallback<Response<Image>> {
                override fun onSuccess(data: Response<Image>) {
                    callback.getResultData(data)
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    callback.failedResult(statusCode, errorMessage)
                }

                override fun onShowProgress() {
                    callback.onShowProgress()
                }

                override fun onHideProgress() {
                    callback.onHideProgress()
                }
            })
    }

    override fun searchVideo(query: String, callback: PixabayResultCallback<Response<Video>>) {
        pixabayRepository.searchVideo(
            apiKey,
            query,
            object : PixabayDataSource.GetRemoteCallback<Response<Video>> {
                override fun onSuccess(data: Response<Video>) {
                    callback.getResultData(data)
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    callback.failedResult(statusCode, errorMessage)
                }

                override fun onShowProgress() {
                    callback.onShowProgress()
                }

                override fun onHideProgress() {
                    callback.onHideProgress()
                }
            })
    }
}