package com.example.jingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.jingdong.R;
import com.example.jingdong.bean.SearchBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * 作者：邱宇
 * 时间：2017-12-16 11:42
 * 类的用途：
 */

public class SearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<SearchBean.DataBean> dataList;

    public SearchAdapter(Context context, List<SearchBean.DataBean> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.serach_rlv_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;

        SearchBean.DataBean dataBean = dataList.get(position);
        myViewHolder.sdv.setImageURI(dataBean.getImages());
        myViewHolder.tv_title.setText(dataBean.getSubhead());
        myViewHolder.tv_price.setText("￥" + dataBean.getPrice());
    }

    @Override
    public int getItemCount() {
        if (dataList.size() == 0) {
            return 0;
        }
        return dataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView sdv;
        private final TextView tv_title;
        private final TextView tv_price;

        public MyViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.se_sdv);
            tv_title = itemView.findViewById(R.id.se_tv1);
            tv_price = itemView.findViewById(R.id.se_price);

        }
    }
}
