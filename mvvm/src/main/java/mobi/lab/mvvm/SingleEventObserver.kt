package mobi.lab.mvvm

import androidx.lifecycle.Observer

/**
 * An [Observer] for [SingleEvent]s, simplifying the pattern of checking if the [SingleEvent]'s content has
 * already been handled.
 *
 * [onEventUnhandledContent] is *only* called if the [SingleEvent]'s contents has not been handled.
 */
public class SingleEventObserver<T>(private val unhandledContentObserver: (T) -> Boolean) : Observer<SingleEvent<T>> {
    override fun onChanged(event: SingleEvent<T>?) {
        if (event == null || event.hasBeenHandled) {
            return
        }

        if (unhandledContentObserver.invoke(event.peekContent())) {
            // Mark as handled
            event.getContentIfNotHandled()
        }
    }
}
