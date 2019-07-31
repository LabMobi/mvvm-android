package mobi.lab.mvvmsample.main

class MainModel {

    fun loadItems(success: () -> Unit, error: () -> Unit) {
        // Sample logic here
        val fail = false
        if (fail) {
            error.invoke()
        } else {
            success.invoke()
        }
    }
}
