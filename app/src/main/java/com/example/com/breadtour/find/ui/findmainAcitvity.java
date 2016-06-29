package com.example.com.breadtour.find.ui;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.com.breadtour.R;
import com.example.com.breadtour.find.adapter.FindRecyclerViewAdapter;
import com.example.com.breadtour.find.entity.meassagebean;
import com.example.com.breadtour.utils.other.OkHttpUtils;
import com.example.com.breadtour.utils.ui.BaseFragment;
import com.example.com.breadtour.utils.ui.WebviewActivity;
import com.google.gson.Gson;
import com.squareup.okhttp.Request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/27 0027.
 */
public class findmainAcitvity extends BaseFragment {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager manager;
    private FindRecyclerViewAdapter mAdapter;
    private List list;
    String url = "http://api.breadtrip.com/hunter/products/more/?start=0&lat=40.04806453249836&lng=116.29042647879027";

    /**
     * 获取对应的布局文件
     *
     * @return
     */
    @Override
    protected int getLayout() {
        return R.layout.activity_findmain;
    }

    /**
     * 初始化控件
     */
    @Override
    protected void initView() {

        mRecyclerView = (RecyclerView) root.findViewById(R.id.id_find_recyclerview);
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

        manager = new LinearLayoutManager(getActivity(), OrientationHelper.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new FindRecyclerViewAdapter();
        mAdapter.setOnRecyclerViewClickListener(new FindRecyclerViewAdapter.OnRecyclerViewClickListener() {


            @Override
            public void onItemClick(View view, meassagebean.ProductListBean meassagebean, int position) {
                Intent intent = new Intent(findmainAcitvity.this.getContext(), WebviewActivity.class);
                intent.putExtra("url", meassagebean.getUser().getAvatar_l());
                startActivity(intent);
            }
        });


        getDate();

    }

    /**
     * 初始化事件
     */
    @Override
    protected void initEvents() {


    }

    public void getDate() {
        OkHttpUtils.getAsync(url, new OkHttpUtils.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {
            }

            @Override
            public void requestSuccess(String result) {
                Gson gson = new Gson();
                meassagebean meassagebean = gson.fromJson(result, meassagebean.class);
                list = new ArrayList();
                list.addAll(meassagebean.getProduct_list());
                mAdapter.setSize(list);
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.setContext(findmainAcitvity.this.getContext());
                mAdapter.notifyDataSetChanged();

            }
        });
    }
}
