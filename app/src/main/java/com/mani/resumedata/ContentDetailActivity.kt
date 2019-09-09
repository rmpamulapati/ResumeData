package com.mani.resumedata

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.mani.resumedata.beans.ResponseModel
import com.mani.resumedata.managers.ContentManager


class ContentDetailActivity : AppCompatActivity() {

    private var selection: String? = null
    private lateinit var populateData: TextView
    private lateinit var toolbarTitle:TextView
    private lateinit var backButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        populateData = findViewById(R.id.data)
        toolbarTitle = findViewById(R.id.toolbar_title)
        backButton = findViewById(R.id.back_button)

        toolbarTitle.setText("Resume")

        selection = intent.getStringExtra("selection")

        /* the existing instance of manager gets the data to be displayed */
        ContentManager().getInstance().resumeData?.let { generateData(it) }

        backButton.setOnClickListener { super.onBackPressed() }
    }


    private fun generateData(resumeData: ResponseModel) {

        if (selection == "details") {
            toolbarTitle.text = "Details"
            populateData.setText(resumeData.details)
        } else if (selection == "profSummary") {
            toolbarTitle.text = "Summary"
            populateData.setText(resumeData.summary)
        } else if (selection == "techSkills") {
            toolbarTitle.text = "Technical Skills"
            populateData.setText(resumeData.technical_skills)
        } else if (selection == "workExp") {
            toolbarTitle.text = "Work Experience"
            populateData.setText(resumeData.work_history)
        } else {
            toolbarTitle.text = "Education"
            populateData.setText(resumeData.education)
        }
    }
}