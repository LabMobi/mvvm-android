package ${packageName}

import mobi.lab.mvp.contracts.MvpModelContract
import mobi.lab.mvp.contracts.MvpModelPresenterContract
import mobi.lab.mvp.contracts.MvpViewContract
import mobi.lab.mvp.contracts.MvpViewPresenterContract

interface ${className}Contract {
    interface View : MvpViewContract

    interface ViewPresenter : MvpViewPresenterContract

    interface ModelPresenter : MvpModelPresenterContract

    interface Model : MvpModelContract
}
