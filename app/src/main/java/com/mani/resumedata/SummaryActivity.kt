package com.mani.resumedata

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import android.widget.TextView



class SummaryActivity : AppCompatActivity() {

    private lateinit var contactDetails: TextView
    private lateinit var professionalSummary:TextView 
    private lateinit var technicalSkills:TextView 
    private lateinit var workExperience:TextView 
    private lateinit var educationalBackground:TextView
    private lateinit var toolbar: Toolbar
    private lateinit var toolbarTitle: TextView
    private lateinit var backButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        /*------------Initializations--------------*/
        contactDetails = findViewById(R.id.details)
        professionalSummary = findViewById(R.id.prof_summary)
        technicalSkills = findViewById(R.id.tech_skills)
        workExperience = findViewById(R.id.work_exp)
        educationalBackground = findViewById(R.id.edu_bg)
        toolbar = findViewById(R.id.toolbar)
        toolbarTitle = findViewById(R.id.toolbar_title)
        backButton = findViewById(R.id.back_button)

        /*Setting toolbar title*/
        toolbarTitle.text = getString(R.string.mani_resume)

        /* initialize onclick listeners */
        educationalBackground.setOnClickListener { showResumeContent("eduBackground") }
        contactDetails.setOnClickListener { showResumeContent("details") }
        professionalSummary.setOnClickListener { showResumeContent("profSummary") }
        technicalSkills.setOnClickListener { showResumeContent("techSkills") }
        workExperience.setOnClickListener { showResumeContent("workExp") }
        backButton.setOnClickListener { finish() }
    }

    private fun showResumeContent(contentType: String){
        intent = Intent( this@SummaryActivity, ContentDetailActivity::class.java)
        intent.putExtra("selection", contentType)
        startActivity(intent)
    }

}