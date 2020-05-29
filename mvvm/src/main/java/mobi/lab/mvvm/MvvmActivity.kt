package mobi.lab.mvvm

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class MvvmActivity : AppCompatActivity, MvvmLiveDataExtensions {

    constructor() : super()
    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    override fun getLifecycleOwner(): LifecycleOwner = this

    inline fun <reified T : ViewModel> lazyViewModel(noinline factory: () -> ViewModelProvider.Factory) = lazy {
        createViewModel(this, factory.invoke(), T::class)
    }
}
