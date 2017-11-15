package com.tddc73.lab1;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.Espresso.onView;
import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.Assert.*;

/**
 * Tests AccountRegistrationComponent
 */
@RunWith(AndroidJUnit4.class)
public class AccountRegistrationComponentTest {

    private String mFullNameToBeTyped;
    private String mUsernameToBeTyped;
    private String mEmailToBeTyped;
    private String mPasswordToBeTyped;



    @Rule
    public ActivityTestRule<Project> mActivityRule = new ActivityTestRule<>(
            Project.class);

    @Before
    public void initValidString() {
    }

    @Test
    public void enteringTexts_ShouldDisplayEnteredTexts() {
        mFullNameToBeTyped = "Andreas Touma";
        mUsernameToBeTyped = "MirroW";
        mEmailToBeTyped = "foo@bar.baz";
        mPasswordToBeTyped = "password123";

        onView(withId(R.id.fullnameET)).perform(typeText(mFullNameToBeTyped));
        onView(withId(R.id.fullnameET)).check(matches(withText(mFullNameToBeTyped)));
        onView(withId(R.id.usernameET)).perform(typeText(mUsernameToBeTyped));
        onView(withId(R.id.usernameET)).check(matches(withText(mUsernameToBeTyped)));
        onView(withId(R.id.emailET)).perform(typeText(mEmailToBeTyped));
        onView(withId(R.id.emailET)).check(matches(withText(mEmailToBeTyped)));
        onView(withId(R.id.editTextPassword)).perform(typeText(mPasswordToBeTyped));
        onView(withId(R.id.editTextPassword)).check(matches(withText(mPasswordToBeTyped)));
    }

    @Test
    public void enteringInvalidData_ShouldDisplayErrorWhenButtonPressed() {
        //This tests with the standard implementation of the component

        mFullNameToBeTyped = "Valid Name";
        mUsernameToBeTyped = "ValidUsername";
        mEmailToBeTyped = "invalid@email.com";
        mPasswordToBeTyped = "ValidPassword123";

        onView(withId(R.id.fullnameET)).perform(typeText(mFullNameToBeTyped));
        onView(withId(R.id.usernameET)).perform(typeText(mUsernameToBeTyped));
        onView(withId(R.id.emailET)).perform(typeText(mEmailToBeTyped));
        // Need to close soft keyboard to be able to perform the click below.
        onView(withId(R.id.editTextPassword)).perform(typeText(mPasswordToBeTyped), closeSoftKeyboard());


        onView(withId(R.id.createAccountButton)).perform(click());

        onView(withId(R.id.emailET)).check(matches(hasErrorText("Incorrect email!")));
    }
}
