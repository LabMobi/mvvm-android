package mobi.lab.mvvmsample.second

import android.util.Log
import androidx.lifecycle.MutableLiveData
import mobi.lab.mvvm.Event
import mobi.lab.mvvm.MvvmViewModel

class SecondViewModel : MvvmViewModel() {

    val checked = MutableLiveData<Boolean>()
    val action = MutableLiveData<Event<Action>>()

    fun onCheckedChanged(checked: Boolean) {
        this.checked.value = checked
    }

    fun onConfirmClicked() {
        if (checked.value == true) {
            action.value = Event(Action.ShowConfirmCoolDialog)
        } else {
            action.value = Event(Action.ShowConfirmNotCoolDialog)
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared")
    }

    sealed class Action {
        object ShowConfirmCoolDialog : Action()
        object ShowConfirmNotCoolDialog : Action()
    }

    companion object {
        const val TAG = "SecondViewModel"
    }
}
