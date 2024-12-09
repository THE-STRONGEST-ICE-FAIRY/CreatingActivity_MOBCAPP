package com.example.creatingactivity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        start()
    }

    private fun start() {
        val buttBack = findViewById<Button>(R.id.buttBack)

        buttBack.setOnClickListener {

            finish()
            Toast.makeText(this, "MainActivity.kt", Toast.LENGTH_SHORT).show()
        }

        val textName: TextView = findViewById(R.id.nameText)
        textName.text = intent.getStringExtra("name")

        val addressText: TextView = findViewById(R.id.addressText)
        addressText.text = intent.getStringExtra("address")

        val contactNoText: TextView = findViewById(R.id.contactNoText)
        contactNoText.text = intent.getStringExtra("contactNo")

        val emailText: TextView = findViewById(R.id.emailText)
        emailText.text = intent.getStringExtra("email")

        val birthdayText: TextView = findViewById(R.id.birthdayText)
        birthdayText.text = intent.getStringExtra("birthday")

        val ageText: TextView = findViewById(R.id.ageText)
        ageText.text = intent.getStringExtra("age")

        val birthplaceText: TextView = findViewById(R.id.birthplaceText)
        birthplaceText.text = intent.getStringExtra("birthplace")

        val citizenshipText: TextView = findViewById(R.id.citizenshipText)
        citizenshipText.text = intent.getStringExtra("citizenship")

        val civilStatusText: TextView = findViewById(R.id.civilStatusText)
        civilStatusText.text = intent.getStringExtra("civilStatus")

        val religionText: TextView = findViewById(R.id.religionText)
        religionText.text = intent.getStringExtra("religion")

        val fatherNameText: TextView = findViewById(R.id.fatherText)
        fatherNameText.text = intent.getStringExtra("fatherName")

        val fatherOccupationText: TextView = findViewById(R.id.fatherOccupationText)
        fatherOccupationText.text = intent.getStringExtra("fatherOccupation")

        val motherNameText: TextView = findViewById(R.id.motherText)
        motherNameText.text = intent.getStringExtra("motherName")

        val motherOccupationText: TextView = findViewById(R.id.motherOccupationText)
        motherOccupationText.text = intent.getStringExtra("motherOccupation")

// Educational Background
        val primaryText: TextView = findViewById(R.id.primaryText)
        primaryText.text = intent.getStringExtra("primary")

        val primaryYearText: TextView = findViewById(R.id.primaryYearText)
        primaryYearText.text = intent.getStringExtra("primaryYear")

        val secondaryText: TextView = findViewById(R.id.secondaryText)
        secondaryText.text = intent.getStringExtra("secondary")

        val secondaryYearText: TextView = findViewById(R.id.secondaryYearText)
        secondaryYearText.text = intent.getStringExtra("secondaryYear")

        val tertiaryText: TextView = findViewById(R.id.tertiaryText)
        tertiaryText.text = intent.getStringExtra("tertiary")

        val tertiaryYearText: TextView = findViewById(R.id.tertiaryYearText)
        tertiaryYearText.text = intent.getStringExtra("tertiaryYear")

// Emergency Contact
        val emergencyNameText: TextView = findViewById(R.id.emergencyContactNameText)
        emergencyNameText.text = intent.getStringExtra("emergencyContactName")

        val relationshipText: TextView = findViewById(R.id.emergencyContactRelationshipText)
        relationshipText.text = intent.getStringExtra("emergencyContactRelationship")

        val emergencyAddressText: TextView = findViewById(R.id.emergencyContactAddressText)
        emergencyAddressText.text = intent.getStringExtra("emergencyContactAddress")

        val emergencyContactNoText: TextView = findViewById(R.id.emergencyContactContactNoText)
        emergencyContactNoText.text = intent.getStringExtra("emergencyContactContactNo")
    }
}