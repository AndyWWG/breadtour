package com.example.com.breadtour;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.com.breadtour.add.AddActivity;
import com.example.com.breadtour.find.ui.findmainAcitvity;
import com.example.com.breadtour.meassage.ui.meassagemainAcitvity;
import com.example.com.breadtour.mine.ui.MyLogInActivity;
import com.example.com.breadtour.mine.ui.minemainAcitvity;
import com.example.com.breadtour.recomend.ui.recomendmainAcitvity;
import com.example.com.breadtour.utils.adapter.FragmentPageradapter2;
import com.example.com.breadtour.utils.ui.BaseActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    private RadioGroup mradioGroup;
    private LayoutInflater mInflater;
    FragmentTransaction transaction;
    private ViewPager viewPager;
    FragmentPageradapter2 FragmentPageradapter;
    private List<Fragment> fragments;
    private Animation manimation;
    private ImageView mimageView;
    private ImageView mImageView;
    private ImageView mImageViewDialog;
    private Dialog mDialog;
    private int screenHeight;
    private LinearLayout mMian;
    private PopupWindow popupWindow;
    private RadioButton activity_home_rb_mine;
    private int mCount;


    /**
     * 获取对应的布局文件
     *
     * @return
     */
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    /**
     * 初始化控件MyLogInActivuty
     */
    @Override
    protected void initView() {
        mInflater = LayoutInflater.from(MainActivity.this);
        fragments = new ArrayList<>();
        fragments.add(new recomendmainAcitvity());
        fragments.add(new findmainAcitvity());
        fragments.add(new meassagemainAcitvity());
        fragments.add(new minemainAcitvity());
        viewPager = (ViewPager) findViewById(R.id.mianActivity_viewpager);
        mradioGroup = (RadioGroup) findViewById(R.id.activity_home_radiogroup);
        mimageView = (ImageView) findViewById(R.id.add);
        mImageView = (ImageView) findViewById(R.id.toolbar_edit);
        mImageViewDialog = (ImageView) findViewById(R.id.dialog_image);
        mMian = (LinearLayout) findViewById(R.id.main_layout);
        FragmentPageradapter = new FragmentPageradapter2(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(FragmentPageradapter);

        activity_home_rb_mine = (RadioButton) findViewById(R.id.activity_home_rb_mine);
        activity_home_rb_mine.setOnClickListener(this);
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

    }


    /**
     * 初始化事件
     */
    @Override
    protected void initEvents() {
        mradioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.activity_home_rb_homepage:
                        viewPager.setCurrentItem(0, true);
                        Log.i("dddd", "ddddddd");
                        break;
                    case R.id.activity_home_rb_single:
                        viewPager.setCurrentItem(1, true);
                        break;
                    case R.id.activity_home_rb_school:
                        viewPager.setCurrentItem(2, true);
                        break;
               /*     case R.id.activity_home_rb_mine:
                        viewPager.setCurrentItem(3, true);
                        break;
                        */
                }
            }
        });

        /**
         * 中间+的点击事件
         */
        mimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ObjectAnimator anim = ObjectAnimator.ofFloat(v, "rotation", 0.0f, 45.0f);
                anim.setDuration(200);
                anim.start();
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);

//                manimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.add_anim);
//                manimation.setFillAfter(true);
//                v.startAnimation(manimation);
//                AlertDialog musicDialog = new AlertDialog.Builder(MainActivity.this, AlertDialog.BUTTON_POSITIVE).create();
//                mInflater = LayoutInflater.from(MainActivity.this);
//                View layout = mInflater.inflate(R.layout.activity_add, null);
//                musicDialog.setView(layout);
//                musicDialog.show();
            }
        });


        /**
         * toolbar_edit的点击事件监听
         */
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(mMian, "scaleX", 1.0f, 0.9f);
                ObjectAnimator anim2 = ObjectAnimator.ofFloat(mMian, "scaleY", 1.0f, 0.9f);
                anim.setDuration(200);
                anim2.setDuration(200);
                anim.start();
                anim2.start();
                showPopupWindow();
            }
        });
    }


    public void showPopupWindow() {
        screenHeight = getWindowManager().getDefaultDisplay().getHeight();
        View view = mInflater.inflate(R.layout.activity_subject, null);

        popupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, (int) (screenHeight * 0.85));
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setAnimationStyle(R.style.popWindow_animation);
        // 在底部显示
        popupWindow.showAtLocation(mMian, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                if (!popupWindow.isShowing()) {
                    ObjectAnimator anim = ObjectAnimator.ofFloat(mMian, "scaleX", 0.9f, 1.0f);
                    ObjectAnimator anim2 = ObjectAnimator.ofFloat(mMian, "scaleY", 0.9f, 1.0f);
                    anim.setDuration(200);
                    anim2.setDuration(200);
                    anim.start();
                    anim2.start();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_home_rb_mine:
                Intent intent = new Intent(MainActivity.this, MyLogInActivity.class);
                startActivity(intent);
                break;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        ++mCount;
        if (mCount == 1) {

        } else if (mCount >= 2) {
            ObjectAnimator anim = ObjectAnimator.ofFloat(mimageView, "rotation", 0.0f, 0.0f);
            anim.setDuration(500);
            anim.start();
        }
    }
}
