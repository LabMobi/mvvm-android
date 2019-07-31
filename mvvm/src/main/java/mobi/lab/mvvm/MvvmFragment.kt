package mobi.lab.mvvm

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlin.reflect.KClass

abstract class MvvmFragment<VM : MvvmViewModel> : Fragment() {

    protected abstract val vmClass: KClass<VM>
    protected abstract fun provideViewModelFactory(): ViewModelProvider.Factory

    protected val viewModel: VM by lazy {
        ViewModelProviders.of(this, provideViewModelFactory()).get(vmClass.java)
    }

    fun <T> LiveData<T>.onEachNotNull(block: (T) -> Unit) = observeOnEachNotNull(this, viewLifecycleOwner, block)
    fun <T> LiveData<T>.onEach(block: (T?) -> Unit) = observeOnEach(this, viewLifecycleOwner, block)
    fun <T, E : Event<T>> LiveData<E>.onEachEvent(block: (T) -> Unit) = observeOnEachEvent(this, viewLifecycleOwner, block)
}
