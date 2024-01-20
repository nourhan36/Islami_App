package com.example.islamiapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.islamiapp.R
import com.example.islamiapp.databinding.ActivityMainBinding
import com.example.islamiapp.ui.home.hadeth.HadethFragment
import com.example.islamiapp.ui.home.quran.QuranFragment
import com.example.islamiapp.ui.home.radio.RadioFragment
import com.example.islamiapp.ui.home.tasbeh.TasbehFragment
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
    }

    private fun initViews() {
        viewBinding
            .content
            .bottomNav
            .setOnItemReselectedListener { item ->
            val fragment: Fragment = when (item.itemId) {
                R.id.navigation_quran -> {
                    QuranFragment()
                }

                R.id.navigation_hadeth -> {
                    HadethFragment()
                }

                R.id.navigation_sebha -> {
                    TasbehFragment()
                }

                R.id.navigation_radio -> {
                    RadioFragment()
                }

                else -> {
                    QuranFragment()
                }
            }
            pushFragment(fragment)
            true
        }

        viewBinding
            .content
            .bottomNav
            .selectedItemId = R.id.navigation_quran
    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}