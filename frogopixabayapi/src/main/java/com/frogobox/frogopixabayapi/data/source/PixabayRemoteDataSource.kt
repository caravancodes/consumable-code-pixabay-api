package com.frogobox.frogopixabayapi.data.source

import android.content.Context
import com.frogobox.frogopixabayapi.data.response.ResponseImage
import com.frogobox.frogopixabayapi.data.response.ResponseVideo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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
object PixabayRemoteDataSource : PixabayDataSource {

    private val pixabayApiService = PixabayApiService

    override fun usingChuckInterceptor(context: Context) {
        pixabayApiService.usingChuckInterceptor(context)
    }

    override fun searchImage(
        apiKey: String,
        query: String,
        callback: PixabayDataSource.GetRemoteCallback<ResponseImage>
    ) {
        pixabayApiService.getApiService
            .searchImage(apiKey, query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : PixabayApiCallback<ResponseImage>() {
                override fun onSuccess(model: ResponseImage) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {}
            })
    }

    override fun searchVideo(
        apiKey: String,
        query: String,
        callback: PixabayDataSource.GetRemoteCallback<ResponseVideo>
    ) {
        pixabayApiService.getApiService
            .searchVideo(apiKey, query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : PixabayApiCallback<ResponseVideo>() {
                override fun onSuccess(model: ResponseVideo) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {}
            })
    }
}


