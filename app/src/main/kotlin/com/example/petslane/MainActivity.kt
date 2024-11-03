package com.example.petslane

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import android.widget.ImageButton
import android.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var sidebarButton: ImageButton
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find DrawerLayout and NavigationView
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)

        // Initialize the toolbar and sidebar button
        sidebarButton = findViewById(R.id.sidebar_button)
        sidebarButton.setOnClickListener {
            drawerLayout.openDrawer(androidx.core.view.GravityCompat.START)
        }

        // Set up NavigationView item click listener
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    // Handle Home navigation here if needed
                    true
                }
                R.id.UserProfile -> {
                    // Handle UserProfile navigation here if needed
                    true
                }
                R.id.about -> {
                    // Handle About navigation here if needed
                    true
                }
                R.id.settings -> {
                    // Handle Settings navigation here if needed
                    true
                }
                R.id.logout -> {
                    // Show confirmation dialog before logging out
                    showLogoutConfirmationDialog()
                    true
                }
                else -> false
            }
        }
    }

    private fun showLogoutConfirmationDialog() {
        // Create and show an AlertDialog to confirm log out
        AlertDialog.Builder(this)
            .setTitle("Log Out")
            .setMessage("Are you sure you want to exit the app?")
            .setPositiveButton("Yes") { dialog, _ ->
                // User confirmed, close the app
                dialog.dismiss()
                finishAffinity()
            }
            .setNegativeButton("No") { dialog, _ ->
                // User canceled, dismiss the dialog
                dialog.dismiss()
            }
            .create()
            .show()
    }
}
