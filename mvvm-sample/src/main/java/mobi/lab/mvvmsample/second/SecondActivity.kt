package mobi.lab.mvvmsample.second

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import mobi.lab.mvvmsample.R

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.generic)
        setupFragment(TAG_FRAGMENT_SECOND, SecondFragment.newInstance())
    }

    private fun setupFragment(tag: String, fragmentInstance: Fragment) {
        if (supportFragmentManager.findFragmentByTag(tag) != null) {
            return
        }
        supportFragmentManager
                .beginTransaction()
                .add(R.id.layoutFragmentContainer, fragmentInstance, tag)
                .commit()
    }

    companion object {
        private const val TAG_FRAGMENT_SECOND = "mobi.lab.mvpsample.fragment_second.SecondActivity.TAG_FRAGMENT_SECOND"
    }
}
