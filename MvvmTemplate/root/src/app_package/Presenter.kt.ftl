package ${packageName}

import mobi.lab.mvp.MvpPresenter

class ${className}Presenter(view: ${className}Contract.View, model: ${className}Contract.Model) :
        MvpPresenter<${className}Contract.View, ${className}Contract.Model, Any>(view, model),
        ${className}Contract.ModelPresenter,
        ${className}Contract.ViewPresenter {

    override fun subscribe(state: Any?) {
        // Nothing here currently
    }

    override fun unsubscribe() {
        // Nothing here currently
    }
}
