package com.example.com.breadtour.recomend.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.com.breadtour.R;
import com.example.com.breadtour.find.entity.meassagebean;
import com.example.com.breadtour.find.entity.meassagebean.ProductListBean;
import com.example.com.breadtour.recomend.entity.cityBean;
import com.example.com.breadtour.utils.ui.RoundAngleImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/6/28 0028.
 */
public class adapter_list6 extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<cityBean.ProductListBean> list;
    private LayoutInflater mInflater;
    private myViewHoledr1 myViewHoledr1;
    private int mTyep;
    private Context context;
    private  RecyclerOnClickListener mRecyclerOnClickListener;
    public adapter_list6(Context context, int Tyep) {
        mInflater = LayoutInflater.from(context);
        this.context=context;
        this.mTyep = Tyep;
    }
    public void setList(List list) {
        this.list = list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        if (viewType == 0) {
            itemView = mInflater.inflate(R.layout.find_cardview_item_layout, parent, false);
            myViewHoledr1 = new myViewHoledr1(itemView);
            return myViewHoledr1;
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        return mTyep;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof myViewHoledr1) {
            final cityBean.ProductListBean meassagebean =  list.get(position);
            ((myViewHoledr1) holder).id_find_nickname.setText(meassagebean.getUser().getName());
            ((myViewHoledr1) holder).id_find_share.setText("分享活动");
            ((myViewHoledr1) holder).id_find_share_time.setText("8分钟前");
            Picasso.with(context).load(meassagebean.getTitle_page()).into(((myViewHoledr1) holder).id_find_main_image);
            ((myViewHoledr1) holder).id_find_title.setText(meassagebean.getTitle());
            ((myViewHoledr1) holder).id_find_site.setText(meassagebean.getAddress());
            ((myViewHoledr1) holder).id_find_fee.setText("¥" + meassagebean.getPrice());
            ((myViewHoledr1) holder).id_find_invite.setText("发现这个活动不错哦，有小伙伴一起去吗？");
            Picasso.with(context).load(meassagebean.getUser().getAvatar_l()).into(((myViewHoledr1) holder).id_find_headimage);

            if (mRecyclerOnClickListener != null) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mRecyclerOnClickListener.setRecyclerViewOnClickListener(view, meassagebean, position);
                        Log.e("----", "点击了");
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void setOnItemClickListener(RecyclerOnClickListener listener) {
        this.mRecyclerOnClickListener = listener;
    }
    public   interface  RecyclerOnClickListener{
        void setRecyclerViewOnClickListener(View view, cityBean.ProductListBean fragmentBean, int position);
    }
    public class myViewHoledr1 extends RecyclerView.ViewHolder {
        private RoundAngleImageView id_find_headimage;
        private TextView id_find_nickname;
        private TextView id_find_share;
        private TextView id_find_share_time;
        private ImageView id_find_main_image;
        private TextView id_find_title;
        private TextView id_find_site;
        private TextView id_find_fee;
        private TextView id_find_invite;

        public myViewHoledr1(View itemView) {
            super(itemView);
            id_find_headimage = (RoundAngleImageView) itemView.findViewById(R.id.id_find_headimage);
            id_find_nickname = (TextView) itemView.findViewById(R.id.id_find_nickname);
            id_find_share = (TextView) itemView.findViewById(R.id.id_find_share);
            id_find_share_time = (TextView) itemView.findViewById(R.id.id_find_share_time);
            id_find_main_image = (ImageView) itemView.findViewById(R.id.id_find_main_image);
            id_find_title = (TextView) itemView.findViewById(R.id.id_find_title);
            id_find_site = (TextView) itemView.findViewById(R.id.id_find_site);
            id_find_fee = (TextView) itemView.findViewById(R.id.id_find_fee);
            id_find_invite = (TextView) itemView.findViewById(R.id.id_find_invite);

        }
    }
}




