package mobi.lab.mvvmsample.second

import mobi.lab.mvvm.MvvmModel


class SecondModel : MvvmModel<SecondContract.ViewModel>(), SecondContract.Model {

    override fun onDestroy() {
        // Cleanup any larger resources if needed
    }
}
