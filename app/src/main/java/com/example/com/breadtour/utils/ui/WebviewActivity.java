package com.example.com.breadtour.utils.ui;

import android.content.Intent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.example.com.breadtour.MainActivity;
import com.example.com.breadtour.R;

/**
 * Created by Administrator on 2016/6/28 0028.
 */
public class WebviewActivity extends BaseActivity {
    private String url;
    private WebView mWebView;
    private ImageView mImageView;
    private final String mURL = "http://web.breadtrip.com/hunter/";

    @Override
    protected int getLayout() {
        return R.layout.webview;
    }

    @Override
    protected void initView() {
        mWebView = (WebView) findViewById(R.id.find_webview);
        mImageView = (ImageView) findViewById(R.id.image_layout_back);
    }

    @Override
    protected void initData() {
        url = mURL + getIntent().getStringExtra("id").toString() + "/";
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl(url);

    }

    @Override
    protected void initEvents() {
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WebviewActivity.this, MainActivity.class));
                finish();
            }
        });

    }
}
