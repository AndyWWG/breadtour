package com.example.com.breadtour.find.adapter;

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
import com.example.com.breadtour.utils.ui.RoundAngleImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by cmh on 2016/6/27.
 */
public class FindRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private LayoutInflater layoutInflater;
    private Context context;
    private int mType;
    private List size;
    private OnRecyclerViewClickListener mOnRecyclerViewClickListener;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setSize(List size) {
        this.size = size;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(R.layout.find_cardview_item_layout, parent, false);
        ItemViewHolder item = new ItemViewHolder(itemView);
        itemView.setOnClickListener(this);
        return item;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof ItemViewHolder) {
            final meassagebean.ProductListBean meassagebean = (com.example.com.breadtour.find.entity.meassagebean.ProductListBean) size.get(position);
            ((ItemViewHolder) holder).id_find_nickname.setText(meassagebean.getUser().getName());
            ((ItemViewHolder) holder).id_find_share.setText("分享活动");
            ((ItemViewHolder) holder).id_find_share_time.setText("8分钟前");
            Picasso.with(context).load(meassagebean.getTitle_page()).into(((ItemViewHolder) holder).id_find_main_image);
            ((ItemViewHolder) holder).id_find_title.setText(meassagebean.getTitle());
            ((ItemViewHolder) holder).id_find_site.setText(meassagebean.getAddress());
            ((ItemViewHolder) holder).id_find_fee.setText("¥" + meassagebean.getPrice());
            ((ItemViewHolder) holder).id_find_invite.setText("发现这个活动不错哦，有小伙伴一起去吗？");
            Picasso.with(context).load(meassagebean.getUser().getAvatar_l()).into(((ItemViewHolder) holder).id_find_headimage);

            if (mOnRecyclerViewClickListener != null) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mOnRecyclerViewClickListener.onItemClick(view, meassagebean, position);
                        Log.e("----", "点击了");
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return size.size();
    }

    @Override
    public void onClick(View view) {

    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private RoundAngleImageView id_find_headimage;
        private TextView id_find_nickname;
        private TextView id_find_share;
        private TextView id_find_share_time;
        private ImageView id_find_main_image;
        private TextView id_find_title;
        private TextView id_find_site;
        private TextView id_find_fee;
        private TextView id_find_invite;

        public ItemViewHolder(View itemView) {
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

    public static interface OnRecyclerViewClickListener {
        void onItemClick(View view, meassagebean.ProductListBean meassagebean, int position);
    }

    @Override
    public int getItemViewType(int position) {
        return mType;
    }


    public void setOnRecyclerViewClickListener(OnRecyclerViewClickListener mOnRecyclerViewClickListener) {
        this.mOnRecyclerViewClickListener = mOnRecyclerViewClickListener;
    }
}
