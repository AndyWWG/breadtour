package com.example.com.breadtour.recomend.ui;

import android.content.Intent;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.example.com.breadtour.R;
import com.example.com.breadtour.recomend.adapter.Adapter_viewpager;
import com.example.com.breadtour.recomend.adapter.adapter_list1;
import com.example.com.breadtour.recomend.adapter.adapter_list2;
import com.example.com.breadtour.recomend.adapter.adapter_list3;
import com.example.com.breadtour.recomend.adapter.adapter_list4;
import com.example.com.breadtour.recomend.adapter.adapter_list5;
import com.example.com.breadtour.recomend.adapter.adapter_list6;
import com.example.com.breadtour.recomend.adapter.adapter_viewpager_list2;
import com.example.com.breadtour.recomend.entity.ImageHandler;
import com.example.com.breadtour.recomend.entity.cityBean;
import com.example.com.breadtour.utils.other.OkHttpUtils;
import com.example.com.breadtour.utils.ui.BaseFragment;
import com.example.com.breadtour.utils.ui.WebviewActivity;
import com.google.gson.Gson;
import com.squareup.okhttp.Request;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/6/27 0027.
 */
public class recomendmainAcitvity extends BaseFragment {
    public ImageHandler handler = new ImageHandler(new WeakReference<recomendmainAcitvity>(this));
    public ViewPager mviewPager;
    private ArrayList<ImageView> views;
    private LayoutInflater mInflater;
    private Adapter_viewpager mAdapter_viewpager;
    private RadioGroup mradioGroup;
    private Intent mintent;
    private ListView listView1;
    private LinearLayoutManager mLinearLayoutManager, mLinearLayoutManager_2, mLinearLayoutManager_3, mLinearLayoutManager_4, mLinearLayoutManager_5, mLinearLayoutManager_6;
    private RecyclerView mRecyclerView, mRecyclerView_2, mRecyclerView_3, mRecyclerView_4, mRecyclerView_5, mRecyclerView_6;
    private adapter_list1 madapter_list1;
    private adapter_list2 madapter_list1_2;
    private adapter_list3 madapter_list1_3;
    private adapter_list4 madapter_list1_4;
    private adapter_list5 madapter_list1_5;
    private adapter_list6 madapter_list1_6;
    private View mView1, mView2;
    private List<View> mViewList2;
    private ViewPager mViewPager2;
    private List<cityBean.ProductListBean> ProductListBean1;
    private String url = "http://api.breadtrip.com/hunter/products/more/?start=0&city_name=%E5%8C%97%E4%BA%AC&lat=40.04806453249836&lng=116.29042647879027";
    private List<cityBean.ProductListBean> ProductListBean2;
    private List<cityBean.ProductListBean> ProductListBean3;

    /**
     * 获取对应的布局文件
     *
     * @return
     */
    @Override
    protected int getLayout() {
        return R.layout.activity_reomendmain;
    }

