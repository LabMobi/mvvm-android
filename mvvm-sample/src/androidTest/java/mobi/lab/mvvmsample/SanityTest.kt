package mobi.lab.mvvmsample

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
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
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("mobi.lab.mvvmsample", appContext.packageName)
    }
}
