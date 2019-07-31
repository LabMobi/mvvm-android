package ${packageName}

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment

class ${className}Activity : BaseFragmentActivity() {

    override val tag: String
        get() = ${className}Fragment::class.java.name

    override fun createFragment(): Fragment {
        return ${className}Fragment.newInstance()
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, ${className}Activity::class.java)
        }
    }
}

