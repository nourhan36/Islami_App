package com.example.islamiapp.ui.home.tasbeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamiapp.databinding.FragmentTasbehBinding

class TasbehFragment : Fragment() {

    lateinit var viewBinding: FragmentTasbehBinding
    var dhikrPosition = 0
    var counter = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentTasbehBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    private val dhikr = listOf(
        "سبحان الله",
        "الحمدلله",
        "الله اكبر"
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.dhikrTv.text = dhikr[dhikrPosition]
        onSebhaClick()
    }

    private fun onSebhaClick() {
        viewBinding.sebhaBodyImg.setOnClickListener {
            viewBinding.sebhaBodyImg.rotation += (360 / 33).toFloat()
            if (counter < 33)
                counter++
            else {
                counter = 0
                dhikrPosition =
                    if (dhikrPosition < dhikr.size - 1) ++dhikrPosition else 0
                viewBinding.dhikrTv.text = dhikr[dhikrPosition]
            }
            viewBinding.counterTv.text = counter.toString()
        }
    }
}