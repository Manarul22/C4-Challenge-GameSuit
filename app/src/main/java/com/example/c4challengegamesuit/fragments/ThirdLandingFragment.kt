package com.example.c4challengegamesuit.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import com.example.c4challengegamesuit.R
import com.example.c4challengegamesuit.activities.MainMenuActivity

class ThirdLandingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third_landing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val next = view.findViewById<ImageView>(R.id.ivArrow)
        val editName = view.findViewById<EditText>(R.id.etName)

        next.setOnClickListener {
            val message = editName.text.toString()
            val intent = Intent(requireActivity(), MainMenuActivity::class.java)
            //putExtra
            intent.putExtra("name", message)
            startActivity(intent)

        }
    }

}