package com.example.islamiapp.ui.suraDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.databinding.ItemChapterTitleBinding
import com.example.islamiapp.databinding.ItemVerseBinding

class VersesRecyclerAdapter(private val verses:List<String>):RecyclerView.Adapter<VersesRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding: ItemVerseBinding =
            ItemVerseBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = verses[position]
        holder.bind(title)
//        onItemClickListener?.let {listener ->
//            holder.itemView.setOnClickListener {
//                listener.onItemClick(title, position)
//            }
//        }
    }

    var onItemClickListener: OnItemClickListener? = null

    //interface only without fun you can't use lambda
    fun interface OnItemClickListener {
        fun onItemClick(item: String, position: Int)
    }

    override fun getItemCount(): Int = verses.size
    class ViewHolder(private val itemBinding: ItemVerseBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(title: String) {
            itemBinding.content.text = title
        }
    }

}