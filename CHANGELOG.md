# Changelog

**Version 2.0.5**

Date: 08.02.2021

- Added MvvmDialogFragment implementation

**Version 2.0.4**

Date: 23.11.2020

- Added equals() and hashCode() implementations to Event class

**Version 2.0.3**

Date: 03.06.2020

- Removed lazy wrapper functions for creating ViewModels. They are already implemented in androidx.fragment:fragment-ktx package.

**Version 2.0.2**

Date: 01.06.2020

- Removed MvvmViewModel class

**Version 2.0.1**

Date: 29.05.2020

- Made lazy wrapper functions protected withing MvvmActivity and MvvmFragment

**Version 2.0.0**

Date: 29.05.2020

- Removed generics from MvvmActivity and MvvmFragment
- Moved LiveData extensions into a reusable interface
- Added convenient lazy wrapper functions to easily create ViewModels
