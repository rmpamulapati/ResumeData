package com.mani.resumedata.network

import com.mani.resumedata.beans.ResponseModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query



/* endpoint to get Resume Data */
interface GetDataServices {

    @GET("/rmpamulapati/b0056ed7ea9242fbd133e254ab8c1d76/raw/cf422fb4db89833c6563f0264c4c03acfa52ec1c/resume.json")
    fun getData(): Observable<Response<ResponseModel>>
}