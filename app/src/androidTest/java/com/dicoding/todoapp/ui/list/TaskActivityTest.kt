package com.dicoding.todoapp.ui.list

import android.view.KeyEvent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.matcher.ViewMatchers.Visibility.VISIBLE
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.dicoding.todoapp.R
import org.hamcrest.Matchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

//TODO 16 : Write UI test to validate when user tap Add Task (+), the AddTaskActivity displayed
@RunWith(AndroidJUnit4ClassRunner::class)
class TaskActivityTest {

    @Before
    fun setUp() {
        ActivityScenario.launch(TaskActivity::class.java)
    }

    @get:Rule
    val activityRule = ActivityScenarioRule(TaskActivity::class.java)

    @Test
    fun addTask() {
        onView(withId(R.id.fab)).perform(click())
        onView(withId(R.id.add_ed_title)).check(matches(isDisplayed()))
        onView(withId(R.id.add_ed_description)).check(matches(isDisplayed()))
        onView(withId(R.id.add_tv_due_date)).check(matches(isDisplayed()))
    }
}