package com.example.api_nyt_yuritzy.data

data class Results(var url:String,
                   var section:String,
                   var title:String,
                   var published_date:String,
                   var media:List<Media>)
