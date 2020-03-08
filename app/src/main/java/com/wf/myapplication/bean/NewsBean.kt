package com.wf.myapplication.bean

data class NewsBean(
    val T1348647909107: List<T1348647909107>
)

data class T1348647909107(
    val ads: List<Ad>,
    val alias: String,
    val boardid: String,
    val cid: String,
    val commentStatus: Int,
    val daynum: String,
    val digest: String,
    val docid: String,
    val ename: String,
    val hasAD: Int,
    val hasCover: Boolean,
    val hasHead: Int,
    val hasIcon: Boolean,
    val hasImg: Int,
    val imgsrc: String,
    val lmodify: String,
    val ltitle: String,
    val mtime: String,
    val order: Int,
    val postid: String,
    val priority: Int,
    val ptime: String,
    val quality: Int,
    val replyCount: Int,
    val skipID: String,
    val skipType: String,
    val source: String,
    val sourceId: String,
    val specialID: String,
    val subtitle: String,
    val tagList: List<Tag>,
    val template: String,
    val title: String,
    val tname: String,
    val topic_background: String,
    val url: String,
    val url_3w: String,
    val votecount: Int
)

data class Ad(
    val imgsrc: String,
    val skipID: String,
    val skipType: String,
    val subtitle: String,
    val tag: String,
    val title: String,
    val url: String
)

data class Tag(
    val level: Int,
    val text: String,
    val type: String
)