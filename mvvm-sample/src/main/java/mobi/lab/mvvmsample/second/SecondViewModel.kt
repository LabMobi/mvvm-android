package mobi.lab.mvvmsample.second

import android.util.Log
import androidx.lifecycle.MutableLiveData
import mobi.lab.mvvm.Event
import mobi.lab.mvvm.MvvmViewModel

class SecondViewModel constructor(model: SecondModel) : MvvmViewModel<SecondContract.Model>(model), SecondContract.ViewModel {

    val checked = MutableLiveData<Boolean>()
    val action = MutableLiveData<Event<Action>>()

    init {
        model.viewModel = this
    }

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

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy")
    }

    companion object {
        const val TAG = "SecondViewModel"
    }

    sealed class Action {
        object ShowConfirmCoolDialog : Action()
        object ShowConfirmNotCoolDialog : Action()
    }
}
