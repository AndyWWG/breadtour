package com.example.com.breadtour.mine.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.com.breadtour.R;
import com.example.com.breadtour.mine.Content_click.CityHunterActivity;
import com.example.com.breadtour.mine.Content_click.IcnCollectActivity;
import com.example.com.breadtour.mine.Content_click.IcnCouponActivity;
import com.example.com.breadtour.mine.Content_click.IcnEvaluateActivity;
import com.example.com.breadtour.mine.Content_click.IcnHelpActivity;
import com.example.com.breadtour.mine.Content_click.IcnInviteActivity;
import com.example.com.breadtour.mine.Content_click.IcnOrderActivity;
import com.example.com.breadtour.mine.Content_click.IcnPhoneActivity;
import com.example.com.breadtour.mine.Content_click.IcnStoryActivity;
import com.example.com.breadtour.mine.Content_click.ImageSettings1Activity;
import com.example.com.breadtour.mine.Content_click.MyConcernActivity;
import com.example.com.breadtour.mine.Content_click.MyIntegralActivity;
import com.example.com.breadtour.mine.Content_click.MyNameActivity;
import com.example.com.breadtour.mine.Content_click.My_ImageActivity;
import com.example.com.breadtour.mine.Content_click.TxtLvActivity;
import com.example.com.breadtour.mine.Content_click.WellLaiActivity;
import com.example.com.breadtour.utils.ui.BaseFragment;

/**
 * Created by Administrator on 2016/6/27 0027.
 */
public class minemainAcitvity extends BaseFragment implements View.OnClickListener {
    private TextView txt_city_hunter;
    private ImageView my_image;
    private ImageView image_settings_1;
    private TextView txtlv;
    private TextView my_name;
    private TextView my_concern;
    private TextView my_fans;
    private TextView my_integral;
    private LinearLayout icn_order;
    private LinearLayout icn_collect;
    private LinearLayout icn_coupon;
    private LinearLayout icn_evaluate;

    private LinearLayout icn_story;
    private LinearLayout icn_invite;
    private LinearLayout icn_phone;
    private LinearLayout icn_help;
    private TextView well_lai;

     String url = "http://web.breadtrip.com/m/club/join_city_hunter/";
    /**
     * 获取对应的布局文件
     *
     * @return
     */

    @Override
    protected int getLayout() {
        return R.layout.activity_minemain;

    }

    /**
     * 初始化控件
     */
    @Override
    protected void initView() {
        txt_city_hunter = (TextView) root.findViewById(R.id.txt_city_hunter);
        my_image = (ImageView) root.findViewById(R.id.my_image);
        image_settings_1 = (ImageView) root.findViewById(R.id.image_settings_1);
        txtlv = (TextView) root.findViewById(R.id.txtlv);
        my_name = (TextView) root.findViewById(R.id.my_name);
        my_concern = (TextView) root.findViewById(R.id.my_concern);
        my_fans = (TextView) root.findViewById(R.id.my_fans);
        my_integral = (TextView) root.findViewById(R.id.my_integral);

        icn_order = (LinearLayout) root.findViewById(R.id.icn_order);
        icn_collect = (LinearLayout) root.findViewById(R.id.icn_collect);
        icn_coupon = (LinearLayout) root.findViewById(R.id.icn_coupon);
        icn_evaluate = (LinearLayout) root.findViewById(R.id.icn_evaluate);

        icn_story = (LinearLayout) root.findViewById(R.id.icn_story);
        icn_invite=(LinearLayout) root.findViewById(R.id.icn_invite);
        icn_phone=(LinearLayout) root.findViewById(R.id.icn_phone);
        icn_help=(LinearLayout) root.findViewById(R.id.icn_help);
        well_lai = (TextView) root.findViewById(R.id.well_lai);


        txt_city_hunter.setOnClickListener(this);
        my_image.setOnClickListener(this);
        image_settings_1.setOnClickListener(this);
        txtlv.setOnClickListener(this);
        my_name.setOnClickListener(this);
        my_concern.setOnClickListener(this);
        my_fans.setOnClickListener(this);
        my_integral.setOnClickListener(this);

        icn_order.setOnClickListener(this);
        icn_collect.setOnClickListener(this);
        icn_coupon.setOnClickListener(this);
        icn_evaluate.setOnClickListener(this);
        icn_story.setOnClickListener(this);
        icn_invite.setOnClickListener(this);
        icn_phone.setOnClickListener(this);
        icn_help.setOnClickListener(this);
        well_lai.setOnClickListener(this);

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

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_city_hunter:
            Intent intent = new Intent(minemainAcitvity.this.getActivity(), CityHunterActivity.class);
            intent.putExtra("url",url);
                startActivity(intent);
                break;
            case R.id.my_image:
                Intent intent1 = new Intent(minemainAcitvity.this.getActivity(), My_ImageActivity.class);
                startActivity(intent1);
                break;
            case R.id.image_settings_1:
                Intent intent2 = new Intent(minemainAcitvity.this.getActivity(), ImageSettings1Activity.class);
                startActivity(intent2);
                break;
            case R.id.txtlv:
                Intent intent3 = new Intent(minemainAcitvity.this.getActivity(), TxtLvActivity.class);
                startActivity(intent3);
                break;
            case R.id.my_name:
                Intent intent4 = new Intent(minemainAcitvity.this.getActivity(), MyNameActivity.class);
                startActivity(intent4);
                break;
            case R.id.my_concern:
                Intent intent5 = new Intent(minemainAcitvity.this.getActivity(), MyConcernActivity.class);
                startActivity(intent5);
                break;
            case R.id.my_fans:
                Intent intent6 = new Intent(minemainAcitvity.this.getActivity(), MyConcernActivity.class);
                startActivity(intent6);
                break;
            case R.id.my_integral:
                Intent intent7 = new Intent(minemainAcitvity.this.getActivity(), MyIntegralActivity.class);
                startActivity(intent7);
                break;
            case R.id.icn_order:
                Intent intent8 = new Intent(minemainAcitvity.this.getActivity(), IcnOrderActivity.class);
                startActivity(intent8);
                break;
            case R.id.icn_collect:
                Intent intent9 = new Intent(minemainAcitvity.this.getActivity(), IcnCollectActivity.class);
                startActivity(intent9);
                break;
            case R.id.icn_coupon:
                Intent intent10 = new Intent(minemainAcitvity.this.getActivity(), IcnCouponActivity.class);
                startActivity(intent10);
                break;
            case R.id.icn_evaluate:
                Intent intent11 = new Intent(minemainAcitvity.this.getActivity(), IcnEvaluateActivity.class);
                startActivity(intent11);
                break;
            case R.id.icn_story:
                Intent intent12 = new Intent(minemainAcitvity.this.getActivity(), IcnStoryActivity.class);
                startActivity(intent12);
                break;
            case R.id.icn_invite:
                Intent intent13 = new Intent(minemainAcitvity.this.getActivity(), IcnInviteActivity.class);
                startActivity(intent13);
                break;
            case R.id.icn_phone:
                Intent intent14 = new Intent(minemainAcitvity.this.getActivity(), IcnPhoneActivity.class);
                startActivity(intent14);
                break;
            case R.id.icn_help:
                Intent intent15 = new Intent(minemainAcitvity.this.getActivity(), IcnHelpActivity.class);
                startActivity(intent15);
                break;
            case R.id.well_lai:
                Intent intent16 = new Intent(minemainAcitvity.this.getActivity(), WellLaiActivity.class);
                startActivity(intent16);
                break;
        }
    }
}
