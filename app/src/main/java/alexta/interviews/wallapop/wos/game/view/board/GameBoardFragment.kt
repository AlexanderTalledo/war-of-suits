package alexta.interviews.wallapop.wos.game.view.board

import alexta.interviews.wallapop.wos.databinding.FragmentGameBoardBinding
import alexta.interviews.wallapop.wos.game.viewmodel.board.GameBoardOperation
import alexta.interviews.wallapop.wos.game.viewmodel.board.GameBoardViewModel
import alexta.interviews.wallapop.wos.shared.framework.fragments.ViewBindingFragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class GameBoardFragment : ViewBindingFragment<FragmentGameBoardBinding>() {

    @Inject
    lateinit var viewModel: GameBoardViewModel

    override var viewBinding: FragmentGameBoardBinding? = null

    private val args: GameBoardFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startGame()
    }

    private fun startGame() {
        viewModel.startGame(args.gameId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val attachToParent = false
        viewBinding = FragmentGameBoardBinding.inflate(inflater, container, attachToParent)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun initViews() {

    }

    override fun initObservers() {
        viewModel.operation.observe(this, { operation ->
            when (operation) {
                is GameBoardOperation.OnGameStarted -> setGameBoard()
            }
        })
    }

    private fun setGameBoard() {
        Log.e("AAAAAAAAAAAA", "Game ID: ${args.gameId}")
    }

}