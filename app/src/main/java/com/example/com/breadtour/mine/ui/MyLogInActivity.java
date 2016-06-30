package com.example.com.breadtour.mine.ui;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.com.breadtour.R;
import com.example.com.breadtour.mine.LogeIn_interfaces.EmailLoginActivity;
import com.example.com.breadtour.mine.LogeIn_interfaces.MobileLoginActivity;
import com.example.com.breadtour.mine.LogeIn_interfaces.Register_AccountsActivity;
import com.example.com.breadtour.mine.LogeIn_interfaces.SinaLoginActivity;
import com.example.com.breadtour.mine.LogeIn_interfaces.WeixinLoginActivity;
import com.example.com.breadtour.mine.LogeIn_interfaces.qqLoginActivity;
import com.example.com.breadtour.utils.ui.BaseActivity;

public class MyLogInActivity extends BaseActivity implements View.OnClickListener{
    private ImageView image_back;
    private ImageView im_login_wx_normal;
    private ImageView im_login_sina_normal;
    private ImageView im_login_qq_normal;
    private Button btn_mobile_login;
    private Button btn_email_login;
    private TextView forget_password;
    private TextView register_accounts;

    private  LayoutInflater mInflater;

    @Override
    protected int getLayout() {
        return R.layout.activity_my_log_in;

    }

    @Override
    protected void initView() {
        image_back = (ImageView) findViewById(R.id.image_back);
        im_login_wx_normal = (ImageView) findViewById(R.id.im_login_wx_normal);
        im_login_sina_normal = (ImageView) findViewById(R.id.im_login_sina_normal);
        im_login_qq_normal= (ImageView) findViewById(R.id.im_login_qq_normal);
        btn_mobile_login = (Button) findViewById(R.id.btn_mobile_login);
        btn_email_login = (Button) findViewById(R.id.btn_email_login);
        forget_password = (TextView) findViewById(R.id.forget_password);
        register_accounts = (TextView) findViewById(R.id.register_accounts);


        image_back.setOnClickListener(this);
        im_login_wx_normal.setOnClickListener(this);
        im_login_sina_normal.setOnClickListener(this);
        im_login_qq_normal.setOnClickListener(this);
        btn_mobile_login.setOnClickListener(this);
        btn_email_login.setOnClickListener(this);
        forget_password.setOnClickListener(this);
        register_accounts.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvents() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_back:
                MyLogInActivity.this.finish();
                break;
            case R.id.im_login_wx_normal:
                Intent intent = new Intent(MyLogInActivity.this, WeixinLoginActivity.class);
                startActivity(intent);
                break;
            case R.id.im_login_sina_normal:
                Intent intent2 = new Intent(MyLogInActivity.this, SinaLoginActivity.class);
                startActivity(intent2);
                break;
            case R.id.im_login_qq_normal:
                Intent intent3 = new Intent(MyLogInActivity.this, qqLoginActivity.class);
                startActivity(intent3);
                break;
            case R.id.btn_mobile_login:
                Intent intent4 = new Intent(MyLogInActivity.this, MobileLoginActivity.class);
                startActivity(intent4);
                break;
            case R.id.btn_email_login:
                Intent intent5 = new Intent(MyLogInActivity.this, EmailLoginActivity.class);
                startActivity(intent5);
                break;
            case R.id.register_accounts:
                Intent intent6 = new Intent(MyLogInActivity.this, Register_AccountsActivity.class);
                startActivity(intent6);
                break;
            case R.id.forget_password:
                AlertDialog musicDialog = new AlertDialog.Builder(MyLogInActivity.this, AlertDialog.BUTTON_POSITIVE).create();
                mInflater= LayoutInflater.from(MyLogInActivity.this);
                View layout = mInflater.inflate(R.layout.activity_forget_password, null);
                musicDialog.setView(layout);
                musicDialog.show();


        }

    }
}
