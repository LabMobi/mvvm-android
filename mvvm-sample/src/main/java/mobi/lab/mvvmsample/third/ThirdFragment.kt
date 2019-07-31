package mobi.lab.mvpsample.third

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import mobi.lab.mvpsample.R
import mobi.lab.mvpsample.base.AppViewModelFactory
import mobi.lab.mvpsample.internal.di.Injector
import mobi.lab.mvvm.MvvmFragment
import javax.inject.Inject
import kotlin.reflect.KClass

class ThirdFragment : MvvmFragment<ThirdViewModel>() {

    @Inject lateinit var factory: AppViewModelFactory

    override val vmClass: KClass<ThirdViewModel> = ThirdViewModel::class
    override fun provideViewModelFactory(): ViewModelProvider.Factory = factory

    init {
        Injector.appComponent().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("ThirdFragment", "ThirdFragment created")
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    companion object {
        fun newInstance(): ThirdFragment {
            return ThirdFragment()
        }
    }
}
