package com.example.com.breadtour;

import android.app.AlertDialog;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.example.com.breadtour.find.ui.findmainAcitvity;
import com.example.com.breadtour.meassage.ui.meassagemainAcitvity;
import com.example.com.breadtour.mine.ui.minemainAcitvity;
import com.example.com.breadtour.recomend.ui.recomendmainAcitvity;
import com.example.com.breadtour.utils.adapter.FragmentPageradapter2;
import com.example.com.breadtour.utils.ui.BaseActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {
    private RadioGroup mradioGroup;
    private LayoutInflater mInflater;
    FragmentTransaction transaction;
    private ViewPager viewPager;
    FragmentPageradapter2 FragmentPageradapter;
    private List<Fragment>  fragments;
    private Animation manimation;
    private ImageView mimageView;
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
     * 初始化控件
     */
    @Override
    protected void initView() {
        fragments=new ArrayList<>();
        fragments.add(new recomendmainAcitvity());
        fragments.add(new findmainAcitvity());
        fragments.add(new meassagemainAcitvity());
        fragments.add(new minemainAcitvity());
        viewPager= (ViewPager) findViewById(R.id.mianActivity_viewpager);
        mradioGroup= (RadioGroup) findViewById(R.id.activity_home_radiogroup);
        mimageView= (ImageView)findViewById(R.id.add);
        FragmentPageradapter=new FragmentPageradapter2(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(FragmentPageradapter);
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
                        Log.i("dddd","ddddddd");
                        break;
                    case R.id.activity_home_rb_single:
                        viewPager.setCurrentItem(1, true);
                        break;
                    case R.id.activity_home_rb_school:
                        viewPager.setCurrentItem(2, true);
                        break;
                    case R.id.activity_home_rb_mine:
                        viewPager.setCurrentItem(3, true);
                        break;
            }}
        });
        mimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.add_anim);
                manimation.setFillAfter(true);
                v.startAnimation(manimation);
                mInflater = LayoutInflater.from(MainActivity.this);
                View layout = mInflater.inflate(R.layout.activity_add, null);
                AlertDialog musicDialog = new AlertDialog.Builder(MainActivity.this, AlertDialog.BUTTON_POSITIVE).create();
                musicDialog.setView(layout);
                musicDialog.show();
            }
        });
    }

}
