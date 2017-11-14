package com.example.lixiang.dailypic2_android.model.entity;

import java.util.List;

/**
 * Created by 刘晓 on 2017/11/14.
 */

public class DailyPic {

    /**
     * data : {"SjDailyPicDtoList":[{"imageDate":"2017-11-18","imageId":"17111419080000531","imageName":"11","style":"1","thumbnail1FilePath":"http://202.111.178.10:28085/upload/image/201711141907000584990_thumb.png","thumbnail2FilePath":"","thumbnail3FilePath":""},{"imageDate":"2017-11-17","imageId":"17111419060004097","imageName":"123","style":"1","thumbnail1FilePath":"http://202.111.178.10:28085/upload/image/201711141906000307689_thumb.png","thumbnail2FilePath":"","thumbnail3FilePath":""},{"imageDate":"2017-10-10","imageId":"17111418440004256","imageName":"【每日一图】科普知识系列之\u201c西班牙的昨日帝都\u201d","style":"1","thumbnail1FilePath":"http://202.111.178.10:28085/upload/image/201711141842000238261_thumb.jpg","thumbnail2FilePath":"http://202.111.178.10:28085/upload/image/201711141842000443013_thumb.jpg","thumbnail3FilePath":"http://202.111.178.10:28085/upload/image/201711141842000517092_thumb.jpg"},{"imageDate":"2016-06-03","imageId":"17111419180002884","imageName":"【每日一图】\u201c剑\u201d与\u201c盾\u201d","style":"2","thumbnail1FilePath":"http://202.111.178.10:28085/upload/image/201711141918000025546_thumb.jpg","thumbnail2FilePath":"","thumbnail3FilePath":""},{"imageDate":"2016-06-02","imageId":"17111419150000251","imageName":"【每日一图】奇克拉纳德拉弗龙特拉","style":"2","thumbnail1FilePath":"http://202.111.178.10:28085/upload/image/201711141914000261740_thumb.jpg","thumbnail2FilePath":"","thumbnail3FilePath":""},{"imageDate":"2016-06-01","imageId":"17111418220000433","imageName":"【每日一图】卫片中的童趣","style":"1","thumbnail1FilePath":"http://202.111.178.10:28085/upload/image/201711141808000089371_thumb.jpg","thumbnail2FilePath":"http://202.111.178.10:28085/upload/image/201711141809000393683_thumb.png","thumbnail3FilePath":"http://202.111.178.10:28085/upload/image/201711141810000336924_thumb.jpg"},{"imageDate":"2016-03-01","imageId":"17111419090004917","imageName":"【每日一图】走进南非西开普省,领略别样风光","style":"1","thumbnail1FilePath":"http://202.111.178.10:28085/upload/image/201711141909000196794_thumb.jpg","thumbnail2FilePath":"http://202.111.178.10:28085/upload/image/201711141909000262412_thumb.jpg","thumbnail3FilePath":"http://202.111.178.10:28085/upload/image/201711141909000281273_thumb.jpg"}],"pages":1,"count":7}
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
         * SjDailyPicDtoList : [{"imageDate":"2017-11-18","imageId":"17111419080000531","imageName":"11","style":"1","thumbnail1FilePath":"http://202.111.178.10:28085/upload/image/201711141907000584990_thumb.png","thumbnail2FilePath":"","thumbnail3FilePath":""},{"imageDate":"2017-11-17","imageId":"17111419060004097","imageName":"123","style":"1","thumbnail1FilePath":"http://202.111.178.10:28085/upload/image/201711141906000307689_thumb.png","thumbnail2FilePath":"","thumbnail3FilePath":""},{"imageDate":"2017-10-10","imageId":"17111418440004256","imageName":"【每日一图】科普知识系列之\u201c西班牙的昨日帝都\u201d","style":"1","thumbnail1FilePath":"http://202.111.178.10:28085/upload/image/201711141842000238261_thumb.jpg","thumbnail2FilePath":"http://202.111.178.10:28085/upload/image/201711141842000443013_thumb.jpg","thumbnail3FilePath":"http://202.111.178.10:28085/upload/image/201711141842000517092_thumb.jpg"},{"imageDate":"2016-06-03","imageId":"17111419180002884","imageName":"【每日一图】\u201c剑\u201d与\u201c盾\u201d","style":"2","thumbnail1FilePath":"http://202.111.178.10:28085/upload/image/201711141918000025546_thumb.jpg","thumbnail2FilePath":"","thumbnail3FilePath":""},{"imageDate":"2016-06-02","imageId":"17111419150000251","imageName":"【每日一图】奇克拉纳德拉弗龙特拉","style":"2","thumbnail1FilePath":"http://202.111.178.10:28085/upload/image/201711141914000261740_thumb.jpg","thumbnail2FilePath":"","thumbnail3FilePath":""},{"imageDate":"2016-06-01","imageId":"17111418220000433","imageName":"【每日一图】卫片中的童趣","style":"1","thumbnail1FilePath":"http://202.111.178.10:28085/upload/image/201711141808000089371_thumb.jpg","thumbnail2FilePath":"http://202.111.178.10:28085/upload/image/201711141809000393683_thumb.png","thumbnail3FilePath":"http://202.111.178.10:28085/upload/image/201711141810000336924_thumb.jpg"},{"imageDate":"2016-03-01","imageId":"17111419090004917","imageName":"【每日一图】走进南非西开普省,领略别样风光","style":"1","thumbnail1FilePath":"http://202.111.178.10:28085/upload/image/201711141909000196794_thumb.jpg","thumbnail2FilePath":"http://202.111.178.10:28085/upload/image/201711141909000262412_thumb.jpg","thumbnail3FilePath":"http://202.111.178.10:28085/upload/image/201711141909000281273_thumb.jpg"}]
         * pages : 1
         * count : 7
         */

