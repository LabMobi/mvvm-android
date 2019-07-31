package mobi.lab.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mobi.lab.mvvm.contracts.MvvmModelContract

open class MvvmViewModel<MODEL : MvvmModelContract>(
    protected val model: MODEL
) : ViewModel() {

    val showProgress = MutableLiveData<Boolean>()
    val finish = MutableLiveData<Boolean>()

    final override fun onCleared() {
        model.onDestroy()
        super.onCleared()
        // Make sure that model.onDestroy is always called
        onDestroy()
    }

    open fun onDestroy() {
        // Override this to handle when the ViewModel is destroyed
    }
}
