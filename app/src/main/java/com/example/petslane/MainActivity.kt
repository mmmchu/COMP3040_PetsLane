package com.example.petslane

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import android.widget.ImageButton
import android.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment

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
            drawerLayout.openDrawer(GravityCompat.START)
        }

        // Load HomeFragment as the default fragment
        if (savedInstanceState == null) { // Ensure it's only loaded once
            loadFragment(home())
        }

        // Set up NavigationView item click listener
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    loadFragment(home())
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.UserProfile -> {
                    // Load UserProfileFragment here
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.about -> {
                    // Load AboutFragment here
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.settings -> {
                    // Load SettingsFragment here
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.logout -> {
                    showLogoutConfirmationDialog()
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        // Replace the existing fragment with the new fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun showLogoutConfirmationDialog() {
        // Create and show an AlertDialog to confirm log out
        AlertDialog.Builder(this)
            .setTitle("Log Out")
            .setMessage("Are you sure you want to exit the app?")
            .setPositiveButton("Yes") { dialog, _ ->
                dialog.dismiss()
                finishAffinity()
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }
}
