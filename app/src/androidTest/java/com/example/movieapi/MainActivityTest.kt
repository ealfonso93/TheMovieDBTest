package com.example.movieapi

import android.os.SystemClock
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.example.movieapi.ui.main.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun showsListLoadTest() {
        waitFor(5000)
        onView(withId(R.id.show_image))
        onView(withId(R.id.show_title))
        onView(withId(R.id.show_rating))
    }

    private fun waitFor(miliseconds: Long) {
        SystemClock.sleep(miliseconds)
    }
}