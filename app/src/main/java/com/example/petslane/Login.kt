package com.example.petslane

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login) // Load your login layout

        // Load the GIF into the ImageView
        val gifImageView: ImageView = findViewById(R.id.imageView3)
        Glide.with(this)
            .asGif()
            .load(R.drawable.cat) // Load the GIF
            .into(gifImageView) // Use the ImageView to display the GIF

        // Set up the login button click listener
        val loginButton: Button = findViewById(R.id.button)
        loginButton.setOnClickListener {
            // Start MainActivity after successful login
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Close LoginActivity
        }
    }
}
