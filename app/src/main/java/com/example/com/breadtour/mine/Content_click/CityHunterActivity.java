package com.example.com.breadtour.mine.Content_click;

import android.webkit.WebView;
import android.webkit.WebViewClient;

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


    }

    @Override
    protected void initEvents() {

        mWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                mUrl = getIntent().getStringExtra("url");
                view.loadUrl(mUrl);
//                view.getSettings().setJavaScriptEnabled(true);
                return true;
            }
        });

    }
}
