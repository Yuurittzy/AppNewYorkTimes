package com.example.api_nyt_yuritzy.data

import com.google.gson.annotations.SerializedName

data class Media(
    var type:String,
    @SerializedName("media-metadata")  var metadata:List<MediaMetaData>
    )
