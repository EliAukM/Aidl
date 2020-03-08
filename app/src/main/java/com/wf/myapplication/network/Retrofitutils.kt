package com.wf.myapplication.network

import com.google.gson.Gson
import com.wf.myapplication.APIServices.MyApiServices
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.lang.reflect.ParameterizedType

/**
 * 网络请求，工具类
 */
class Retrofitutils{

  lateinit  var apiServices : MyApiServices


    companion object{
//        单例模式，双重锁验证
        val instance : Retrofitutils by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED){
            Retrofitutils()
        }
    }


    private constructor(){
//创建Retrofit
        var retrofit = Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("http://c.m.163.com/nc/")
            .build()
        apiServices = retrofit.create(MyApiServices::class.java)
    }



    fun <T> get(url:String ,callback: ICallBack<T>){

        apiServices.get(url).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                var rbody = it.string()

//                获取泛型的参数化类型
                val genericInterfaces = callback.javaClass.genericInterfaces

                val parameterizedType = genericInterfaces[0] as ParameterizedType

                val actualTypeArguments = parameterizedType.actualTypeArguments

                var t =   Gson().fromJson<T>(rbody,actualTypeArguments[0])
                callback.onSuccess(t)
            },{
                callback.onError(it.toString())
            })

    }





}