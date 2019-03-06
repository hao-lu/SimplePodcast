package lu.hao.sodalabpodcast

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class PodcastResponse(
    @SerializedName("head")
    @Expose
    var head: List<Head>? = null,
    @SerializedName("episodes")
    @Expose
    var episodes: List<Episode>? = null)
