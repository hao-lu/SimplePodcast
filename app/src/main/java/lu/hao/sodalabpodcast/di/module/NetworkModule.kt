package lu.hao.sodalabpodcast

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule(private val baseUrl: String) {

    val TAG = NetworkModule::class.java.simpleName

    @Provides
    @Reusable
    fun providePostApi(retrofit: Retrofit): PodcastApi {
        return retrofit.create(PodcastApi::class.java)
    }

    @Provides
    @Reusable
    fun provideRetrofitInterface(): Retrofit {
        Log.i(TAG, baseUrl)
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .client(OkHttpClient().newBuilder().addInterceptor(BasicAuthInterceptor(BASIC_AUTH_USERNAME, BASIC_AUTH_PASSWORD)).build())
            .build()
    }
}