package com.frogobox.pixabayapi

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.frogobox.frogopixabayapi.ConsumePixabayApi
import com.frogobox.frogopixabayapi.callback.PixabayResultCallback
import com.frogobox.frogopixabayapi.data.model.PixabayImage
import com.frogobox.frogopixabayapi.data.response.Response
import com.frogobox.frogopixabayapi.util.PixabayConstant
import com.frogobox.recycler.boilerplate.viewrclass.FrogoViewAdapterCallback
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupConsumablePixabayAPI("naruto")

    }

    private fun consumePixabay() : ConsumePixabayApi {
        val consumePixabayApi = ConsumePixabayApi(PixabayConstant.SAMPLE_API_KEY) // Your API Key
        consumePixabayApi.usingChuckInterceptor(this) // Using Chuck Interceptor
        return consumePixabayApi
    }

    private fun setupConsumablePixabayAPI(query: String){
        consumePixabay().searchImage(
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
            object : PixabayResultCallback<Response<PixabayImage>> {
                override fun getResultData(data: Response<PixabayImage>) {
                    // Place your UI / Data
                    data.hits?.let { setupFrogoRecyclerView(it) }
                }

                override fun failedResult(statusCode: Int, errorMessage: String?) {
                    // failed to do
                }

                override fun onShowProgress() {
                    // showing your progress view
                    runOnUiThread {
                        progressView.visibility = View.VISIBLE
                        progressView.text = "Loading Fetching Pixabay API"
                    }
                }

                override fun onHideProgress() {
                    // hide your progress view
                    runOnUiThread {
                        progressView.visibility = View.GONE
                    }
                }
            })
    }

    private fun setupFrogoRecyclerView(data: List<PixabayImage>){
        frogo_rv.injector<PixabayImage>()
            .addData(data)
            .addCustomView(R.layout.frogo_rv_grid_type_12)
            .addEmptyView(null)
            .addCallback(object : FrogoViewAdapterCallback<PixabayImage>{
                override fun onItemClicked(data: PixabayImage) {}

                override fun onItemLongClicked(data: PixabayImage) {}

                override fun setupInitComponent(view: View, data: PixabayImage) {
                    val ivPoster = view.findViewById<ImageView>(R.id.frogo_rv_type_12_iv_poster)
                    val tvTitle = view.findViewById<TextView>(R.id.frogo_rv_type_12_tv_title)
                    Glide.with(view.context).load(data.previewURL).into(ivPoster)
                    val totalLikes = data.likes.toString()
                    tvTitle.text = "$totalLikes likes"
                }
            })
            .createLayoutGrid(2)
            .build()
    }
}
