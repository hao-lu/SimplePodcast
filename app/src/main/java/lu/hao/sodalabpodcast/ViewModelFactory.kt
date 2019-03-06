package lu.hao.sodalabpodcast

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory : ViewModelProvider.Factory {

    private lateinit var mActivity: Activity
    private lateinit var mFragment: Fragment

    constructor(activity: Activity) {
        mActivity = activity
    }

    constructor(fragment: Fragment) {
        mFragment = fragment
    }

    override fun <T : ViewModel?> create(viewModelClass: Class<T>): T {
        when (viewModelClass) {
            MainViewModel::class.java -> return MainViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}