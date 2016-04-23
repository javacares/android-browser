package com.baohume.browser;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by qijianbin on 16/4/24.
 */
public class PhoneUiBottomNav extends PhoneUi {

    private NavigationBarPhoneBottom mNavigationBarPhoneBottom;
    /**
     * @param browser
     * @param controller
     */
    public PhoneUiBottomNav(Activity browser, UiController controller) {
        super(browser, controller);
        FrameLayout parent = (FrameLayout)mContentView.getParent().getParent();
        mNavigationBarPhoneBottom = (NavigationBarPhoneBottom)parent.findViewById(R.id.screen_bottom_nav);
    }

}
