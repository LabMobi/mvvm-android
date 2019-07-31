package mobi.lab.mvpsample.third

import android.util.Log
import mobi.lab.mvvm.MvvmViewModel
import javax.inject.Inject

class ThirdViewModel @Inject constructor(
    model: ThirdContract.Model,
    private val randomDependency: RandomDependency
) : MvvmViewModel<ThirdContract.Model>(model) {

    fun onResume() {
        Log.e("ThirdViewModel", "onResume dep=$randomDependency this=$this")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("ThirdViewModel", "onDestroy dep=$randomDependency")
    }
}
