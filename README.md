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
* The version is `1.0.0`
* The main application module has a `libs/` directory that contains the `mvvm-1.0.0-release.aar` artefact.

## Creating ViewModels

### Activity
```
class MyActivity : MvvmActivity {
    // Lazy init
    private val viewModel: MainViewModel by lazyViewModel { ViewModelFactory() }

    // Direct creation
    private val viewModel: MainViewModel = createViewModel(this, ViewModelFactory(), MyViewModel::class)
}
```

### Fragment
```
class MyFragment : MvvmFragment {
    // Lazy init
    private val viewModel: MainViewModel by lazyViewModel { ViewModelFactory() }

    // Lazy init with Activity context
    private val viewModel: MainViewModel by lazyActivityViewModel { ViewModelFactory() }

    // Direct creation
    private val viewModel: MainViewModel = createViewModel(this, ViewModelFactory(), MyViewModel::class)

    // Direct creation with Activity context. This is just for example purposes. requireActivity() will always throw at this stage as Activity reference is null.
    private val viewModel: MainViewModel = createViewModel(this.requireActivity(), ViewModelFactory(), MyViewModel::class)
}
```

### Custom Fragment/Activity
```
class FragmentOrActivity : FragmentOrActivity(), MvvmLiveDataExtensions {
    // MvvmLiveDataExtensions provides helpful extensions when working with LiveData and Event classes
    override fun getLifecycleOwner(): LifecycleOwner = this

    // Custom ViewModel instantiation with Mvvm's createViewModel() function
    private val viewModel: MainViewModel by lazy { createViewModel(this, ViewModelFactory(), MyViewModel::class) }
}
```
