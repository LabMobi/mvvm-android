package mobi.lab.mvvmsample.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import mobi.lab.mvvm.MvvmActivity
import mobi.lab.mvvmsample.R
import mobi.lab.mvvmsample.ViewModelFactory
import mobi.lab.mvvmsample.second.SecondActivity

class MainActivity : MvvmActivity(R.layout.main) {

    private val viewModel: MainViewModel by lazyViewModel { ViewModelFactory() }

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
