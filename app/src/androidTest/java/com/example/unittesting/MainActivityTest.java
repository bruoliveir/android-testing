package com.example.unittesting;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mMainActivity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkDefaultText() {
        MainActivity mainActivity = mMainActivity.getActivity();
        TextView textView = (TextView) mainActivity.findViewById(R.id.main_textview);
        String text = textView.getText().toString();
        Assert.assertEquals(mainActivity.getString(R.string.main_textview_text_default), text);
    }

    @Test
    public void insertNameAndCheckMessage() {
        final String testName = "Bob";

        MainActivity mainActivity = mMainActivity.getActivity();

        Espresso.onView(ViewMatchers.withId(R.id.main_edittext))
                .perform(ViewActions.typeText(testName), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.main_button))
                .perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.main_textview))
                .check(ViewAssertions.matches(ViewMatchers.withText(
                        mainActivity.getString(R.string.main_textview_text, testName))));
    }
}
