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
    implementation "mobi.lab.mvvm:mvvm-lib:1.0.0-release@aar"
}
```

This assumes 2 things:
* The version is `1.0.0`
* The main application module has a `libs/` directory that contains the `mvvm-1.0.0-release.aar` artefact.
