package mobi.lab.mvvm

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

public interface MvvmLiveDataExtensions {
    public fun getLifecycleOwner(): LifecycleOwner

    public fun <T> LiveData<T>.onEachNotNull(block: (T) -> Unit) {
        this.observe(getLifecycleOwner(), Observer { it?.let(block) })
    }

    public fun <T> LiveData<T>.onEach(block: (T?) -> Unit) {
        this.observe(getLifecycleOwner(), Observer { block(it) })
    }

    @Suppress("UNCHECKED_CAST")
    public fun <T, E : SingleEvent<T>> LiveData<E>.onEachEvent(block: (T) -> Boolean) {
        this.observe(getLifecycleOwner(), SingleEventObserver<T> { block(it) } as Observer<E>)
    }
}
