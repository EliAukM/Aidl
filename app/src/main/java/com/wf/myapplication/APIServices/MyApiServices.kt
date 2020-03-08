package com.wf.myapplication.APIServices

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Url

interface MyApiServices {
    
    @GET
    fun get(@Url url:String):Observable<ResponseBody>

}