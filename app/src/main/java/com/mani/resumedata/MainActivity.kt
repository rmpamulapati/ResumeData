package com.mani.resumedata

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.mani.resumedata.beans.ResponseModel
import com.mani.resumedata.managers.ContentManager
import com.mani.resumedata.model.PresenterImplementation
import com.mani.resumedata.network.NetWorkConnection
import com.mani.resumedata.view_presenter.ViewPresenter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import retrofit2.Response
import java.util.regex.Pattern

class MainActivity : AppCompatActivity(), ViewPresenter.MainView {

    var presenterImplementation: PresenterImplementation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenterImplementation = PresenterImplementation(this)
        submit_button.setOnClickListener {
            if (isValidEmail(input.getText().toString())) {
                /*----making the circular progressBar visible until the data gets populated----*/
                //progress_circular.setVisibility(ProgressBar.VISIBLE)
                presenterImplementation!!.loadData()

            } else {
                Toast.makeText(this@MainActivity, "Please enter valid email id...", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /* checks if it is valid email and returns true or false */
    fun isValidEmail(email: String): Boolean {
        val regex = "^(.+)@(.+)$"
        val pattern = Pattern.compile(regex)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenterImplementation?.onStop()
    }

    /* displays internet connection error */
    open override fun validateError() {
        Snackbar.make(rootLayout, "Please check your internet connection", Snackbar.LENGTH_SHORT)
            .setAction("OK", View.OnClickListener {  }).show()
    }

    override fun showProgressbar() {
        progress_circular.visibility = View.VISIBLE
    }

    override fun hideProgressbar() {
        progress_circular.visibility = View.GONE
    }

    override fun onSuccess(reposnseModel: Response<ResponseModel>) {
        if (reposnseModel.body() != null) {

            if (input.getText().toString().equals(reposnseModel.body()!!.email_id)) {

                hideProgressbar()
                submit_button.setText("Success")
                ContentManager().getInstance().resumeData = reposnseModel.body()
                startActivity(Intent( this@MainActivity, SummaryActivity::class.java))

            } else {
                hideProgressbar()
                Toast.makeText(this@MainActivity, "Incorrect email id...Please try again!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onError(throwable: Throwable) {
        toast("Something went wrong")
    }

    override fun checkInternet(): Boolean {
        return NetWorkConnection.isNetworkConnected(applicationContext)
    }
}
