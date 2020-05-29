package mobi.lab.mvvmsample.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.Toast
import androidx.lifecycle.SavedStateViewModelFactory
import kotlinx.android.synthetic.main.fragment_second.checkboxChoice
import mobi.lab.mvvm.MvvmFragment
import mobi.lab.mvvm.createViewModel
import mobi.lab.mvvmsample.App
import mobi.lab.mvvmsample.R

class SecondFragment : MvvmFragment(R.layout.fragment_second) {

    /**
     * Example of direct ViewModel creation with a custom Factory.
     * Surround with lazy {} to instantiate the ViewModel after the Fragment's lifecycle is in a proper state.
     * When using a direct call to createViewModel(), the ViewModel would be instantiated whenever our Fragment's constructor is called.
     */
    private val viewModel: SecondViewModel by lazy {
        createViewModel(this, SavedStateViewModelFactory(App.instance, this), SecondViewModel::class)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.buttonConfirm).setOnClickListener { viewModel.onConfirmClicked() }
        view.findViewById<CheckBox>(R.id.checkboxChoice)
                .setOnCheckedChangeListener { _: CompoundButton, isChecked: Boolean -> viewModel.onCheckedChanged(isChecked) }

        initViewModel()
    }

    private fun initViewModel() {
        viewModel.checked.onEachNotNull { checkboxChoice.isChecked = it }
        viewModel.action.onEachEvent { action ->
            when (action) {
                is SecondViewModel.Action.ShowConfirmCoolDialog -> showConfirmCoolDialog()
                is SecondViewModel.Action.ShowConfirmNotCoolDialog -> showConfirmNotCoolDialog()
            }
        }
    }

    private fun showConfirmCoolDialog() {
        Toast.makeText(activity, getString(R.string.text_cool), Toast.LENGTH_SHORT).show()
    }

    private fun showConfirmNotCoolDialog() {
        Toast.makeText(activity, getString(R.string.text_not_cool), Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun newInstance(): SecondFragment {
            return SecondFragment()
        }
    }
}
