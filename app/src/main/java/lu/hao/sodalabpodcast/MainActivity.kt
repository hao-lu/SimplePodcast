package lu.hao.sodalabpodcast

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import lu.hao.sodalabpodcast.databinding.ActivityMainBinding

class MainActivity : FragmentActivity() {

    private lateinit var mViewModel: MainViewModel
    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mViewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(MainViewModel::class.java)

        mViewModel.episode.observe(this, Observer { episode ->
            if (episode != null) streamAudio(episode.mediaLink!!)
            mBinding.setVariable(BR.episode, episode)
        })

    }

    private fun streamAudio(mediaLink: String) {
        val mediaPlayer: MediaPlayer? = MediaPlayer().apply {
            setAudioStreamType(AudioManager.STREAM_MUSIC)
            setDataSource(mediaLink)
            prepare() // might take long! (for buffering, etc)
            start()
        }
    }
}