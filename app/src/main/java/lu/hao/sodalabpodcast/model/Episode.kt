package lu.hao.sodalabpodcast

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Episode(
    @SerializedName("show_id")
    @Expose
    var showId: String? = null,
    @SerializedName("title")
    @Expose
    var title: String? = null,
    @SerializedName("description")
    @Expose
    var description: String? = null,
    @SerializedName("media_link")
    @Expose
    var mediaLink: String? = null,
    @SerializedName("pod_link")
    @Expose
    var podLink: String? = null,
    @SerializedName("author")
    @Expose
    var author: String? = null,
    @SerializedName("rating")
    @Expose
    var rating: String? = null,
    @SerializedName("votes")
    @Expose
    var votes: String? = null,
    @SerializedName("image")
    @Expose
    var image: String? = null,
    @SerializedName("copyright")
    @Expose
    var copyright: String? = null,
    @SerializedName("type")
    @Expose
    var type: String? = null,
    @SerializedName("date")
    @Expose
    var date: String? = null,
    @SerializedName("channel_id")
    @Expose
    var channelId: String? = null,
    @SerializedName("channel_link")
    @Expose
    var channelLink: String? = null,
    @SerializedName("channel_title")
    @Expose
    var channelTitle: String? = null)