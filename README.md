# MVVM-Kotlin library


## Using the Android Studio Template

To make your life a little easier, we have created a template for creating Activity, Fragment, Contract, ViewModel and Model classes for you.
Simply copy the ``MvvmTemplate`` folder to following directory:

```
{{ANDROID_STUDIO_LOCATION}/plugins/android/lib/templates/other/
```

On MacOs:

```
/Applications/Android Studio.app/Contents/plugins/android/lib/templates/other/
```

## Adding the library to a project

To add the library we need the `.aar` artefact. Either build it locally or take it from Nevercode's `mvvm-android` project.

##### Gradle

Add the following to your main application module's `build.gradle` file:

```
repositories {
   flatDir {
        dirs 'libs'
    }
}

dependencies {
    implementation "mobi.lab.mvvm:mvvm:2.0.0-release@aar"
}
```

This assumes 2 things:
* The version is `2.0.0`
* The main application module has a `libs/` directory that contains the `mvvm-2.0.0-release.aar` artefact.

## Library contents
The library contains 2 main elements:

1. MvvmLiveDataExtensions interface and Event class. These provide convenience methods for handling LiveData contents and
Event is used to handle actions only once.
2. MvvmActivity and MvvmFragment classes that implement MvvmLiveDataExtensions interface and require a `viewModel` member.


## Creating ViewModels

ViewModels can be easily created by Kotlin extensions provided by `"androidx.fragment:fragment-ktx:<version"` dependency.


### Activity
```
class MyActivity : MvvmActivity {
    // No factory
    private val viewModel: MainViewModel by viewModels()

    // Custom factory
    private val viewModel: MainViewModel by viewModels { myFactory }
}
```

### Fragment
```
class MyFragment : MvvmFragment {
    // No factory
    private val viewModel: MainViewModel by viewModels()

    // Custom factory
    private val viewModel: MainViewModel by viewModels { myFactory }

    // Activity context ViewModel
    private val viewModel: MainViewModel by activityViewModels { myFactory }
}
```

### Custom Fragment/Activity
```
class FragmentOrActivity : FragmentOrActivity(), MvvmLiveDataExtensions {
    // MvvmLiveDataExtensions provides helpful extensions when working with LiveData and Event classes
    override fun getLifecycleOwner(): LifecycleOwner = this

    // Custom ViewModel instantiation with Mvvm's createViewModel() function
    private val viewModel: MainViewModel by lazy { ViewModelProvider(this, factory).get(MainViewModel::class.java) }
}
```
