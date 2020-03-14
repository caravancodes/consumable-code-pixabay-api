package com.frogobox.pixabayapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.frogobox.frogopixabayapi.ConsumePixabayApi
import com.frogobox.frogopixabayapi.callback.PixabayResultCallback
import com.frogobox.frogopixabayapi.data.response.ResponseImage
import com.frogobox.frogopixabayapi.util.PixabayConstant

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val consumePixabayApi = ConsumePixabayApi(PixabayConstant.SAMPLE_API_KEY)
        consumePixabayApi.usingChuckInterceptor(this)

        val query = "One Piece"

        consumePixabayApi.searchImage(query, object : PixabayResultCallback<ResponseImage>{
            override fun getResultData(data: ResponseImage) {
                for (i in data.hits?.indices!!) {
                    println(data.hits!![0].largeImageURL)
                }
            }

            override fun failedResult(statusCode: Int, errorMessage: String?) {
            }
        })

    }
}
