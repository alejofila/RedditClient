package com.example.alejofila.redditconsumer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.alejofila.redditconsumer.domain.model.PostDetail;
import com.example.alejofila.redditconsumer.presentation.view.MainActivity;
import com.example.alejofila.redditconsumer.presentation.view.PostDetailActivity;
import com.google.gson.Gson;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Instrumentation test, which will execute on an Android device.
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {



    private PostDetail postDetail;

    @Rule public ActivityTestRule<PostDetailActivity> activityTestRule = new ActivityTestRule<PostDetailActivity>(
            PostDetailActivity.class){
        @Override
        protected Intent getActivityIntent() {
            Intent intent = super.getActivityIntent();
            String jsonStr = FileTestUtils.readFileFromAssets("post_detail_payload_sample.json");
            postDetail = new Gson().fromJson(jsonStr, PostDetail.class);
            intent.putExtra(MainActivity.KEY_POST_DETAIL,postDetail);
            return intent;

        }
    };

    @Test
    public void checkForFields(){
        onView(withId(R.id.detail_post_title))
                .check(matches(withText(postDetail.getTitle())));

        onView(withId(R.id.detail_post_description))
                .check(matches(withText(postDetail.getDescription())));

        onView(withId(R.id.detail_post_subs))
                .check(matches(withText(containsString(""+postDetail.getSubscribers()))));
    }
    @Test
    public void rotateScreenAndCheckForFields(){

        rotateScreen();
        onView(withId(R.id.detail_post_title))
                .check(matches(withText(postDetail.getTitle())));

        onView(withId(R.id.detail_post_description))
                .check(matches(withText(postDetail.getDescription())));

        onView(withId(R.id.detail_post_subs))
                .check(matches(withText(containsString(""+postDetail.getSubscribers()))));

    }
    private void rotateScreen() {
        Context context = InstrumentationRegistry.getTargetContext();
        int orientation = context.getResources().getConfiguration().orientation;

        Activity activity = activityTestRule.getActivity();
        activity.setRequestedOrientation(
                (orientation == Configuration.ORIENTATION_PORTRAIT) ?
                        ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE : ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }



}
