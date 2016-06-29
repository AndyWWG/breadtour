package com.example.com.breadtour.meassage.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.ImageView;

import com.example.com.breadtour.MainActivity;
import com.example.com.breadtour.R;
import com.example.com.breadtour.meassage.adapter.adapter_list_carview;
import com.example.com.breadtour.utils.ui.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/27 0027.
 */
public class meassagemainAcitvity extends BaseFragment {
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerView mRecyclerView;
    private adapter_list_carview madapter_list1;
    private LayoutInflater mInflater;
    private List views;

    /**
     * 获取对应的布局文件
     *
     * @return
     */
    @Override
    protected int getLayout() {
        return R.layout.activity_messagemain;
    }

    /**
     * 初始化控件
     */
    @Override
    protected void initView() {
        mInflater = LayoutInflater.from(getContext());
        views = new ArrayList<>();
        ImageView view4 = (ImageView) mInflater.inflate(R.layout.item_reomend_viewpager, null);
        ImageView view1 = (ImageView) mInflater.inflate(R.layout.item_reomend_viewpager, null);
        ImageView view2 = (ImageView) mInflater.inflate(R.layout.item_reomend_viewpager, null);
        ImageView view3 = (ImageView) mInflater.inflate(R.layout.item_reomend_viewpager, null);
        ImageView view5 = (ImageView) mInflater.inflate(R.layout.item_reomend_viewpager, null);
        view1.setImageResource(R.mipmap.recomend_viewpager_1);
        view2.setImageResource(R.mipmap.recomend_viewpager_2);
        view3.setImageResource(R.mipmap.recomend_viewpager_3);
        view4.setImageResource(R.mipmap.recomend_viewpager_4);
        view5.setImageResource(R.mipmap.recomend_viewpager_5);
        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);
        views.add(view5);
        mRecyclerView = (RecyclerView) root.findViewById(R.id.messagemain_recyclerview);
        setlist2();
//        BDLocation mBDLocation=new BDLocation();
//
        ((MainActivity)(meassagemainAcitvity.this.getActivity())).mLocationClient.start();

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

    public void setlist2() {
        mLinearLayoutManager = new LinearLayoutManager(getActivity(), OrientationHelper.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        madapter_list1 = new adapter_list_carview(getContext(), views, 0);
        mRecyclerView.setAdapter(madapter_list1);
        madapter_list1.notifyDataSetChanged();
    }

}
