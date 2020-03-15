package com.frogobox.pixabayapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.frogopixabayapi.ConsumePixabayApi
import com.frogobox.frogopixabayapi.callback.PixabayResultCallback
import com.frogobox.frogopixabayapi.data.model.Image
import com.frogobox.frogopixabayapi.data.response.Response
import com.frogobox.frogopixabayapi.util.PixabayConstant

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val consumePixabayApi = ConsumePixabayApi(PixabayConstant.SAMPLE_API_KEY)
        consumePixabayApi.usingChuckInterceptor(this)

        val query = "One Piece"

        consumePixabayApi.searchImage(query, object : PixabayResultCallback<Response<Image>> {
            override fun getResultData(data: Response<Image>) {
                for (i in data.hits?.indices!!) {
                    println(data.hits!![0].largeImageURL)
                }
            }

            override fun failedResult(statusCode: Int, errorMessage: String?) {
            }
        })

    }
}
