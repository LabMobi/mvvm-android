package mobi.lab.mvvmsample.test

import androidx.lifecycle.MutableLiveData
import mobi.lab.mvvm.Event
import mobi.lab.mvvm.MvvmViewModel

class TestViewModel : MvvmViewModel() {

    val action = MutableLiveData<Event<Action>>()

    sealed class Action
}
