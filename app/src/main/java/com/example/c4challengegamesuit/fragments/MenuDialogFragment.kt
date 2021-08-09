package com.example.c4challengegamesuit.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.c4challengegamesuit.R

class MenuDialogFragment : DialogFragment() {
    var name: String = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainLagi = view.findViewById<Button>(R.id.btnMainLagi)
        val kembaliKeMenu = view.findViewById<Button>(R.id.btnMenu)
        val hasilPermainan = view.findViewById<TextView>(R.id.tvHasilPermainan)

        hasilPermainan.text = name

        mainLagi.setOnClickListener {
            dismiss()
        }

        kembaliKeMenu.setOnClickListener {
            requireActivity().finish()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            MenuDialogFragment().apply {
                name = param1
            }
    }
}


