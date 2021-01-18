package alexta.interviews.wallapop.wos.game.view.splash

import alexta.interviews.wallapop.wos.R
import alexta.interviews.wallapop.wos.databinding.FragmentGameSplashBinding
import alexta.interviews.wallapop.wos.shared.framework.fragments.ViewBindingFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class GameSplashFragment : ViewBindingFragment<FragmentGameSplashBinding>() {

    override var viewBinding: FragmentGameSplashBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val attachToParent = false
        viewBinding = FragmentGameSplashBinding.inflate(inflater, container, attachToParent)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun initViews() {
        initGameSplashScreenContainer()
    }

    private fun initGameSplashScreenContainer() = viewBinding?.run {
        gameSplashScreenContainer.setOnClickListener { showGameScreen() }
    }

    private fun showGameScreen() {
        navigateTo(R.id.actionGameSplashFragmentToGameBoardFragment)
    }

    override fun initObservers() {}

}