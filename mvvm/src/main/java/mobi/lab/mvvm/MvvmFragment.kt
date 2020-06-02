package mobi.lab.mvvm

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel

abstract class MvvmFragment : Fragment, MvvmLiveDataExtensions {

    protected abstract val viewModel: ViewModel

    constructor() : super()
    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    override fun getLifecycleOwner(): LifecycleOwner = this
}
