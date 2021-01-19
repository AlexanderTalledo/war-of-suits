package alexta.interviews.wallapop.wos.game.view.board

import alexta.interviews.wallapop.wos.databinding.FragmentGameBoardBinding
import alexta.interviews.wallapop.wos.shared.framework.fragments.ViewBindingFragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameBoardFragment : ViewBindingFragment<FragmentGameBoardBinding>() {

    private val args: GameBoardFragmentArgs by navArgs()

    override var viewBinding: FragmentGameBoardBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val attachToParent = false
        viewBinding = FragmentGameBoardBinding.inflate(inflater, container, attachToParent)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun initObservers() {}

    override fun initViews() {
        Log.e("AAAAAAAAAAAA", "Game ID: ${args.gameId}")
    }

}