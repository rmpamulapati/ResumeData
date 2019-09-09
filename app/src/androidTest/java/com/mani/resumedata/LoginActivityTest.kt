
package com.mani.resumedata

import android.os.SystemClock
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.mani.resumedata.managers.ContentManager
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<MainActivity>(
        MainActivity::class.java
    )

    private val username = "manipamulapati@gmail.com"

    @Test
    fun clickLoginButton_opensLoginUi() {

        onView(withId(R.id.input)).perform(ViewActions.typeText(username), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.submit_button)).perform(ViewActions.click())


        SystemClock.sleep(3000);
        Assert.assertNotNull(ContentManager().getInstance().resumeData)
    }
}

