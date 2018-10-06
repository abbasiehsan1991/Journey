package codenevisha.ir.app.journey.data.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ArticleModel {

    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("totalResults")
    @Expose
    var totalResults: Int? = null
    @SerializedName("articles")
    @Expose
    var articles: List<Article>? = null

}