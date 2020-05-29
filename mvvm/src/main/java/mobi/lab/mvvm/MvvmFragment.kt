package mobi.lab.mvvm

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class MvvmFragment : Fragment, MvvmLiveDataExtensions {

    constructor() : super()
    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    override fun getLifecycleOwner(): LifecycleOwner = this

    /**
     * A wrapper function for Kotlin's lazy init.
     * inline with a reified type T so that we could pass T::class reference to ViewModel creation.
     *
     * The factory argument is a function returning a ViewModelProcider.Factory. The noinline keyword means that this
     * parameters will not be inlined. This results in the following syntax:
     * |    MyViewModel as T     |  lazy wrapper  | factory lambda written outside of the function |
     * val viewModel: MyViewModel by lazyViewModel { ViewModelFactory() }
     */
    inline fun <reified T : ViewModel> lazyViewModel(noinline factory: () -> ViewModelProvider.Factory) = lazy {
        createViewModel(this, factory.invoke(), T::class)
    }

    /**
     * Same as lazyViewModel, but automatically uses Activity as the ViewModelStoreOwner.
     * Convenience function when we want to share Activity level ViewModels between Fragments
     */
    inline fun <reified T : ViewModel> lazyActivityViewModel(noinline factory: () -> ViewModelProvider.Factory) = lazy {
        createViewModel(this.requireActivity(), factory.invoke(), T::class)
    }
}
