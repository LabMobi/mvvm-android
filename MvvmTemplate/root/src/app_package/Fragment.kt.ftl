package ${packageName}

import mobi.lab.mvvm.MvvmFragment

class ${className}Fragment : MvvmFragment(R.layout.fragment_${camelCaseToUnderscore(className)}) {

    private val viewModel: ${className}ViewModel by lazyViewModel { factory }

    companion object {
        fun newInstance(): ${className}Fragment {
            return ${className}Fragment()
        }
    }
}
