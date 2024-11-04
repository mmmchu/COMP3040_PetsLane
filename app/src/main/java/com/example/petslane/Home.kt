package com.example.petslane

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class Home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Find buttons
        val myPetsButton: LinearLayout = view.findViewById(R.id.mypets)
        val schedulesButton: LinearLayout = view.findViewById(R.id.schedules)
        val mealPlansButton: LinearLayout = view.findViewById(R.id.mealplans)
        val trainingSourceButton: LinearLayout = view.findViewById(R.id.trainingsource)
        val uploadImageButton: LinearLayout = view.findViewById(R.id.uploadimage)

        // Set up button click listeners
        myPetsButton.setOnClickListener {
             // Replace with actual fragment
        }
        schedulesButton.setOnClickListener {
            // Replace with actual fragment
        }
        mealPlansButton.setOnClickListener {
           // Replace with actual fragment
        }
        trainingSourceButton.setOnClickListener {
            (activity as MainActivity).loadFragment(Trainingresources()) // Replace with actual fragment
        }
        uploadImageButton.setOnClickListener {
            // Replace with actual fragment
        }

        return view
    }
}
