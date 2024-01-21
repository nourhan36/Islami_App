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

        chapterIndex = intent.getIntExtra(Constants.ChapterIndex, 0)
        chapterTitle = intent.getStringExtra(Constants.ChapterTitle) ?: ""

        initViews()
    }

    private fun initViews() {
        viewBinding.titleTv.text=chapterTitle
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}