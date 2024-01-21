package com.example.islamiapp.ui.home.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.databinding.ItemChapterTitleBinding

class ChapterRecyclerAdapter(private val chapterList:List<String>):RecyclerView.Adapter<ChapterRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding: ItemChapterTitleBinding =
            ItemChapterTitleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = chapterList[position]
        holder.bind(title)
        onItemClickListener?.let {listener ->
            holder.itemView.setOnClickListener {
                listener.onItemClick(title, position)
            }
        }
    }

    var onItemClickListener: OnItemClickListener? = null

    //interface only without fun you can't use lambda
    fun interface OnItemClickListener {
        fun onItemClick(item: String, position: Int)
    }

    override fun getItemCount(): Int = chapterList.size
    class ViewHolder(private val itemBinding: ItemChapterTitleBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(title: String) {
            itemBinding.title.text = title
        }
    }

}