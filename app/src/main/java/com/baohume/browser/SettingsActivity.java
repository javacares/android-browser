package com.baohume.browser;

import android.view.MenuItem;

import com.baohume.browser.R;
import com.baohume.preference.AbstractPreferenceActivity;

/**
 * Created by qijianbin on 16/4/17.
 */
public class SettingsActivity extends AbstractPreferenceActivity {
    public static final String CURRENT_PAGE = "currentPage";

    @Override
    protected final void onCreatePreferenceHeaders() {
        addPreferenceHeadersFromResource(R.xml.preference_headers);
    }


}
