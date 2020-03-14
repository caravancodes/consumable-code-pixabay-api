package com.frogobox.frogopixabayapi.data.model

import com.google.gson.annotations.SerializedName

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
 * com.frogobox.frogopixabayapi.data.model
 *
 */
data class VideoType(

    @SerializedName("large")
    var large: VideoType? = null,

    @SerializedName("medium")
    var medium: VideoType? = null,

    @SerializedName("small")
    var small: VideoType? = null,

    @SerializedName("tiny")
    var tiny: VideoType? = null
)