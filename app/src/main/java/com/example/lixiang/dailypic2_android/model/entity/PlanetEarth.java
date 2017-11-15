package com.example.lixiang.dailypic2_android.model.entity;

import java.util.List;

/**
 * Created by lixiang on 2017/11/15.
 */

public class PlanetEarth {

    /**
     * data : {"pages":1,"count":1,"SjMobilePlanetEarthDtoList":[{"playCount":"4681","thumbnailFilePath":"http://10.10.90.11:8080/image/201708261021000156398.jpg","videoDuration":"5:00","videoId":"17111511510004480","videoName":"测试上传脉动地球","videoTime":"2017-11-11"}]}
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

    public static class DataBean {
        /**
         * pages : 1
         * count : 1
         * SjMobilePlanetEarthDtoList : [{"playCount":"4681","thumbnailFilePath":"http://10.10.90.11:8080/image/201708261021000156398.jpg","videoDuration":"5:00","videoId":"17111511510004480","videoName":"测试上传脉动地球","videoTime":"2017-11-11"}]
         */

        private int pages;
        private int count;
        private List<SjMobilePlanetEarthDtoListBean> SjMobilePlanetEarthDtoList;

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<SjMobilePlanetEarthDtoListBean> getSjMobilePlanetEarthDtoList() {
            return SjMobilePlanetEarthDtoList;
        }

        public void setSjMobilePlanetEarthDtoList(List<SjMobilePlanetEarthDtoListBean> SjMobilePlanetEarthDtoList) {
            this.SjMobilePlanetEarthDtoList = SjMobilePlanetEarthDtoList;
        }

        public static class SjMobilePlanetEarthDtoListBean {
            /**
             * playCount : 4681
             * thumbnailFilePath : http://10.10.90.11:8080/image/201708261021000156398.jpg
             * videoDuration : 5:00
             * videoId : 17111511510004480
             * videoName : 测试上传脉动地球
             * videoTime : 2017-11-11
             */

            private String playCount;
            private String thumbnailFilePath;
            private String videoDuration;
            private String videoId;
            private String videoName;
            private String videoTime;

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
}
