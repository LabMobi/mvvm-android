package mobi.lab.mvvm.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import mobi.lab.mvvm.Event
import mobi.lab.mvvm.EventObserver

fun <T> observeOnEachNotNull(liveData: LiveData<T>, lifecycleOwner: LifecycleOwner, block: (T) -> Unit) {
    liveData.observe(lifecycleOwner, Observer { it?.let(block) })
}

fun <T> observeOnEach(liveData: LiveData<T>, lifecycleOwner: LifecycleOwner, block: (T?) -> Unit) {
    liveData.observe(lifecycleOwner, Observer { block(it) })
}

@Suppress("UNCHECKED_CAST")
fun <T, E : Event<T>> observeOnEachEvent(liveData: LiveData<E>, lifecycleOwner: LifecycleOwner, block: (T) -> Unit) {
    liveData.observe(lifecycleOwner, EventObserver<T> { block(it) } as Observer<E>)
}
