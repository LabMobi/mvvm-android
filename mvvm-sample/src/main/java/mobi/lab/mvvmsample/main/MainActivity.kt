package mobi.lab.mvvmsample.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import mobi.lab.mvvm.MvvmActivity
import mobi.lab.mvvmsample.R
import mobi.lab.mvvmsample.ViewModelFactory
import mobi.lab.mvvmsample.second.SecondActivity
import kotlin.reflect.KClass

class MainActivity : MvvmActivity<MainViewModel>() {

    override val vmClass: KClass<MainViewModel>
        get() = MainViewModel::class

    override fun provideViewModelFactory(): ViewModelProvider.Factory {
        return ViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        findViewById<View>(R.id.button).setOnClickListener { viewModel.onButtonClicked() }

        viewModel.action.onEachEvent { action ->
            if (action is MainViewModel.Action.OpenSecondScreen) {
                startActivity(Intent(this, SecondActivity::class.java))
            }
        }
    }
}
