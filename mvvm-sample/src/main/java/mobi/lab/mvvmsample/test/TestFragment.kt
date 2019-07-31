package mobi.lab.mvvmsample.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import kotlin.reflect.KClass
import mobi.lab.mvvm.MvvmFragment

class TestFragment : MvvmFragment<TestViewModel>() {

    override val vmClass: KClass<TestViewModel>
        get() = TestViewModel::class

    override fun provideViewModelFactory(): ViewModelProvider.Factory {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_, container, false)
    }

    companion object {
        fun newInstance(): TestFragment {
            return TestFragment()
        }
    }
}
