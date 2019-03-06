package lu.hao.sodalabpodcast

import dagger.Component


@Component(modules = [(NetworkModule::class)])
interface AppComponent {

    fun inject(mainViewModel: MainViewModel)

}