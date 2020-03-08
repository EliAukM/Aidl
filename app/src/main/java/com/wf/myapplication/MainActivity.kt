package com.wf.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.wf.myapplication.adapter.MyAdapter
import com.wf.myapplication.bean.NewsBean
import com.wf.myapplication.bean.T1348647909107
import com.wf.myapplication.network.ICallBack
import com.wf.myapplication.network.Retrofitutils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var list = mutableListOf<T1348647909107>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
//        Retrofitutils.instance
    }

    private fun initData() {

        Retrofitutils.instance.get("http://c.m.163.com/nc/article/headline/T1348647909107/0-20.html",object : ICallBack<NewsBean>{
            override fun onSuccess(t: NewsBean) {

                Log.e("TAG","---成功"+t.toString())

                list.addAll(t.T1348647909107)
                mk_recycleview.adapter!!.notifyDataSetChanged()
            }
            override fun onError(error: String) {

                Log.e("TAG","---失败"+error)

            }
        })
    }

    private fun initView() {
        mk_recycleview.layoutManager = LinearLayoutManager(this)
        mk_recycleview.adapter = MyAdapter(list)
    }
}
