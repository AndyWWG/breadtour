package com.example.com.breadtour.mine.Content_click;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.com.breadtour.R;
import com.example.com.breadtour.utils.ui.BaseActivity;

public class IcnHelpActivity extends BaseActivity implements View.OnClickListener{
    private ImageView userinfo_back_normal_1;

    @Override
    protected int getLayout() {
        return R.layout.activity_icn_help;
    }

    @Override
    protected void initView() {
        userinfo_back_normal_1 = (ImageView) findViewById(R.id.userinfo_back_normal_1);
        userinfo_back_normal_1.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvents() {

    }

    @Override
    public void onClick(View v) {
        IcnHelpActivity.this.finish();
    }
}
