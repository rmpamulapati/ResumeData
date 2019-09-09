package com.mani.resumedata

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.runner.AndroidJUnit4
import android.util.Log

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import android.app.Activity
import android.support.test.rule.ActivityTestRule
import org.junit.Rule



/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.mani.resumedata", appContext.packageName)
    }

    /*@Test
    fun login_success() {
        Log.e("@Test", "Performing login success test")

        var firstActivity: IntentsTestRule<MainActivity> = IntentsTestRule(MainActivity::class.java)
        firstActivity.launchActivity(Intent())

        Espresso.onView((withId(R.id.input)))
            .perform(ViewActions.typeText("hello@123.com"))

        Espresso.onView(withId(R.id.validate_button))
            .perform(ViewActions.click())
    }*/
}
