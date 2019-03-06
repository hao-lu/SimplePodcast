package lu.hao.sodalabpodcast

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Head (

    @SerializedName("limit")
    @Expose
    var limit: Int? = null,
    @SerializedName("offset")
    @Expose
    var offset: Int? = null,
    @SerializedName("count")
    @Expose
    var count: Int? = null
)
