package mobi.lab.mvvm

import mobi.lab.mvvm.contracts.MvvmModelContract
import mobi.lab.mvvm.contracts.MvvmViewModelContract

/**
 * Mvvm base Model implementation
 */
abstract class MvvmModel<VM : MvvmViewModelContract> : MvvmModelContract {
    lateinit var viewModel: VM
}
