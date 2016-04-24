package com.baohume.browser.view;

import android.app.Dialog;
import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.TextView;

import com.baohume.browser.R;
import com.baohume.browser.UI;
import com.baohume.browser.UiController;


/**
 * Created by qijianbin on 16/4/24.
 */
public class SettingMenuView extends BottomSheetDialogFragment implements View.OnClickListener {
    TextView mBookmark;
    TextView mHistory;
    TextView mDownload;
    TextView mRefresh;
    TextView mSettings;
    TextView mShare;
    TextView mTools;
    TextView mQuit;

    UiController mUiController;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setContentView(R.layout.view_menu_settings);
        dialog.setCanceledOnTouchOutside(true);

        mBookmark = (TextView)dialog.findViewById(R.id.view_menu_setting_bookmark);
        mBookmark.setOnClickListener(this);

        mDownload = (TextView)dialog.findViewById(R.id.view_menu_setting_download);
        mDownload.setOnClickListener(this);

        mRefresh = (TextView)dialog.findViewById(R.id.view_menu_setting_refresh);
        mRefresh.setOnClickListener(this);

        mSettings = (TextView)dialog.findViewById(R.id.view_menu_setting_setting);
        mSettings.setOnClickListener(this);

        mShare = (TextView)dialog.findViewById(R.id.view_menu_setting_share);
        mShare.setOnClickListener(this);

        mTools = (TextView)dialog.findViewById(R.id.view_menu_setting_tools);
        mTools.setOnClickListener(this);

        mQuit = (TextView)dialog.findViewById(R.id.view_menu_setting_quit);
        mQuit.setOnClickListener(this);

        mHistory = (TextView)dialog.findViewById(R.id.view_menu_setting_history);
        mHistory.setOnClickListener(this);

        return dialog;
    }

    public void setUiController(UiController controller) {
        this.mUiController = controller;
    }

    public void show(FragmentManager manager, String tag, UiController controller) {
        this.mUiController = controller;
        super.show(manager, tag);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.view_menu_setting_bookmark:
                mUiController.bookmarkCurrentPage();
                break;
            case R.id.view_menu_setting_share:
                mUiController.shareCurrentPage();
                break;
            case R.id.view_menu_setting_history:
                mUiController.bookmarksOrHistoryPicker(UI.ComboViews.History);
                break;
            case R.id.view_menu_setting_refresh:
                mUiController.getCurrentTopWebView().reload();
                break;
            case R.id.view_menu_setting_setting:
                mUiController.openPreferences();
                break;
            case R.id.view_menu_setting_quit:
                mUiController.closeCurrentTab();
                mUiController.getActivity().finish();
                break;
            case R.id.view_menu_setting_download:
                viewDownloads();
                break;
        }
        dismiss();
    }


    /*
 * This method is called as a result of the user selecting the options
 * menu to see the download window. It shows the download window on top of
 * the current window.
 */
    void viewDownloads() {
        Intent intent = new Intent(DownloadManager.ACTION_VIEW_DOWNLOADS);
        getActivity().startActivity(intent);
    }
}
