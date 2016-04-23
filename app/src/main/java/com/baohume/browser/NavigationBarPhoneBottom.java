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
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**
 * TODO: document your custom view class.
 */
public class NavigationBarPhoneBottom extends LinearLayout {

    private ImageButton mButtonBack;
    private ImageButton mButtonForward;

    public NavigationBarPhoneBottom(Context context) {
        super(context);
        init(null, 0);
    }

    public NavigationBarPhoneBottom(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public NavigationBarPhoneBottom(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        LayoutInflater factory = LayoutInflater.from(getContext());
        View view = factory.inflate(R.layout.view_phone_bottom_bar, this);
        mButtonBack = (ImageButton)view.findViewById(R.id.button_back);
        mButtonForward = (ImageButton)view.findViewById(R.id.button_forward);
    }



}
