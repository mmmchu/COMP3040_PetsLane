package com.example.petslane

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.widget.Toolbar
import android.view.View
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar: Toolbar
    private lateinit var sidebarButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find DrawerLayout
        drawerLayout = findViewById(R.id.drawer_layout)

        // Initialize the toolbar and sidebar button
        toolbar = findViewById(R.id.toolbar)
        sidebarButton = findViewById(R.id.sidebar_button)

        // Set the click listener for the sidebar button
        sidebarButton.setOnClickListener {
            // Open the navigation drawer when sidebar button is clicked
            drawerLayout.openDrawer(androidx.core.view.GravityCompat.START)
        }

        // Check if this is the first creation to load HomeFragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()) // Load HomeFragment
                .commit()
        }

    }
}