package com.example.com.breadtour.mine.Content_click;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.com.breadtour.R;
import com.example.com.breadtour.utils.ui.BaseActivity;

public class CityHunterActivity extends BaseActivity {

    private String mUrl;
    private WebView mWebview;

    @Override
    protected int getLayout() {
        return R.layout.activity_city_hunter;
    }

    @Override
    protected void initView() {

        mWebview = (WebView) findViewById(R.id.id_become_hunter_webview);
    }

    @Override
    protected void initData() {

        mUrl = getIntent().getStringExtra("url");
        mWebview.loadUrl(mUrl);
    }

    @Override
    protected void initEvents() {

    }
}
