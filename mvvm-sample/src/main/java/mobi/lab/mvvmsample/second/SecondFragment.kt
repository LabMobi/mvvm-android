package mobi.lab.mvvmsample.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateViewModelFactory
import mobi.lab.mvvm.MvvmFragment
import mobi.lab.mvvmsample.App
import mobi.lab.mvvmsample.R
import mobi.lab.mvvmsample.databinding.FragmentSecondBinding

class SecondFragment : MvvmFragment(R.layout.fragment_second) {

    override val viewModel: SecondViewModel by viewModels {
        SavedStateViewModelFactory(App.instance, this)
    }

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            buttonConfirm.setOnClickListener { viewModel.onConfirmClicked() }
            checkboxChoice.setOnCheckedChangeListener { _: CompoundButton, isChecked: Boolean -> viewModel.onCheckedChanged(isChecked) }
        }
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.checked.onEachNotNull { binding.checkboxChoice.isChecked = it }
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
