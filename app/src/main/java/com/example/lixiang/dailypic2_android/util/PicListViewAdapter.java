package com.example.lixiang.dailypic2_android.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lixiang.dailypic2_android.R;
import com.example.lixiang.dailypic2_android.model.entity.DailyPic;

import java.util.List;

/**
 * Created by lixiang on 2017/11/15.
 */

public class PicListViewAdapter extends BaseAdapter {
    private static final int TYPE_PIC_1 = 0;
    private static final int TYPE_PIC_2 = 1;

    private Context context;
    private List<DailyPic.DataBean.SjDailyPicDtoListBean> content;


    public PicListViewAdapter(Context context, List<DailyPic.DataBean.SjDailyPicDtoListBean> content) {
        super();
        this.context = context;
        this.content = content;
    }

    @Override
    public int getCount() {
        return content.size();
    }

    @Override
    public Object getItem(int position) {
        return content.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if (content.get(position).getStyle() != null) {
            if (content.get(position).getStyle().equals("1")) {
                return TYPE_PIC_1;
            } else if (content.get(position).getStyle().equals("2")) {
                return TYPE_PIC_2;
            }
        }
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pic1Holder pic1Holder;
        Pic2Holder pic2Holder;

        switch (getItemViewType(position)) {
            case TYPE_PIC_1:
                if (convertView == null) {
                    convertView = LayoutInflater.from(context).inflate(R.layout.pic_listview_1, null);
                    pic1Holder = new Pic1Holder();
                    pic1Holder.pic1Name = convertView.findViewById(R.id.pic1name);
                    pic1Holder.pic1Date = convertView.findViewById(R.id.pic1Date);
                    pic1Holder.pic1Pic = convertView.findViewById(R.id.pic1pic);
                    convertView.setTag(pic1Holder);
                } else {
                    pic1Holder = (Pic1Holder) convertView.getTag();
                }
                if (content.get(position).getThumbnail1FilePath() != null)
                    pic1Holder.pic1Pic.setImageURI(Uri.parse(content.get(position).getThumbnail1FilePath()));
                if (content.get(position).getImageName() != null)
                    pic1Holder.pic1Name.setText(content.get(position).getImageName());
                if (content.get(position).getImageDate() != null)
                    pic1Holder.pic1Date.setText(content.get(position).getImageDate());
                break;
            case TYPE_PIC_2:
                if (convertView == null) {
                    convertView = LayoutInflater.from(context).inflate(R.layout.pic_listview_2, null);
                    pic2Holder = new Pic2Holder();
                    pic2Holder.pic2Name = convertView.findViewById(R.id.pic2name);
                    pic2Holder.pic2Date = convertView.findViewById(R.id.pic2date);
                    pic2Holder.pic2Pic1 = convertView.findViewById(R.id.pic1);
                    pic2Holder.pic2Pic2 = convertView.findViewById(R.id.pic2);
                    pic2Holder.pic2Pic3 = convertView.findViewById(R.id.pic3);
                    convertView.setTag(pic2Holder);
                } else {
                    pic2Holder = (Pic2Holder) convertView.getTag();
                }
                if (content.get(position).getImageName() != null)
                    pic2Holder.pic2Name.setText(content.get(position).getImageName());
                if (content.get(position).getImageDate() != null)
                    pic2Holder.pic2Date.setText(content.get(position).getImageDate());
                if (content.get(position).getThumbnail1FilePath() != null)
                    pic2Holder.pic2Pic1.setImageURI(Uri.parse(content.get(position).getThumbnail1FilePath()));
                if (content.get(position).getThumbnail2FilePath() != null)
                    pic2Holder.pic2Pic2.setImageURI(Uri.parse(content.get(position).getThumbnail2FilePath()));
                if (content.get(position).getThumbnail3FilePath().length() == 0){
                    pic2Holder.pic2Pic3.setVisibility(View.INVISIBLE);
                }else{
                    pic2Holder.pic2Pic3.setImageURI(Uri.parse(content.get(position).getThumbnail3FilePath()));
                }
                break;
        }
        return convertView;
    }

    class Pic1Holder {
        ImageView pic1Pic;
        TextView pic1Name;
        TextView pic1Date;
    }

    class Pic2Holder {
        ImageView pic2Pic1;
        ImageView pic2Pic2;
        ImageView pic2Pic3;

        TextView pic2Name;
        TextView pic2Date;
    }

}
