package com.example.islamiapp.ui.hadethDetails

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.islamiapp.R
import com.example.islamiapp.databinding.ActivityHadethDetailsBinding
import com.example.islamiapp.model.Hadeth
import com.example.islamiapp.ui.Constants

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding : ActivityHadethDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("HadethDetailsActivity", "onCreate called")
        viewBinding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        extractParams()
        initViews()
    }

    private fun initViews() {
        setTitle(null)
        setSupportActionBar(viewBinding.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        viewBinding.titleTv.text = hadeth?.title
        viewBinding.content.content.text = hadeth?.content
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    var hadeth: Hadeth? = null
    private fun extractParams() {
        //intent.getParcelableExtra(Constants.Hadeth_EXTRA , Hadeth::class.java)
        // -> requires API 33

        hadeth = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Constants.Hadeth_EXTRA, Hadeth::class.java)
        } else {
            intent.getParcelableExtra<Hadeth>(Constants.Hadeth_EXTRA)
            //don't take class and return object and cast it as hadeth
        }
        Log.d("HadethDetailsActivity", "Received Hadeth: $hadeth")
    }
}