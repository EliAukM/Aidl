package com.wf.myapplication.network

interface ICallBack<T> {
    fun onSuccess(t : T)
    fun onError(error: String)
}