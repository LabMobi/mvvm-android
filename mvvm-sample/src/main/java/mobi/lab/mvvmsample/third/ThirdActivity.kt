package mobi.lab.mvvmsample.third

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import mobi.lab.mvpsample.third.ThirdFragment
import mobi.lab.mvvmsample.R

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.generic)
        setupFragment(TAG_FRAGMENT_THIRD, ThirdFragment.newInstance())
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
        private const val TAG_FRAGMENT_THIRD = "mobi.lab.mvpsample.fragment_third.ThirdActivity.TAG_FRAGMENT_THIRD"
    }
}
