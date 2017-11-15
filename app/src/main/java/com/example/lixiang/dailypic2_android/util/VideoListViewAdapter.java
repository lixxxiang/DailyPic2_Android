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
import com.example.lixiang.dailypic2_android.model.entity.PlanetEarth;
import com.example.lixiang.dailypic2_android.model.entity.homePage;

import java.util.List;

/**
 * Created by lixiang on 2017/11/8.
 */

public class VideoListViewAdapter extends BaseAdapter {

    private Context context;
    private List<PlanetEarth.DataBean.SjMobilePlanetEarthDtoListBean> content;


    public VideoListViewAdapter(Context context, List<PlanetEarth.DataBean.SjMobilePlanetEarthDtoListBean> content) {
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


    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        VideoHolder videoHolder;

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
        if (content.get(position).getVideoName() != null)
            videoHolder.videoName.setText(content.get(position).getVideoName());
        if (content.get(position).getThumbnailFilePath() != null)
            videoHolder.videoPic.setImageURI(Uri.parse(content.get(position).getThumbnailFilePath()));
        if (content.get(position).getPlayCount() != null)
            System.out.println(content.get(position).getPlayCount() + "次播放");
            videoHolder.playTimes.setText(content.get(position).getPlayCount() + "次播放");
        if (content.get(position).getVideoDuration() != null)
            videoHolder.duration.setText(content.get(position).getVideoDuration());
        if (content.get(position).getVideoTime() != null)
            videoHolder.date.setText(content.get(position).getVideoTime());
        return convertView;
    }

    class VideoHolder {
        TextView videoName;
        ImageView videoPic;
        TextView playTimes;
        TextView duration;
        TextView date;
    }
}