package com.example.lixiang.dailypic2_android.model.entity;

import java.io.Serializable;

/**
 * Created by lixiang on 2017/11/15.
 */

public class PlanetEarthDetail implements Serializable{

    /**
     * data : {"latitude":"44","longitude":"122","mp4FilePath":"http://10.10.90.11:8080/video/201708261020000421859.mp4","playCount":"4681","thumbnailFilePath":"http://202.111.178.10:28085/upload/image/201711141808000089371_thumb.jpg","videoDuration":"5:00","videoId":"17111511510004480","videoName":"测试上传脉动地球","videoTime":"2017-11-11"}
     * message : success
     * status : 200
     */

    private DataBean data;
    private String message;
    private int status;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class DataBean implements Serializable{
        /**
         * latitude : 44
         * longitude : 122
         * mp4FilePath : http://10.10.90.11:8080/video/201708261020000421859.mp4
         * playCount : 4681
         * thumbnailFilePath : http://202.111.178.10:28085/upload/image/201711141808000089371_thumb.jpg
         * videoDuration : 5:00
         * videoId : 17111511510004480
         * videoName : 测试上传脉动地球
         * videoTime : 2017-11-11
         */

        private String latitude;
        private String longitude;
        private String mp4FilePath;
        private String playCount;
        private String thumbnailFilePath;
        private String videoDuration;
        private String videoId;
        private String videoName;
        private String videoTime;

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getMp4FilePath() {
            return mp4FilePath;
        }

        public void setMp4FilePath(String mp4FilePath) {
            this.mp4FilePath = mp4FilePath;
        }

        public String getPlayCount() {
            return playCount;
        }

        public void setPlayCount(String playCount) {
            this.playCount = playCount;
        }

        public String getThumbnailFilePath() {
            return thumbnailFilePath;
        }

        public void setThumbnailFilePath(String thumbnailFilePath) {
            this.thumbnailFilePath = thumbnailFilePath;
        }

        public String getVideoDuration() {
            return videoDuration;
        }

        public void setVideoDuration(String videoDuration) {
            this.videoDuration = videoDuration;
        }

        public String getVideoId() {
            return videoId;
        }

        public void setVideoId(String videoId) {
            this.videoId = videoId;
        }

        public String getVideoName() {
            return videoName;
        }

        public void setVideoName(String videoName) {
            this.videoName = videoName;
        }

        public String getVideoTime() {
            return videoTime;
        }

        public void setVideoTime(String videoTime) {
            this.videoTime = videoTime;
        }
    }
}
