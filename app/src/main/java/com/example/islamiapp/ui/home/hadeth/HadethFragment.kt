package com.example.islamiapp.ui.home.hadeth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamiapp.databinding.FragmentHadethBinding
import com.example.islamiapp.model.Hadeth
import com.example.islamiapp.ui.Constants
import com.example.islamiapp.ui.hadethDetails.HadethDetailsActivity

class HadethFragment:Fragment() {
    lateinit var viewBinding: FragmentHadethBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("HadethFragment", "onCreateView called")
        viewBinding = FragmentHadethBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    //Testing
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("HadethFragment", "onCreate called")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readHadethFile()
    }

    val hadethList = mutableListOf<Hadeth>()
    fun readHadethFile() {
        val inputStream = context?.assets?.open("ahadeeth.txt")
        val fileContent = inputStream?.bufferedReader().use {
            it?.readText()
        }
        val allAhadeth = fileContent?.trim()?.split("#")
        allAhadeth?.forEach { hadeth ->
            val lines = hadeth.trim().split("\n")
            val title = lines[0]
            val newList = lines.toMutableList().apply {
                removeAt(0)
            }
            val content = newList.joinToString("\n")
            val hadeth = Hadeth(title, content)
            hadethList.add(hadeth)
        }
        showHadethhList(hadethList)
    }

    private fun showHadethhList(hadethList: MutableList<Hadeth>) {
        val adapter = HadethRecyclerAdapter(hadethList)
        adapter.onItemClickListener = HadethRecyclerAdapter.OnItemClickListener { item, position ->
            startHadethDetailsScreen(item)
        }
        viewBinding.hadethRecycler.adapter = adapter
    }

    private fun startHadethDetailsScreen(hadeth: Hadeth) {
        val intent = Intent(activity, HadethDetailsActivity::class.java)
        intent.putExtra(Constants.Hadeth_EXTRA, hadeth)
        startActivity(intent)
    }
}