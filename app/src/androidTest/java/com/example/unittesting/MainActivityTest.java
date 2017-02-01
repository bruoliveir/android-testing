package com.example.unittesting;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

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

        onView(withId(R.id.main_edittext))
                .perform(typeText(testName), closeSoftKeyboard());
        onView(withId(R.id.main_button))
                .perform(click());
        onView(withId(R.id.main_textview))
                .check(matches(withText(mainActivity.getString(R.string.main_textview_text, testName))));
    }
}
