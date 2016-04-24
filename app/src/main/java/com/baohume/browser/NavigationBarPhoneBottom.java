package com.baohume.browser;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.baohume.browser.view.SettingMenuView;

/**
 * TODO: document your custom view class.
 */
public class NavigationBarPhoneBottom extends LinearLayout implements View.OnClickListener {

    private ImageButton mButtonBack;
    private ImageButton mButtonForward;
    private TitleBar titleBar;
    private ImageButton mButtonHome;
    private ImageButton mButtonSettings;
    private ImageButton mButtonWindow;
    private WebView mWebView;
    private TabControl tabControll;
    private UiController uiController;
    private PhoneUi phoneUi;

    public NavigationBarPhoneBottom(Context context) {
        super(context);
        init();
    }

    public NavigationBarPhoneBottom(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NavigationBarPhoneBottom(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        LayoutInflater factory = LayoutInflater.from(getContext());
        View view = factory.inflate(R.layout.view_phone_bottom_bar, this);
        mButtonBack = (ImageButton)view.findViewById(R.id.button_back);
        mButtonBack.setOnClickListener(this);
        mButtonForward = (ImageButton)view.findViewById(R.id.button_forward);
        mButtonForward.setOnClickListener(this);

        mButtonHome = (ImageButton)view.findViewById(R.id.button_home);
        mButtonHome.setOnClickListener(this);
        mButtonSettings = (ImageButton)view.findViewById(R.id.button_settings);
        mButtonSettings.setOnClickListener(this);
        mButtonWindow = (ImageButton)view.findViewById(R.id.button_navi);
        mButtonWindow.setOnClickListener(this);
    }

    public Tab getCurrentTab() {
        return tabControll.getCurrentTab();
    }

    public void setTitleBar(TitleBar titleBar) {
        this.titleBar = titleBar;
    }

    @Override
    public void onClick(View v) {
        mWebView = this.titleBar.getCurrentWebView();
        int id = v.getId();
        switch (id) {
            case R.id.button_back:
                getCurrentTab().goBack();
                break;
            case R.id.button_forward:
                getCurrentTab().goForward();
                if(mWebView.canGoForward()) {
                    mWebView.goForward();
                } else {
                    Toast.makeText(getContext(),"Can NOT forward again", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button_home:
                Tab current = tabControll.getCurrentTab();
                uiController.loadUrl(current, BrowserSettings.getInstance().getHomePage());
                break;
            case R.id.button_navi:
                this.phoneUi.toggleNavScreen();
                break;
            case R.id.button_settings:
                SettingMenuView menuView = new SettingMenuView();
                menuView.setUiController(uiController);
                menuView.show(uiController.getActivity().getSupportFragmentManager(),
                        "PhoneBottomNaiv", uiController);
                break;
        }
    }

    public void setTabControll(TabControl tabControll) {
        this.tabControll = tabControll;
    }

    public void setUiController(UiController uiController) {
        this.uiController = uiController;
    }

    public void setBaseUi(PhoneUi baseUi) {
        this.phoneUi = baseUi;
    }
}
