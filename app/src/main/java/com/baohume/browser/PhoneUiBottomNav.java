package com.baohume.browser;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
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
        mNavigationBarPhoneBottom.setTitleBar(this.getTitleBar());
        mNavigationBarPhoneBottom.setTabControll(this.mTabControl);
        mNavigationBarPhoneBottom.setUiController(this.mUiController);
        mNavigationBarPhoneBottom.setBaseUi(this);
    }

    @Override
    public void onConfigurationChanged(Configuration config) {
        super.onConfigurationChanged(config);
        //屏幕切换时隐藏／显示底部导航
        if(config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            mNavigationBarPhoneBottom.setVisibility(View.GONE);
        } else {
            mNavigationBarPhoneBottom.setVisibility(View.VISIBLE);
        }
    }
}
