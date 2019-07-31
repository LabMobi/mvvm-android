package mobi.lab.mvvmsample.second

import mobi.lab.mvvm.contracts.MvvmModelContract
import mobi.lab.mvvm.contracts.MvvmViewModelContract

interface SecondContract {
    interface ViewModel : MvvmViewModelContract
    interface Model : MvvmModelContract
}
