package com.example.api_nyt_yuritzy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.api_nyt_yuritzy.api.APIService
import com.example.api_nyt_yuritzy.data.NYTResponse
import com.example.api_nyt_yuritzy.data.Results
import com.example.api_nyt_yuritzy.databinding.ActivityMainBinding
import com.example.api_nyt_yuritzy.recyclerview.Adapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: Adapter
    private val articles2 = mutableListOf<Results>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getEmailedPopular()
        initRecyclerView()
    }


    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/mostpopular/v2/emailed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getEmailedPopular()
    {
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<NYTResponse> = getRetrofit().create(APIService::class.java).getResponse("7.json?api-key=qEZbpqR49toGErPwgwYuGpXT8sJ3MFoN")
            val nYTResponse : NYTResponse? =  call.body()
            val articles: List<Results> = nYTResponse?.results ?: emptyList()
            runOnUiThread {
                if(call.isSuccessful)
                {
                    if(nYTResponse != null)
                    {
                       // findViewById<TextView>(R.id.tv).text = articles.results.first().title
                        articles2.clear()
                       articles2.addAll(articles)
                        adapter.notifyDataSetChanged()
                        findViewById<WebView>(R.id.web_view).loadUrl(articles2[0].url)
                        // binding.browser1.loadUrl(articles2[0].url)
                    }
                }
            }
        }

    }

    private fun initRecyclerView() {
        adapter = Adapter(articles2){OnItemSelected(it)}
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerView.adapter = adapter

    }

    fun OnItemSelected(results: Results){
        binding.webView.loadUrl(results.url)
    }


}