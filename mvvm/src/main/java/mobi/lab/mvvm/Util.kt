package mobi.lab.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import kotlin.reflect.KClass

fun <T : ViewModel> createViewModel(owner: ViewModelStoreOwner, clazz: KClass<T>): T {
    return ViewModelProvider(owner).get(clazz.java)
}

fun <T : ViewModel> createViewModel(owner: ViewModelStoreOwner, factory: ViewModelProvider.Factory, clazz: KClass<T>): T {
    return ViewModelProvider(owner, factory).get(clazz.java)
}
