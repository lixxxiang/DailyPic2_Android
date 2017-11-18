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
import com.example.lixiang.dailypic2_android.model.entity.homePage;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by lixiang on 2017/11/8.
 */

public class HomeListViewAdapter extends BaseAdapter {
    private static final int TYPE_PIC_1 = 0;
    private static final int TYPE_PIC_2 = 1;
    private static final int TYPE_VIDEO = 2;

    private Context context;
    private List<homePage.DataBean.MixedContentListBean> content;


    public HomeListViewAdapter(Context context, List<homePage.DataBean.MixedContentListBean> content) {
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
            if (content.get(position).getType().equals("1") && content.get(position).getStyle().equals("1")) {
                return TYPE_PIC_1;
            } else if (content.get(position).getType().equals("1") && content.get(position).getStyle().equals("2")) {
                return TYPE_PIC_2;
            }
        } else
            return TYPE_VIDEO;
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pic1Holder pic1Holder;
        Pic2Holder pic2Holder;
        VideoHolder videoHolder;

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
                if (content.get(position).getThumbnail1Path() != null)
                    pic1Holder.pic1Pic.setImageURI(Uri.parse(content.get(position).getThumbnail1Path()));
                if (content.get(position).getContentName() != null)
                    pic1Holder.pic1Name.setText(content.get(position).getContentName());
                if (content.get(position).getContentDate() != null)
                    pic1Holder.pic1Date.setText(content.get(position).getContentDate());
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
                if (content.get(position).getContentName() != null)
                    pic2Holder.pic2Name.setText(content.get(position).getContentName());
                if (content.get(position).getContentDate() != null)
                    pic2Holder.pic2Date.setText(content.get(position).getContentDate());
                if (content.get(position).getThumbnail1Path() != null)
                    pic2Holder.pic2Pic1.setImageURI(Uri.parse(content.get(position).getThumbnail1Path()));
                if (content.get(position).getThumbnail2Path() != null)
                    pic2Holder.pic2Pic2.setImageURI(Uri.parse(content.get(position).getThumbnail2Path()));
                if (content.get(position).getThumbnail3Path().length() == 0){
                    pic2Holder.pic2Pic3.setVisibility(View.INVISIBLE);
                }else{
                    pic2Holder.pic2Pic3.setImageURI(Uri.parse(content.get(position).getThumbnail3Path()));
                }
                break;
            case TYPE_VIDEO:
                if (convertView == null) {
                    convertView = LayoutInflater.from(context).inflate(R.layout.video_listview, null);
                    videoHolder = new VideoHolder();
                    videoHolder.videoName = convertView.findViewById(R.id.videoname);
                    videoHolder.videoPic = convertView.findViewById(R.id.videopic);
                    videoHolder.playTimes = convertView.findViewById(R.id.playTimes);
                    videoHolder.duration = convertView.findViewById(R.id.duration);
                    videoHolder.date = convertView.findViewById(R.id.videodate);
                    convertView.setTag(videoHolder);
                } else {
                    videoHolder = (VideoHolder) convertView.getTag();
                }
                if (content.get(position).getContentName() != null)
                    videoHolder.videoName.setText(content.get(position).getContentName());
                if (content.get(position).getThumbnail1Path() != null)
                    videoHolder.videoPic.setImageURI(Uri.parse(content.get(position).getThumbnail1Path()));if (content.get(position).getPlayCount() != null)
                videoHolder.playTimes.setText(content.get(position).getPlayCount() + "次播放");
                if (content.get(position).getDuration() != null)
                    videoHolder.duration.setText(content.get(position).getDuration());
                if (content.get(position).getContentDate() != null)
                    videoHolder.date.setText(content.get(position).getContentDate());

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

    class VideoHolder {
        TextView videoName;
        ImageView videoPic;
        TextView playTimes;
        TextView duration;
        TextView date;
    }
}