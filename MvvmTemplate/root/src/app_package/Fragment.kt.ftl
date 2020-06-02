package ${packageName}

import androidx.fragment.app.viewModels
import mobi.lab.mvvm.MvvmFragment

class ${className}Fragment : MvvmFragment(R.layout.fragment_${camelCaseToUnderscore(className)}) {

    override val viewModel: ${className}ViewModel by viewModels { factory }

    companion object {
        fun newInstance(): ${className}Fragment {
            return ${className}Fragment()
        }
    }
}
