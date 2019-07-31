package mobi.lab.mvvmsample.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import mobi.lab.mvvm.Event
import mobi.lab.mvvm.MvvmViewModel

class MainViewModel(private val model: MainModel) : MvvmViewModel() {

    val action = MutableLiveData<Event<Action>>()

    init {
        model.loadItems(this::onLoadItemsSuccess, this::onLoadItemsError)
    }

    fun onButtonClicked() {
        action.value = Event(Action.OpenSecondScreen)
    }

    private fun onLoadItemsSuccess() {
        Log.d(TAG, "onLoadItemsSuccess")
    }

    private fun onLoadItemsError() {
        Log.d(TAG, "onLoadItemsError")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared")
    }

    sealed class Action {
        object OpenSecondScreen : Action()
    }

    companion object {
        const val TAG = "MainViewModel"
    }
}
