package mobi.lab.mvvmsample.second

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import mobi.lab.mvvm.Event
import mobi.lab.mvvm.MvvmViewModel

class SecondViewModel(private val state: SavedStateHandle) : MvvmViewModel() {

    val checked = MutableLiveData<Boolean>()
    val action = MutableLiveData<Event<Action>>()

    init {
        checked.value = state.get(STATE_CHECKED) ?: false
    }

    fun onCheckedChanged(checked: Boolean) {
        this.checked.value = checked
        state.set(STATE_CHECKED, checked)
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
        private const val TAG = "SecondViewModel"
        private const val STATE_CHECKED = "checked"
    }
}
