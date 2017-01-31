package com.example.unittesting;

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
        Assert.assertEquals(mainActivity.getString(R.string.main_textview_text), text);
    }
}
