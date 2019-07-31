package mobi.lab.mvpsample.third

import android.util.Log
import mobi.lab.mvvm.MvvmModel
import javax.inject.Inject

class ThirdModel @Inject constructor(
    val randomDependency: RandomDependency
) : MvvmModel<ThirdContract.ViewModel>(), ThirdContract.Model {

    override fun onDestroy() {
        Log.e("ThirdModel", "onDestroy dep=$randomDependency")
        // TODO implement
    }
}
