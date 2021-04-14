package mobi.lab.mvvmsample.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import mobi.lab.mvvm.MvvmLiveDataExtensions
import mobi.lab.mvvmsample.R
import mobi.lab.mvvmsample.ViewModelFactory
import mobi.lab.mvvmsample.second.SecondActivity

class MainActivity : AppCompatActivity(R.layout.main), MvvmLiveDataExtensions {

    private val viewModel: MainViewModel by viewModels { ViewModelFactory() }

    override fun getLifecycleOwner(): LifecycleOwner = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<View>(R.id.button).setOnClickListener { viewModel.onButtonClicked() }

        viewModel.action.onEachEvent { action ->
            if (action is MainViewModel.Action.OpenSecondScreen) {
                startActivity(Intent(this, SecondActivity::class.java))
            }
        }
    }
}
