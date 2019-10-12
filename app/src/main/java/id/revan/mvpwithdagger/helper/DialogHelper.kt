package id.revan.mvpwithdagger.helper

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import javax.inject.Inject

class DialogHelper @Inject constructor(val uiHelper: UIHelper) : AnkoLogger {
    fun showDialog() {
        uiHelper.showAlert()
        info("show dialog")
    }
}