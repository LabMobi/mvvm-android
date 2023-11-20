# Changelog for Mobi Lab MVVM

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/). This project does not use semantic versioning.

## 3.0.0 - 2023.11.20

### Changed

- `LiveData.onEachEvent` block expects a Boolean result value. This will control whether the event is marked as handled or not. This is useful when the event is received in a state where the action can't be handled. 

## 2.1.0 - 2023.07.25

### Added

- Added extension functions to `MvvmExtensions.kt` file to be able to pass in SavedStateHandle to ViewModelFactories.

## 2.0.8 - 2021.10.24

### Changed

- Renamed Event to SingleEvent. Event name tends to clash with various classes in projects.

## 2.0.7 - 2021.04.14

### Removed

- Removed MvvmActivity, MvvmFragment and MvvmDialogFragment classes to discourage unnecessary inheritance.

## 2.0.6 - 2021.04.14

### Changed

- Changed min sdk from 21 to 19

## 2.0.5 - 2021.02.08

### Added

- Added MvvmDialogFragment implementation

## 2.0.4 - 2020.11.23

### Added

- Added equals() and hashCode() implementations to Event class

## 2.0.3 - 2020.06.03

### Removed

- Removed lazy wrapper functions for creating ViewModels. They are already implemented in androidx.fragment:fragment-ktx package.

## 2.0.2 - 2020.06.01

### Removed

- Removed MvvmViewModel class

## 2.0.1 - 2020.05.29

### Changed

- Made lazy wrapper functions protected withing MvvmActivity and MvvmFragment

## 2.0.0 - 2020.05.29

### Added

- Added convenient lazy wrapper functions to easily create ViewModels

### Changed

- Moved LiveData extensions into a reusable interface

### Removed

- Removed generics from MvvmActivity and MvvmFragment
