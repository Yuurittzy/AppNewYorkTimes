package com.example.api_nyt_yuritzy.data

data class NYTResponse(var status: String,var copyright: String, var num_results: String, var results: List<Results>)
