package ${packageName}

import androidx.lifecycle.MutableLiveData
import mobi.lab.mvvm.Event
import mobi.lab.mvvm.MvvmViewModel

class ${className}ViewModel : MvvmViewModel() {

    val action = MutableLiveData<Event<Action>>()

    sealed class Action
}
