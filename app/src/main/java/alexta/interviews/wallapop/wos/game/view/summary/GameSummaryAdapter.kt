package alexta.interviews.wallapop.wos.game.view.summary

import alexta.interviews.wallapop.wos.R
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import javax.inject.Inject
import kotlin.properties.Delegates

class GameSummaryAdapter @Inject constructor() : RecyclerView.Adapter<GameSummaryViewHolder>() {

    internal var items: List<GameSummaryItemView> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = GameSummaryViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_game_summary, parent, false)
    )

    override fun onBindViewHolder(holder: GameSummaryViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

}