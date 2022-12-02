package jp.ac.it_college.std.s21014.pokemonquiz

import android.graphics.Bitmap
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultData(
    val yourAnswer: String,
    val correctAnswer: String,
    val pokemonImage: Bitmap
) : Parcelable

class ResultAdapter(
    private val listData: List<ResultData>
) : RecyclerView.Adapter<ResultAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvYourAnswerHolder: TextView
        val tvCorrectAnswerHolder: TextView
        val imgPokemon: ImageView
        val imgResult: ImageView

        init {
            tvYourAnswerHolder = view.findViewById(R.id.tvYourAnswerHolder)
            tvCorrectAnswerHolder = view.findViewById(R.id.tvCorrectAnswerHolder)
            imgPokemon = view.findViewById(R.id.imgPokemon)
            imgResult = view.findViewById(R.id.imgResult)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_result_content, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val yourAnswer = listData[position].yourAnswer
        val correctAnswer = listData[position].correctAnswer
        holder.tvYourAnswerHolder.text = yourAnswer
        holder.tvCorrectAnswerHolder.text = correctAnswer
        holder.imgPokemon.setImageBitmap(listData[position].pokemonImage)
        val resO = ResourcesCompat.getDrawable(holder.itemView.resources, R.drawable.mark_maru, null)
        val resX = ResourcesCompat.getDrawable(holder.itemView.resources, R.drawable.mark_batsu, null)
        holder.imgResult.setImageDrawable(if (yourAnswer == correctAnswer) resO else resX)
    }

    override fun getItemCount(): Int = listData.size
}