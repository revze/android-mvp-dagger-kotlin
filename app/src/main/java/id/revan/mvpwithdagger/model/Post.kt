package id.revan.mvpwithdagger.model

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("id")
    var id: String,

    @SerializedName("title")
    var title: String,

    @SerializedName("body")
    var body: String
)