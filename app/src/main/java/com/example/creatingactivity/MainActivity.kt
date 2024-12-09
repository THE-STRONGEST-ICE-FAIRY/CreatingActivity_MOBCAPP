package com.example.creatingactivity

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        start()
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            val view = currentFocus
            if (view is EditText) {
                val rect = Rect()
                view.getGlobalVisibleRect(rect)
                if (!rect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                    view.clearFocus()  // Clear focus if the touch is outside the EditText
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }

    private fun start() {
        val info = Info(
            personalInfo = Info.PersonalInfoForm(
                nameEditText = findViewById(R.id.nameEditText),
                addressEditText = findViewById(R.id.addressEditText),
                contactNoEditText = findViewById(R.id.contactNoEditText),
                emailEditText = findViewById(R.id.emailEditText),
                birthdayEditText = findViewById(R.id.birthdayEditText),
                ageEditText = findViewById(R.id.ageEditText),
                birthplaceEditText = findViewById(R.id.birthplaceEditText),
                citizenshipEditText = findViewById(R.id.citizenshipEditText),
                civilStatusEditText = findViewById(R.id.civilStatusEditText),
                religionEditText = findViewById(R.id.religionEditText),
                fatherNameEditText = findViewById(R.id.fatherNameEditText),
                fatherOccupationEditText = findViewById(R.id.fatherOccupationEditText),
                motherNameEditText = findViewById(R.id.motherNameEditText),
                motherOccupationEditText = findViewById(R.id.motherOccupationEditText)
            ),
            educationalBackground = Info.EducationalBackgroundForm(
                primaryYearEditText = findViewById(R.id.primaryYearEditText),
                primaryEditText = findViewById(R.id.primaryEditText),
                secondaryYearEditText = findViewById(R.id.secondaryYearEditText),
                secondaryEditText = findViewById(R.id.secondaryEditText),
                tertiaryEditText = findViewById(R.id.tertiaryEditText),
                tertiaryYearEditText = findViewById(R.id.tertiaryYearEditText)
            ),
            emergencyContact = Info.EmergencyContactForm(
                nameEditText = findViewById(R.id.emergencyContactNameEditText),
                relationshipEditText = findViewById(R.id.emergencyContactRelationshipEditText),
                addressEditText = findViewById(R.id.emergencyContactAddressEditText),
                contactNoEditText = findViewById(R.id.emergencyContactContactNoEditText)
            )
        )

        val buttDone = findViewById<Button>(R.id.buttDone)
        val buttClear = findViewById<Button>(R.id.buttClear)

        buttDone.setOnClickListener {

            if (checkEmpty(info)) {
                val personalInfo = info.personalInfo
                val educationalBackground = info.educationalBackground
                val emergencyContact = info.emergencyContact

                // Create an intent to pass data to SecondActivity
                val intent = Intent(this, SecondActivity::class.java)

                // Add the values as extras in the intent
                intent.putExtra("name", personalInfo.nameEditText.text.toString())
                intent.putExtra("address", personalInfo.addressEditText.text.toString())
                intent.putExtra("contactNo", personalInfo.contactNoEditText.text.toString())
                intent.putExtra("email", personalInfo.emailEditText.text.toString())
                intent.putExtra("birthday", personalInfo.birthdayEditText.text.toString())
                intent.putExtra("age", personalInfo.ageEditText.text.toString())
                intent.putExtra("birthplace", personalInfo.birthplaceEditText.text.toString())
                intent.putExtra("citizenship", personalInfo.citizenshipEditText.text.toString())
                intent.putExtra("civilStatus", personalInfo.civilStatusEditText.text.toString())
                intent.putExtra("religion", personalInfo.religionEditText.text.toString())
                intent.putExtra("fatherName", personalInfo.fatherNameEditText.text.toString())
                intent.putExtra("fatherOccupation", personalInfo.fatherOccupationEditText.text.toString())
                intent.putExtra("motherName", personalInfo.motherNameEditText.text.toString())
                intent.putExtra("motherOccupation", personalInfo.motherOccupationEditText.text.toString())

                intent.putExtra("primary", educationalBackground.primaryEditText.text.toString())
                intent.putExtra("primaryYear", educationalBackground.primaryYearEditText.text.toString())
                intent.putExtra("secondary", educationalBackground.secondaryEditText.text.toString())
                intent.putExtra("secondaryYear", educationalBackground.secondaryYearEditText.text.toString())
                intent.putExtra("tertiary", educationalBackground.tertiaryEditText.text.toString())
                intent.putExtra("tertiaryYear", educationalBackground.tertiaryYearEditText.text.toString())

                intent.putExtra("emergencyContactName", emergencyContact.nameEditText.text.toString())
                intent.putExtra("emergencyContactRelationship", emergencyContact.relationshipEditText.text.toString())
                intent.putExtra("emergencyContactAddress", emergencyContact.addressEditText.text.toString())
                intent.putExtra("emergencyContactContactNo", emergencyContact.contactNoEditText.text.toString())

                // Start SecondActivity
                startActivity(intent)
                Toast.makeText(this, "SecondActivity.kt", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "Fill out all fields before proceeding.", Toast.LENGTH_SHORT).show()
            }
        }

        buttClear.setOnClickListener {
            Toast.makeText(this, "All fields cleared.", Toast.LENGTH_SHORT).show()

            info.personalInfo.apply {
                nameEditText.setText("")
                addressEditText.setText("")
                contactNoEditText.setText("")
                emailEditText.setText("")
                birthdayEditText.setText("")
                ageEditText.setText("")
                birthplaceEditText.setText("")
                citizenshipEditText.setText("")
                civilStatusEditText.setText("")
                religionEditText.setText("")
                fatherNameEditText.setText("")
                fatherOccupationEditText.setText("")
                motherNameEditText.setText("")
                motherOccupationEditText.setText("")
            }

            info.educationalBackground.apply {
                primaryEditText.setText("")
                primaryYearEditText.setText("")
                secondaryEditText.setText("")
                secondaryYearEditText.setText("")
                tertiaryEditText.setText("")
                tertiaryYearEditText.setText("")
            }

            info.emergencyContact.apply {
                nameEditText.setText("")
                relationshipEditText.setText("")
                addressEditText.setText("")
                contactNoEditText.setText("")
            }
        }
    }

    private fun checkEmpty(info: Info): Boolean {
        val fields = listOf(
            info.personalInfo.nameEditText.text.toString(),
            info.personalInfo.addressEditText.text.toString(),
            info.personalInfo.contactNoEditText.text.toString(),
            info.personalInfo.emailEditText.text.toString(),
            info.personalInfo.birthdayEditText.text.toString(),
            info.personalInfo.ageEditText.text.toString(),
            info.personalInfo.birthplaceEditText.text.toString(),
            info.personalInfo.citizenshipEditText.text.toString(),
            info.personalInfo.civilStatusEditText.text.toString(),
            info.personalInfo.religionEditText.text.toString(),
            info.personalInfo.fatherNameEditText.text.toString(),
            info.personalInfo.fatherOccupationEditText.text.toString(),
            info.personalInfo.motherNameEditText.text.toString(),
            info.personalInfo.motherOccupationEditText.text.toString(),
            info.educationalBackground.primaryEditText.text.toString(),
            info.educationalBackground.primaryYearEditText.text.toString(),
            info.educationalBackground.secondaryEditText.text.toString(),
            info.educationalBackground.secondaryYearEditText.text.toString(),
            info.educationalBackground.tertiaryEditText.text.toString(),
            info.educationalBackground.tertiaryYearEditText.text.toString(),
            info.emergencyContact.nameEditText.text.toString(),
            info.emergencyContact.relationshipEditText.text.toString(),
            info.emergencyContact.addressEditText.text.toString(),
            info.emergencyContact.contactNoEditText.text.toString()
        )

        return fields.all { it.isNotBlank() }
    }
}