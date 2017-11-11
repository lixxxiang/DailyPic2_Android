package com.example.lixiang.dailypic2_android.model.entity;

import java.util.List;

/**
 * Created by lixiang on 2017/11/10.
 */

public class homePage {


    /**
     * data : {"pages":12,"MixedContentList":[{"contentDate":"2017-11-03","contentId":"17110616500000281","contentName":"测试上传每日一图","style":"2","thumbnail1Path":"http://202.111.178.10:28085/upload/image/201709111935000285305.jpg","thumbnail2Path":"http://202.111.178.10:28085/upload/image/201709111837000191443.jpg","thumbnail3Path":"http://202.111.178.10:28085/upload/image/201709111835000192482.jpg","type":"1","duration":"05:00","playCount":"2961"},{"contentDate":"2017-11-03","contentId":"17110319270000324","contentName":"测试上传脉动地球","duration":"05:00","playCount":"2961","thumbnail1Path":"http://10.10.90.11:8080/image/201708261021000156398.jpg","type":"2"},{"contentDate":"2017-09-18","contentId":"17091810350005123","contentName":"测试查看大图","style":"1","thumbnail1Path":"http://202.111.178.10:28085/upload/image/201709181034000318205.jpeg","type":"1"},{"contentDate":"2017-09-15","contentId":"1709151039000339","contentName":"长春路况","duration":"00:13","playCount":"1979","thumbnail1Path":"http://202.111.178.10:28085/upload/image/201709151039000152760.png","type":"2"},{"contentDate":"2017-09-12","contentId":"17091208550003915","contentName":"【每日一图】科普知识系列之\u201c全国唯一绿化模范民航\u201d","style":"1","thumbnail1Path":"http://202.111.178.10:28085/upload/image/201709120855000034301.jpg","type":"1"},{"contentDate":"2017-09-12","contentId":"17091208490002297","contentName":"【每日一图】科普知识系列之\u201c历史上最古老的基督教堂\u201d","style":"2","thumbnail1Path":"http://202.111.178.10:28085/upload/image/201709120848000461522.jpg","type":"1"},{"contentDate":"2017-09-12","contentId":"17091208570001628","contentName":"【每日一图】旅游百事系列之\u201c东方丝路明珠\u201d","style":"2","thumbnail1Path":"http://202.111.178.10:28085/upload/image/201709120855000591128.jpg","thumbnail2Path":"http://202.111.178.10:28085/upload/image/201709120855000591128.jpg","thumbnail3Path":"http://202.111.178.10:28085/upload/image/201709120855000591128.jpg","type":"1"},{"contentDate":"2017-09-12","contentId":"17091208480000288","contentName":"【每日一图】科普知识系列之\u201c尼古拉耶夫造船厂的发展及没落\u201d","thumbnail1Path":"http://202.111.178.10:28085/upload/image/201709120847000079228.jpg","type":"1"},{"contentDate":"2017-09-12","contentId":"17091208510001441","contentName":"【每日一图】科普知识系列之\u201c迪亚巴克尔机场袭击事件\u201d","style":"2","thumbnail1Path":"http://202.111.178.10:28085/upload/image/201709120849000462690.jpg","type":"1"},{"contentDate":"2017-09-12","contentId":"17091208520004353","contentName":"【每日一图】科普知识系列之\u201c苏丹农业概况\u201d","style":"1","thumbnail1Path":"http://202.111.178.10:28085/upload/image/201709120851000551126.jpg","type":"1"}],"count":112}
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
         * pages : 12
         * MixedContentList : [{"contentDate":"2017-11-03","contentId":"17110616500000281","contentName":"测试上传每日一图","style":"2","thumbnail1Path":"http://202.111.178.10:28085/upload/image/201709111935000285305.jpg","thumbnail2Path":"http://202.111.178.10:28085/upload/image/201709111837000191443.jpg","thumbnail3Path":"http://202.111.178.10:28085/upload/image/201709111835000192482.jpg","type":"1"},{"contentDate":"2017-11-03","contentId":"17110319270000324","contentName":"测试上传脉动地球","duration":"05:00","playCount":"2961","thumbnail1Path":"http://10.10.90.11:8080/image/201708261021000156398.jpg","type":"2"},{"contentDate":"2017-09-18","contentId":"17091810350005123","contentName":"测试查看大图","style":"1","thumbnail1Path":"http://202.111.178.10:28085/upload/image/201709181034000318205.jpeg","type":"1"},{"contentDate":"2017-09-15","contentId":"1709151039000339","contentName":"长春路况","duration":"00:13","playCount":"1979","thumbnail1Path":"http://202.111.178.10:28085/upload/image/201709151039000152760.png","type":"2"},{"contentDate":"2017-09-12","contentId":"17091208550003915","contentName":"【每日一图】科普知识系列之\u201c全国唯一绿化模范民航\u201d","style":"1","thumbnail1Path":"http://202.111.178.10:28085/upload/image/201709120855000034301.jpg","type":"1"},{"contentDate":"2017-09-12","contentId":"17091208490002297","contentName":"【每日一图】科普知识系列之\u201c历史上最古老的基督教堂\u201d","style":"2","thumbnail1Path":"http://202.111.178.10:28085/upload/image/201709120848000461522.jpg","type":"1"},{"contentDate":"2017-09-12","contentId":"17091208570001628","contentName":"【每日一图】旅游百事系列之\u201c东方丝路明珠\u201d","style":"2","thumbnail1Path":"http://202.111.178.10:28085/upload/image/201709120855000591128.jpg","thumbnail2Path":"http://202.111.178.10:28085/upload/image/201709120855000591128.jpg","thumbnail3Path":"http://202.111.178.10:28085/upload/image/201709120855000591128.jpg","type":"1"},{"contentDate":"2017-09-12","contentId":"17091208480000288","contentName":"【每日一图】科普知识系列之\u201c尼古拉耶夫造船厂的发展及没落\u201d","thumbnail1Path":"http://202.111.178.10:28085/upload/image/201709120847000079228.jpg","type":"1"},{"contentDate":"2017-09-12","contentId":"17091208510001441","contentName":"【每日一图】科普知识系列之\u201c迪亚巴克尔机场袭击事件\u201d","style":"2","thumbnail1Path":"http://202.111.178.10:28085/upload/image/201709120849000462690.jpg","type":"1"},{"contentDate":"2017-09-12","contentId":"17091208520004353","contentName":"【每日一图】科普知识系列之\u201c苏丹农业概况\u201d","style":"1","thumbnail1Path":"http://202.111.178.10:28085/upload/image/201709120851000551126.jpg","type":"1"}]
         * count : 112
         */

