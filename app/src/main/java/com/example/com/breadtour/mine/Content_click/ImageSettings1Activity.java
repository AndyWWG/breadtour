package com.example.com.breadtour.mine.Content_click;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.com.breadtour.R;
import com.example.com.breadtour.mine.ui.minemainAcitvity;
import com.example.com.breadtour.utils.ui.BaseActivity;

public class ImageSettings1Activity extends BaseActivity implements View.OnClickListener{
    private ImageView userinfo_back_normal;

    @Override
    protected int getLayout() {
        return R.layout.activity_image_settings1;
    }

    @Override
    protected void initView() {
        userinfo_back_normal = (ImageView) findViewById(R.id.userinfo_back_normal);
        userinfo_back_normal.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvents() {

    }

    @Override
    public void onClick(View v) {
        ImageSettings1Activity.this.finish();
    }
}
