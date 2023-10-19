# Mobi Lab MVVM library

Mobi Lab MVVM library (mvvm-android) is a library for using the MVVM architecture in your Android application.

## Adding the library to a project

Maven Central artifact available from https://central.sonatype.com/search?q=mobi.lab.mvvm

```groovy
implementation 'mobi.lab.mvvm:mvvm:x.y.z' // Check the latest version from Maven Central
```

## Library contents
The library the following elements:

1. `MvvmLiveDataExtensions` interface, `MvvmExtensions` extensions, and `SingleEvent` class. These provide convenience methods for handling LiveData contents and SingleEvent is used to handle actions only once.


## Creating ViewModels

ViewModels can be easily created by Kotlin extensions provided by `"androidx.fragment:fragment-ktx:<version"` dependency.


### Activity
```kotlin
class MyActivity : AppCompatActivity, MvvmLiveDataExtensions {
    // No factory
    private val viewModel: MainViewModel by viewModels()

    // Custom factory
    private val viewModel: MainViewModel by viewModels { myFactory }
}
```

### Fragment
```kotlin
class MyFragment : Fragment, MvvmLiveDataExtensions {
    // No factory
    private val viewModel: MainViewModel by viewModels()

    // Custom factory
    private val viewModel: MainViewModel by viewModels { myFactory }

    // Activity context ViewModel
    private val viewModel: MainViewModel by activityViewModels { myFactory }
    
     // MvvmLiveDataExtensions provides helpful extensions when working with LiveData and Event classes
    override fun getLifecycleOwner(): LifecycleOwner = this

    // Custom ViewModel instantiation with Mvvm's createViewModel() function
    private val viewModel: MainViewModel by lazy { ViewModelProvider(this, factory).get(MainViewModel::class.java) }
}
```