    /**
     * 初始化布局
     */
    @Override
    protected void initView() {
        mInflater = LayoutInflater.from(getContext());
        mviewPager = (ViewPager) root.findViewById(R.id.activity_recomend_viewpager);
        mradioGroup = (RadioGroup) root.findViewById(R.id.activity_home_radiogroup);
        mRecyclerView = (RecyclerView) root.findViewById(R.id.list1);
        mViewPager2 = (ViewPager) root.findViewById(R.id.activity_chooser_view_content);
        mRecyclerView_2 = (RecyclerView) root.findViewById(R.id.list2);
        mRecyclerView_3 = (RecyclerView) root.findViewById(R.id.list3);
        mRecyclerView_4 = (RecyclerView) root.findViewById(R.id.list4);
        mRecyclerView_5 = (RecyclerView) root.findViewById(R.id.list5);
        mRecyclerView_6 = (RecyclerView) root.findViewById(R.id.list6);
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        //ͷ���ֲ�
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
        mAdapter_viewpager = new Adapter_viewpager(views, getContext());
        mviewPager.setAdapter(mAdapter_viewpager);
        //���򻬶�
        mLinearLayoutManager = new LinearLayoutManager(getActivity(), OrientationHelper.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        madapter_list1 = new adapter_list1(getContext(), 0);

        //viewpager_button
        LayoutInflater inflater = getLayoutInflater(getArguments());
        mView1 = inflater.inflate(R.layout.activity_recomend_list2_1, null);
        mView2 = inflater.inflate(R.layout.layout_recomend_list2_2, null);
        mViewList2 = new ArrayList<>();
        mViewList2.add(mView1);
        mViewList2.add(mView2);
        adapter_viewpager_list2 viewpagerAdapter = new adapter_viewpager_list2();
        viewpagerAdapter.settmViewList(mViewList2);
        mViewPager2.setAdapter(viewpagerAdapter);
        setlist2();
        setlist3();
        setlist4();
        setlist5();
        setlist6();
        getDate(url);

        madapter_list1.setOnItemClickListener(new adapter_list1.RecyclerOnClickListener() {
            @Override
            public void setRecyclerViewOnClickListener(View view, cityBean.ProductListBean fragmentBean, int position) {
                Intent intent = new Intent(recomendmainAcitvity.this.getContext(), WebviewActivity.class);
                intent.putExtra("id", Long.toString(fragmentBean.getUser().getId()));
                startActivity(intent);
            }
        });
        madapter_list1_2.setOnItemClickListener(new adapter_list2.RecyclerOnClickListener() {
            @Override
            public void setRecyclerViewOnClickListener(View view, cityBean.ProductListBean fragmentBean, int position) {
                Intent intent = new Intent(recomendmainAcitvity.this.getContext(), WebviewActivity.class);
                intent.putExtra("id", Long.toString(fragmentBean.getUser().getId()));
                startActivity(intent);
            }
        });
        madapter_list1_3.setOnItemClickListener(new adapter_list3.RecyclerOnClickListener() {
            @Override
            public void setRecyclerViewOnClickListener(View view, cityBean.ProductListBean fragmentBean, int position) {
                Intent intent = new Intent(recomendmainAcitvity.this.getContext(), WebviewActivity.class);
                intent.putExtra("id", Long.toString(fragmentBean.getUser().getId()));
                startActivity(intent);
            }
        });
        madapter_list1_4.setOnItemClickListener(new adapter_list4.RecyclerOnClickListener() {
            @Override
            public void setRecyclerViewOnClickListener(View view, cityBean.ProductListBean fragmentBean, int position) {
                Intent intent = new Intent(recomendmainAcitvity.this.getContext(), WebviewActivity.class);
                intent.putExtra("id", Long.toString(fragmentBean.getUser().getId()));
                startActivity(intent);
            }
        });
        madapter_list1_5.setOnItemClickListener(new adapter_list5.RecyclerOnClickListener() {
            @Override
            public void setRecyclerViewOnClickListener(View view, cityBean.ProductListBean fragmentBean, int position) {
                Intent intent = new Intent(recomendmainAcitvity.this.getContext(), WebviewActivity.class);
                intent.putExtra("id", Long.toString(fragmentBean.getUser().getId()));
                startActivity(intent);
            }
        });
        madapter_list1_6.setOnItemClickListener(new adapter_list6.RecyclerOnClickListener() {
            @Override
            public void setRecyclerViewOnClickListener(View view, cityBean.ProductListBean fragmentBean, int position) {
                Intent intent = new Intent(recomendmainAcitvity.this.getContext(), WebviewActivity.class);
                intent.putExtra("id", Long.toString(fragmentBean.getUser().getId()));
                startActivity(intent);
            }
        });
    }


    /**
     * 初始化事件
     */
    @Override
    protected void initEvents() {
        mviewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                handler.sendMessage(Message.obtain(handler, ImageHandler.MSG_PAGE_CHANGED, arg0, 0));
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                switch (arg0) {
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        handler.sendEmptyMessage(ImageHandler.MSG_KEEP_SILENT);
                        break;
                    case ViewPager.SCROLL_STATE_IDLE:
                        handler.sendEmptyMessageDelayed(ImageHandler.MSG_UPDATE_IMAGE, ImageHandler.MSG_DELAY);
                        break;
                    default:
                        break;
                }
            }
        });
        mviewPager.setCurrentItem(Integer.MAX_VALUE / 2);

        handler.sendEmptyMessageDelayed(ImageHandler.MSG_UPDATE_IMAGE, ImageHandler.MSG_DELAY);
    }

    public void setlist2() {
        mLinearLayoutManager_2 = new LinearLayoutManager(getActivity(), OrientationHelper.HORIZONTAL, false);
        mRecyclerView_2.setLayoutManager(mLinearLayoutManager_2);
        mRecyclerView_2.setHasFixedSize(true);
        madapter_list1_2 = new adapter_list2(getContext(), 0);
    }

    public void setlist3() {
        mLinearLayoutManager_3 = new LinearLayoutManager(getActivity(), OrientationHelper.HORIZONTAL, false);
        mRecyclerView_3.setLayoutManager(mLinearLayoutManager_3);
        mRecyclerView_3.setHasFixedSize(true);
        madapter_list1_3 = new adapter_list3(getContext(), 0);
    }

    public void setlist4() {
        mLinearLayoutManager_4 = new LinearLayoutManager(getActivity(), OrientationHelper.HORIZONTAL, false);
        mRecyclerView_4.setLayoutManager(mLinearLayoutManager_4);
        mRecyclerView_4.setHasFixedSize(true);
        madapter_list1_4 = new adapter_list4(getContext(), 0);
    }

    public void setlist5() {
        mLinearLayoutManager_5 = new LinearLayoutManager(getActivity(), OrientationHelper.HORIZONTAL, false);
        mRecyclerView_5.setLayoutManager(mLinearLayoutManager_5);
        mRecyclerView_5.setHasFixedSize(true);
        madapter_list1_5 = new adapter_list5(getContext(), 0);
    }

    public void setlist6() {
        mLinearLayoutManager_6 = new LinearLayoutManager(getActivity(), OrientationHelper.VERTICAL, false);
        mRecyclerView_6.setLayoutManager(mLinearLayoutManager_6);
        mRecyclerView_6.setHasFixedSize(true);
        madapter_list1_6 = new adapter_list6(getContext(), 0);
    }

    public List getDate(String url) {
        OkHttpUtils.getAsync(url, new OkHttpUtils.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) {
                ProductListBean1 = new ArrayList<>();
                Gson gson = new Gson();
                cityBean Databean2 = gson.fromJson(result, cityBean.class);
                ProductListBean1 = Databean2.getProduct_list();
                madapter_list1.setList(getListView1(ProductListBean1, 0, 4));
                mRecyclerView.setAdapter(madapter_list1);
                madapter_list1.notifyDataSetChanged();
                madapter_list1_2.setList(getListView1(ProductListBean1, 5, 9));
                mRecyclerView_2.setAdapter(madapter_list1_2);
                madapter_list1_2.notifyDataSetChanged();
                madapter_list1_3.setList(getListView1(ProductListBean1, 10, 14));
                mRecyclerView_3.setAdapter(madapter_list1_3);
                madapter_list1_3.notifyDataSetChanged();
                madapter_list1_4.setList(getListView1(ProductListBean1, 15, 19));
                mRecyclerView_4.setAdapter(madapter_list1_4);
                madapter_list1_4.notifyDataSetChanged();
                madapter_list1_5.setList(getListView1(ProductListBean1, 20, 24));
                mRecyclerView_5.setAdapter(madapter_list1_5);
                madapter_list1_5.notifyDataSetChanged();
                madapter_list1_6.setList(getListView1(ProductListBean1, 25, 29));
                mRecyclerView_6.setAdapter(madapter_list1_6);
                madapter_list1_6.notifyDataSetChanged();

            }
        });
        return null;
    }

    public List<cityBean.ProductListBean> getListView1(List<cityBean.ProductListBean> list, int start, int end) {
        ProductListBean2 = new ArrayList<>();
        for (; start <= end; start++) {
            ProductListBean2.add(list.get(start));
        }
        return ProductListBean2;
    }
}
