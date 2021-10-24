package mobi.lab.mvvmsample.second

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import mobi.lab.mvvm.SingleEvent

class SecondViewModel(private val state: SavedStateHandle) : ViewModel() {

    val checked = MutableLiveData<Boolean>()
    val action = MutableLiveData<SingleEvent<Action>>()

    init {
        checked.value = state.get(STATE_CHECKED) ?: false
    }

    fun onCheckedChanged(checked: Boolean) {
        this.checked.value = checked
        state.set(STATE_CHECKED, checked)
    }

    fun onConfirmClicked() {
        if (checked.value == true) {
            action.value = SingleEvent(Action.ShowConfirmCoolDialog)
        } else {
            action.value = SingleEvent(Action.ShowConfirmNotCoolDialog)
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
