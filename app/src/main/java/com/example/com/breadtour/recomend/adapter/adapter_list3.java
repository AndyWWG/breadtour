package com.example.com.breadtour.recomend.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.com.breadtour.R;
import com.example.com.breadtour.recomend.entity.cityBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/6/28 0028.
 */
public class adapter_list3 extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<cityBean.ProductListBean> list;
    private LayoutInflater mInflater;
    private myViewHoledr1 myViewHoledr1;
    private int mTyep;

    private Context context;
    private  RecyclerOnClickListener mRecyclerOnClickListener;
    public adapter_list3(Context context, int Tyep) {
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
            itemView = mInflater.inflate(R.layout.activity_index_gallery_item, parent, false);
            myViewHoledr1 = new myViewHoledr1(itemView);;
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
            Picasso.with(context).load(list.get(position).getTitle_page()).into(myViewHoledr1.imageView);
            myViewHoledr1.t2.setText(list.get(position).getPrice());
            myViewHoledr1.t1.setText(list.get(position).getTitle());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mRecyclerOnClickListener!=null){
                        mRecyclerOnClickListener.setRecyclerViewOnClickListener(v, list.get(position), position);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void setOnItemClickListener(RecyclerOnClickListener listener) {
        this.mRecyclerOnClickListener = listener;
    }
    public  static interface  RecyclerOnClickListener{
        void setRecyclerViewOnClickListener(View view,cityBean.ProductListBean fragmentBean,int position);
    }
    public class myViewHoledr1 extends RecyclerView.ViewHolder {
        TextView t1, t2;
        ImageView imageView;

        public myViewHoledr1(View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.id_index_gallery_item_text);
            t2 = (TextView) itemView.findViewById(R.id.id_index_gallery_price_text);
            imageView = (ImageView) itemView.findViewById(R.id.id_index_gallery_item_image);
        }
    }
}




