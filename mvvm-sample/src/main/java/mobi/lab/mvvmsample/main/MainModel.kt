package mobi.lab.mvvmsample.main

import mobi.lab.mvvm.MvvmModel


class MainModel : MvvmModel<MainContract.ViewModel>(), MainContract.Model {

    override fun loadItems() {
        // Sample logic here
        val error = false
        if (error) {
            viewModel::onLoadItemsError
        } else {
            viewModel::onLoadItemsSuccess
        }
    }

    override fun onDestroy() {
        // Cleanup any larger resources if needed
    }
}
