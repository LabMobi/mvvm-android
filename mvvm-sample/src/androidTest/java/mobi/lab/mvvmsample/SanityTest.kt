package mobi.lab.mvvmsample

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SanityTest {

    /**
     * This is how you run unit tests.
     * Feel free to remove this.
     */
    @Test
    @Throws(Exception::class)
    fun useAppContext() {
        // Context of the app under test

        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("mobi.lab.mvpsample", appContext.getPackageName())
    }
}
