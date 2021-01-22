package alexta.interviews.wallapop.wos.application.view

import alexta.interviews.wallapop.wos.R
import alexta.interviews.wallapop.wos.shared.framework.activities.BaseActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ApplicationActivity : BaseActivity() {

    override fun layoutId() = R.layout.activity_application

    override fun onCreate(savedInstanceState: Bundle?) {
        setupFullScreen()
        super.onCreate(savedInstanceState)
    }

    private fun setupFullScreen() {
        hideApplicationTitle()
        hideStatusBar()
        setFullScreen()
    }

    private fun hideApplicationTitle() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
    }

    private fun hideStatusBar() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
    }

    private fun setFullScreen() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }

}