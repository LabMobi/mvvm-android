package mobi.lab.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class MvvmViewModel : ViewModel() {
    val showProgress = MutableLiveData<Boolean>()
    val finish = MutableLiveData<Boolean>()
}
