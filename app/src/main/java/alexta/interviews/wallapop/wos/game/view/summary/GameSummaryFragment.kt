package alexta.interviews.wallapop.wos.game.view.summary

import alexta.interviews.wallapop.wos.databinding.FragmentGameSummaryBinding
import alexta.interviews.wallapop.wos.shared.framework.fragments.ViewBindingFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameSummaryFragment : ViewBindingFragment<FragmentGameSummaryBinding>() {

    override var viewBinding: FragmentGameSummaryBinding? = null

    private val args: GameSummaryFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val attachToParent = false
        viewBinding = FragmentGameSummaryBinding.inflate(inflater, container, attachToParent)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun initViews() {
        Toast.makeText(context, args.gameId, Toast.LENGTH_SHORT).show()
    }

    override fun initObservers() {}

}