package com.example.com.breadtour.utils.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.example.com.breadtour.MainActivity;
import com.example.com.breadtour.R;

public class WelcomeActivity extends BaseActivity {


    @Override
    protected int getLayout() {
        return R.layout.activity_welcome;
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                    WelcomeActivity.this.finish();
            }
        }
    };

    @Override
    protected void initView() {

        handler.sendEmptyMessageDelayed(0, 3000);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvents() {

    }
}
