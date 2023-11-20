package mobi.lab.mvvmsample.second

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.SavedStateViewModelFactory
import mobi.lab.mvvm.MvvmLiveDataExtensions
import mobi.lab.mvvmsample.App
import mobi.lab.mvvmsample.R
import mobi.lab.mvvmsample.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second), MvvmLiveDataExtensions {

    private val viewModel: SecondViewModel by viewModels {
        SavedStateViewModelFactory(App.instance, this)
    }

    private var binding: FragmentSecondBinding? = null

    override fun getLifecycleOwner(): LifecycleOwner = this

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentSecondBinding.inflate(inflater, container, false)
        this.binding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            buttonConfirm.setOnClickListener { viewModel.onConfirmClicked() }
            checkboxChoice.setOnCheckedChangeListener { _: CompoundButton, isChecked: Boolean -> viewModel.onCheckedChanged(isChecked) }
        }
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.checked.onEachNotNull {
            binding?.apply {
                checkboxChoice.isChecked = it
            }
        }
        viewModel.action.onEachEvent { action ->
            val context = context
            if (context == null) {
                return@onEachEvent false
            }
            when (action) {
                is SecondViewModel.Action.ShowConfirmCoolDialog -> showConfirmCoolDialog(context)
                is SecondViewModel.Action.ShowConfirmNotCoolDialog -> showConfirmNotCoolDialog(context)
            }
            return@onEachEvent true
        }
    }

    private fun showConfirmCoolDialog(context: Context) {
        Toast.makeText(context, getString(R.string.text_cool), Toast.LENGTH_SHORT).show()
    }

    private fun showConfirmNotCoolDialog(context: Context) {
        Toast.makeText(context, getString(R.string.text_not_cool), Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun newInstance(): SecondFragment {
            return SecondFragment()
        }
    }
}
