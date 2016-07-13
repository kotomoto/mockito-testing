package com.koto.mockitospyaddviewproblem;

import android.view.View;
import android.widget.FrameLayout;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class AddViewTest {
    @Test
    public void addViewToRealLayout() throws Exception {
        // given
        FrameLayout frameLayout = new FrameLayout(RuntimeEnvironment.application);

        // when
        frameLayout.addView(mock(View.class));

        // then
        Assert.assertEquals(1, frameLayout.getChildCount());
    }

    @Test
    public void addViewToSpyLayout() throws Exception {
        // given
        FrameLayout frameLayout = new FrameLayout(RuntimeEnvironment.application);
        FrameLayout spy = spy(frameLayout);

        // when
        spy.addView(mock(View.class));

        // then
        Assert.assertEquals(1, spy.getChildCount());
    }
}
