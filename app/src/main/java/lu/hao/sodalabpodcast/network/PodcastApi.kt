package lu.hao.sodalabpodcast

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET

interface PodcastApi {

    @GET("autolist.json?limit=1&offset=5")
    fun getAutoList(): Observable<PodcastResponse>

}