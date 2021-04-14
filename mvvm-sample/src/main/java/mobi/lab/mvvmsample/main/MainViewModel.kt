package mobi.lab.mvvmsample.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mobi.lab.mvvm.Event

class MainViewModel(private val model: MainModel) : ViewModel() {

    private val _action = MutableLiveData<Event<Action>>()
    val action = _action as LiveData<Event<Action>>

    init {
        model.loadItems(this::onLoadItemsSuccess, this::onLoadItemsError)
    }

    fun onButtonClicked() {
        _action.value = Event(Action.OpenSecondScreen)
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
