package com.example.com.breadtour.meassage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.com.breadtour.R;

import java.util.List;

/**
 * Created by Administrator on 2016/6/28 0028.
 */
public class adapter_list_carview extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List list;
    private LayoutInflater mInflater;
    private myViewHoledr1 myViewHoledr1;
    private int mTyep;
    private View itemView;

    public adapter_list_carview(Context context, List list, int Tyep) {
        this.list = list;
        mInflater = LayoutInflater.from(context);
        this.mTyep = Tyep;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            itemView = mInflater.inflate(R.layout.item_messagemain_recyclerview, parent, false);
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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof myViewHoledr1) {
            myViewHoledr1.imageView.setImageResource(R.mipmap.a);
            myViewHoledr1.t2.setText("哈哈哈哈");
            myViewHoledr1.t1.setText("呵呵呵呵");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    //    @Override
//    public void onClick(View v) {
//        if (setRecyclerOnClickListener!=null){
//            setRecyclerOnClickListener.setRecyclerViewOnClickListener(v, (com.example.administrator.my36kr_news.untils.fragmentBean) v.getTag());
//        }
//    }
//    public void setOnItemClickListener(setRecyclerOnClickListener listener) {
//        this.setRecyclerOnClickListener = listener;
//    }
    public class myViewHoledr1 extends RecyclerView.ViewHolder {
        TextView t1, t2;
        ImageView imageView;

        public myViewHoledr1(View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.carvoew_1);
            t2 = (TextView) itemView.findViewById(R.id.carvoew_2);
            imageView = (ImageView) itemView.findViewById(R.id.carvoew_1_images);
        }
    }
}
//interface setRecyclerOnClickListener{
//    void setRecyclerViewOnClickListener(View view,fragmentBean fragmentBean);
//}



