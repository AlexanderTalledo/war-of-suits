package alexta.interviews.wallapop.wos.game.view.splash

import alexta.interviews.wallapop.wos.databinding.FragmentGameSplashBinding
import alexta.interviews.wallapop.wos.game.viewmodel.splash.GameSplashOperation
import alexta.interviews.wallapop.wos.game.viewmodel.splash.GameSplashViewModel
import alexta.interviews.wallapop.wos.shared.framework.fragments.ViewBindingFragment
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class GameSplashFragment : ViewBindingFragment<FragmentGameSplashBinding>() {

    @Inject
    lateinit var viewModel: GameSplashViewModel

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
        initGameSplashStartTextView()
    }

    private fun initGameSplashScreenContainer() = viewBinding?.run {
        gameSplashScreenContainer.setOnClickListener { viewModel.createNewGame() }
    }

    private fun initGameSplashStartTextView() = viewBinding?.run {
        with(ObjectAnimator.ofFloat(gameSplashStartTextView, "alpha", .2f, 1f)) {
            duration = 1000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
            start()
        }
    }

    override fun initObservers() {
        viewModel.operation.observe(this, { operation ->
            when (operation) {
                is GameSplashOperation.OnGameCreated -> showGameBoardScreen(operation.gameId)
            }
        })
    }

    private fun showGameBoardScreen(gameId: String) {
        navigateTo(GameSplashFragmentDirections.actionGameSplashFragmentToGameBoardFragment(gameId))
    }

}