package mobi.lab.mvvm

import androidx.fragment.app.DialogFragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel

abstract class MvvmDialogFragment : DialogFragment(), MvvmLiveDataExtensions {

    protected abstract val viewModel: ViewModel

    override fun getLifecycleOwner(): LifecycleOwner = this
}
