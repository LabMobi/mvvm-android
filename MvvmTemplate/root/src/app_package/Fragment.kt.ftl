package ${packageName}

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mobi.lab.mvp.MvpFragment

class ${className}Fragment : BaseMvpFragment<${className}Presenter, Any>(), ${className}Contract.View {

    override fun createPresenter(): ${className}Presenter {
        val model = ${className}Model()
        val presenter = ${className}Presenter(this, model)
        model.presenter = presenter
        return presenter
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
