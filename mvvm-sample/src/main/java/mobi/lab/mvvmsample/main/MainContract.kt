package mobi.lab.mvvmsample.main

import mobi.lab.mvvm.contracts.MvvmModelContract
import mobi.lab.mvvm.contracts.MvvmViewModelContract

interface MainContract {
    interface ViewModel : MvvmViewModelContract {
        fun onLoadItemsSuccess()
        fun onLoadItemsError()
    }

    interface Model : MvvmModelContract {
        fun loadItems()
    }
}
