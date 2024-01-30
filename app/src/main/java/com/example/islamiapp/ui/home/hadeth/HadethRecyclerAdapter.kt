package com.example.islamiapp.ui.home.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.databinding.ItemChapterTitleBinding
import com.example.islamiapp.databinding.ItemHadethTitleBinding
import com.example.islamiapp.model.Hadeth

class HadethRecyclerAdapter(private val hadethList:List<Hadeth>):RecyclerView.Adapter<HadethRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding: ItemHadethTitleBinding =
            ItemHadethTitleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hadeth = hadethList[position]
        holder.bind(hadeth.title)
        onItemClickListener?.let {listener ->
            holder.itemView.setOnClickListener {
                listener.onItemClick(hadeth, position)
            }
        }
    }

    var onItemClickListener: OnItemClickListener? = null

    //interface only without fun you can't use lambda
    fun interface OnItemClickListener {
        fun onItemClick(item: Hadeth, position: Int)
    }

    override fun getItemCount(): Int = hadethList.size
    class ViewHolder(private val itemBinding: ItemHadethTitleBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(title: String) {
            itemBinding.title.text = title
        }
    }

}