        private int pages;
        private int count;
        private List<SjDailyPicDtoListBean> SjDailyPicDtoList;

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

        public List<SjDailyPicDtoListBean> getSjDailyPicDtoList() {
            return SjDailyPicDtoList;
        }

        public void setSjDailyPicDtoList(List<SjDailyPicDtoListBean> SjDailyPicDtoList) {
            this.SjDailyPicDtoList = SjDailyPicDtoList;
        }

        public static class SjDailyPicDtoListBean {
            /**
             * imageDate : 2017-11-18
             * imageId : 17111419080000531
             * imageName : 11
             * style : 1
             * thumbnail1FilePath : http://202.111.178.10:28085/upload/image/201711141907000584990_thumb.png
             * thumbnail2FilePath :
             * thumbnail3FilePath :
             */

            private String imageDate;
            private String imageId;
            private String imageName;
            private String style;
            private String thumbnail1FilePath;
            private String thumbnail2FilePath;
            private String thumbnail3FilePath;

            public String getImageDate() {
                return imageDate;
            }

            public void setImageDate(String imageDate) {
                this.imageDate = imageDate;
            }

            public String getImageId() {
                return imageId;
            }

            public void setImageId(String imageId) {
                this.imageId = imageId;
            }

            public String getImageName() {
                return imageName;
            }

            public void setImageName(String imageName) {
                this.imageName = imageName;
            }

            public String getStyle() {
                return style;
            }

            public void setStyle(String style) {
                this.style = style;
            }

            public String getThumbnail1FilePath() {
                return thumbnail1FilePath;
            }

            public void setThumbnail1FilePath(String thumbnail1FilePath) {
                this.thumbnail1FilePath = thumbnail1FilePath;
            }

            public String getThumbnail2FilePath() {
                return thumbnail2FilePath;
            }

            public void setThumbnail2FilePath(String thumbnail2FilePath) {
                this.thumbnail2FilePath = thumbnail2FilePath;
            }

            public String getThumbnail3FilePath() {
                return thumbnail3FilePath;
            }

            public void setThumbnail3FilePath(String thumbnail3FilePath) {
                this.thumbnail3FilePath = thumbnail3FilePath;
            }
        }
    }
}
