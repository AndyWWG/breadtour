package com.example.com.breadtour.utils.ui;

import android.webkit.WebView;

import com.example.com.breadtour.R;

/**
 * Created by Administrator on 2016/6/28 0028.
 */
public class WebviewActivity extends BaseActivity {
    private  String url;
    private WebView mWebView;

    @Override
    protected int getLayout() {
        return R.layout.webview;
    }

    @Override
    protected void initView() {
        mWebView = (WebView) findViewById(R.id.find_webview);
    }

    @Override
    protected void initData() {
        url=getIntent().getStringExtra("url");
        mWebView.loadUrl(url);
    }

    @Override
    protected void initEvents() {

    }
}