        private int pages;
        private int count;
        private List<MixedContentListBean> MixedContentList;

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

        public List<MixedContentListBean> getMixedContentList() {
            return MixedContentList;
        }

        public void setMixedContentList(List<MixedContentListBean> MixedContentList) {
            this.MixedContentList = MixedContentList;
        }

        public static class MixedContentListBean {
            /**
             * contentDate : 2017-11-03
             * contentId : 17110616500000281
             * contentName : 测试上传每日一图
             * style : 2
             * thumbnail1Path : http://202.111.178.10:28085/upload/image/201709111935000285305.jpg
             * thumbnail2Path : http://202.111.178.10:28085/upload/image/201709111837000191443.jpg
             * thumbnail3Path : http://202.111.178.10:28085/upload/image/201709111835000192482.jpg
             * type : 1
             * duration : 05:00
             * playCount : 2961
             */

            private String contentDate;
            private String contentId;
            private String contentName;
            private String style;
            private String thumbnail1Path;
            private String thumbnail2Path;
            private String thumbnail3Path;
            private String type;
            private String duration;
            private String playCount;

            public String getContentDate() {
                return contentDate;
            }

            public void setContentDate(String contentDate) {
                this.contentDate = contentDate;
            }

            public String getContentId() {
                return contentId;
            }

            public void setContentId(String contentId) {
                this.contentId = contentId;
            }

            public String getContentName() {
                return contentName;
            }

            public void setContentName(String contentName) {
                this.contentName = contentName;
            }

            public String getStyle() {
                return style;
            }

            public void setStyle(String style) {
                this.style = style;
            }

            public String getThumbnail1Path() {
                return thumbnail1Path;
            }

            public void setThumbnail1Path(String thumbnail1Path) {
                this.thumbnail1Path = thumbnail1Path;
            }

            public String getThumbnail2Path() {
                return thumbnail2Path;
            }

            public void setThumbnail2Path(String thumbnail2Path) {
                this.thumbnail2Path = thumbnail2Path;
            }

            public String getThumbnail3Path() {
                return thumbnail3Path;
            }

            public void setThumbnail3Path(String thumbnail3Path) {
                this.thumbnail3Path = thumbnail3Path;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getPlayCount() {
                return playCount;
            }

            public void setPlayCount(String playCount) {
                this.playCount = playCount;
            }
        }
    }
}

