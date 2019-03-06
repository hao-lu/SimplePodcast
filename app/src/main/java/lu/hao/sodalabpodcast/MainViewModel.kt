package lu.hao.sodalabpodcast

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel : ViewModel() {

    val TAG = MainViewModel::class.java.simpleName
    val episode:MutableLiveData<Episode> = MutableLiveData()

    @Inject
    lateinit var podcastApi: PodcastApi

    init {
        BaseApp.component.inject(this)
        loadAutoList()

    }

    private fun loadAutoList() {
        podcastApi.getAutoList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { podcastResponse ->
                    Log.i(TAG, podcastResponse.toString())
                    onSuccessfulLoad(podcastResponse)
                },
                { e ->
                    e.printStackTrace()
                },
                {
                    Log.i(TAG, "POST API Complete")
                }
            )
    }

    private fun onSuccessfulLoad(podcastResponse: PodcastResponse) {
        episode.value = podcastResponse.episodes!![0]
    }

}