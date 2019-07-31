package ${packageName}

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import kotlin.reflect.KClass
import mobi.lab.mvvm.MvvmFragment

class ${className}Fragment : MvvmFragment<${className}ViewModel>() {

    override val vmClass: KClass<${className}ViewModel> = ${className}ViewModel::class

    override fun provideViewModelFactory(): ViewModelProvider.Factory {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_, container, false)
    }

    companion object {
        fun newInstance(): ${className}Fragment {
            return ${className}Fragment()
        }
    }
}
