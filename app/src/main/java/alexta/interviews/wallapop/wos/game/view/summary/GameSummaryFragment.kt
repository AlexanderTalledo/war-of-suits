package alexta.interviews.wallapop.wos.game.view.summary

import alexta.interviews.wallapop.core.game.domain.GameSummary
import alexta.interviews.wallapop.wos.R
import alexta.interviews.wallapop.wos.databinding.FragmentGameSummaryBinding
import alexta.interviews.wallapop.wos.game.viewmodel.summary.GameSummaryOperation
import alexta.interviews.wallapop.wos.game.viewmodel.summary.GameSummaryViewModel
import alexta.interviews.wallapop.wos.shared.framework.fragments.ViewBindingFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class GameSummaryFragment : ViewBindingFragment<FragmentGameSummaryBinding>() {

    @Inject
    lateinit var viewModel: GameSummaryViewModel

    @Inject
    lateinit var summaryAdapter: GameSummaryAdapter

    override var viewBinding: FragmentGameSummaryBinding? = null

    private val args: GameSummaryFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gameSummary()
    }

    private fun gameSummary() {
        viewModel.gameSummary(args.gameId)
    }

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
        initGameSummaryRecyclerView()
    }

    private fun initGameSummaryRecyclerView() = viewBinding?.run {
        with(gameSummaryRecyclerView) {
            setHasFixedSize(true)
            adapter = summaryAdapter
            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
                    setDrawable(
                        ContextCompat.getDrawable(context, R.drawable.divider_game_summary)!!
                    )
                }
            )
        }
    }

    override fun initObservers() {
        viewModel.operation.observe(this, { operation ->
            when (operation) {
                is GameSummaryOperation.OnGameSummary -> setGameSummary(operation.summary)
            }
        })
    }

    private fun setGameSummary(summary: GameSummary) = with(summary.toGameSummaryView()) {
        setGameSummaryWinner(winner)
        setGameSummaryRecyclerViewAdapter(items)
    }

    private fun setGameSummaryWinner(winner: GameSummaryWinnerView) = viewBinding?.run {
        gameSummaryWinnerName.text = winner.name(requireContext())
    }

    private fun setGameSummaryRecyclerViewAdapter(items: List<GameSummaryItemView>) {
        summaryAdapter.items = items
    }

}