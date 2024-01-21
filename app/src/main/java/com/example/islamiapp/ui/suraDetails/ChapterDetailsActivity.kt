package com.example.islamiapp.ui.suraDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.islamiapp.R
import com.example.islamiapp.databinding.ActivityChapterDetailsBinding
import com.example.islamiapp.ui.Constants

class ChapterDetailsActivity : AppCompatActivity() {

    var chapterIndex: Int = 0;
    lateinit var chapterTitle: String
    lateinit var viewBinding: ActivityChapterDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        setSupportActionBar(viewBinding.toolBar)

        chapterIndex = intent.getIntExtra(Constants.ChapterIndex, 0)
        chapterTitle = intent.getStringExtra(Constants.ChapterTitle) ?: ""

        initViews()
        readSuraFile()
    }

    private fun readSuraFile() {
        val inputStream = assets.open("$chapterIndex.txt")
        val fileContent = inputStream.bufferedReader().use { it.readText() }
        val lines = fileContent.trim().split("\n")
        initRecyclerView(lines)
    }

    private fun initRecyclerView(verses: List<String>) {
        val adapter = VersesRecyclerAdapter(verses)
        viewBinding.content.recyclerView.adapter = adapter
    }

    private fun initViews() {
        viewBinding.titleTv.text = chapterTitle
        setTitle(null)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

}