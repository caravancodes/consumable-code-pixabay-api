package com.frogobox.pixabayapi

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.frogopixabayapi.ConsumePixabayApi
import com.frogobox.frogopixabayapi.callback.PixabayResultCallback
import com.frogobox.frogopixabayapi.data.model.Image
import com.frogobox.frogopixabayapi.data.response.Response
import com.frogobox.frogopixabayapi.util.PixabayConstant
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val consumePixabayApi = ConsumePixabayApi(PixabayConstant.SAMPLE_API_KEY) // Your API Key
        consumePixabayApi.usingChuckInterceptor(this) // Using Chuck Interceptor

        val query = "Nature"

        consumePixabayApi.searchImage(
            query,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            object : PixabayResultCallback<Response<Image>> {
                override fun getResultData(data: Response<Image>) {
                    // Place your UI / Data
                }

                override fun failedResult(statusCode: Int, errorMessage: String?) {
                    // failed to do
                }

                override fun onShowProgress() {
                    // showing your progress view
                    progressView.visibility = View.VISIBLE
                    progressView.text = "Loading Fetching Pixabay API"
                }

                override fun onHideProgress() {
                    // hide your progress view
                    progressView.visibility = View.GONE
                }
            })

    }
}
