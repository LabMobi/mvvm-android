package mobi.lab.mvvm

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel

abstract class MvvmActivity : AppCompatActivity, MvvmLiveDataExtensions {

    protected abstract val viewModel: ViewModel

    constructor() : super()
    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    override fun getLifecycleOwner(): LifecycleOwner = this
}
