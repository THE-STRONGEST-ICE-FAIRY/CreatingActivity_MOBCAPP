package com.example.creatingactivity

import android.widget.EditText

class Info(
    val personalInfo: PersonalInfoForm,
    val educationalBackground: EducationalBackgroundForm,
    val emergencyContact: EmergencyContactForm
) {
    // Personal Information Form
    data class PersonalInfoForm(
        val nameEditText: EditText,
        val addressEditText: EditText,
        val contactNoEditText: EditText,
        val emailEditText: EditText,
        val birthdayEditText: EditText,
        val ageEditText: EditText,
        val birthplaceEditText: EditText,
        val citizenshipEditText: EditText,
        val civilStatusEditText: EditText,
        val religionEditText: EditText,
        val fatherNameEditText: EditText,
        val fatherOccupationEditText: EditText,
        val motherNameEditText: EditText,
        val motherOccupationEditText: EditText
    )

    // Educational Background Form
    data class EducationalBackgroundForm(
        val primaryEditText: EditText,
        val primaryYearEditText: EditText,
        val secondaryEditText: EditText,
        val secondaryYearEditText: EditText,
        val tertiaryEditText: EditText,
        val tertiaryYearEditText: EditText
    )

    // Emergency Contact Form
    data class EmergencyContactForm(
        val nameEditText: EditText,
        val relationshipEditText: EditText,
        val addressEditText: EditText,
        val contactNoEditText: EditText
    )
}