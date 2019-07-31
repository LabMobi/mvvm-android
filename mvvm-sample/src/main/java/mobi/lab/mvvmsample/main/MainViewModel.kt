package mobi.lab.mvvmsample.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import mobi.lab.mvvm.Event
import mobi.lab.mvvm.MvvmViewModel

class MainViewModel constructor(model: MainModel) : MvvmViewModel<MainContract.Model>(model), MainContract.ViewModel {

    val action = MutableLiveData<Event<Action>>()

    init {
        model.viewModel = this
        model.loadItems()
    }

    fun onButtonClicked() {
        action.value = Event(Action.OpenSecondScreen)
    }

    override fun onLoadItemsSuccess() {
        Log.e(TAG, "onLoadItemsSuccess")
    }

    override fun onLoadItemsError() {
        Log.e(TAG, "onLoadItemsError")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy")
    }

    companion object {
        const val TAG = "MainViewModel"
    }

    sealed class Action {
        object OpenSecondScreen : Action()
    }
}
