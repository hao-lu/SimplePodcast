package lu.hao.sodalabpodcast

import android.app.Application
import android.content.Context
import android.util.Log

class BaseApp: Application() {

    val TAG = BaseApp::class.java.simpleName

    companion object {
        lateinit var component: AppComponent
            private set

        fun get(context: Context): BaseApp {
            return context.applicationContext as BaseApp
        }
    }

    override fun onCreate() {
        super.onCreate()
        init(BASE_URL)
    }

    fun init(baseUrl: String) {
        component = DaggerAppComponent
            .builder()
            .networkModule(NetworkModule(baseUrl))
            .build()
    }

}
