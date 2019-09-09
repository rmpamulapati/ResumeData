package com.mani.resumedata.network

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.mani.resumedata.beans.ResponseModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class ApiClient {

    private val myAppService: GetDataServices

    init {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val clientBuilder = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        clientBuilder.addInterceptor(loggingInterceptor)

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        myAppService = retrofit.create(GetDataServices::class.java)
    }

    companion object {
        private val BASE_URL = "https://gist.githubusercontent.com"
        private var apiClient: ApiClient? = null
        /**
         * Gets app client.
         *
         * @return the app client
         */
        val instance: ApiClient get() {
            if (apiClient == null) {
                apiClient = ApiClient()
            }
            return apiClient as ApiClient
        }
    }

    /**
     * Gets resume Data.
     *
     * @return the resume data
     */
    fun fetchResumeData(): Observable<Response<ResponseModel>> {
        return myAppService.getData()
    }
}
