package com.example.lixiang.dailypic2_android.model.entity;

import java.io.Serializable;

/**
 * Created by lixiang on 2017/11/13.
 */

public class DailyPicDetail implements Serializable {

    /**
     * data : {"image1FilePath":"http://202.111.178.10:28085/upload/image/201709120856000021360.jpg","image2FilePath":"http://202.111.178.10:28085/upload/image/201709120857000047200.jpg","image3FilePath":"http://202.111.178.10:28085/upload/image/201709111810000399016.jpg","imageDate":"2017-09-12","imageId":"17091208570001628","imageName":"【每日一图】旅游百事系列之\u201c东方丝路明珠\u201d","latitude":"39.75","longitude":"98.35","richText1":"       嘉峪关市是甘肃省下辖的地级市，位于甘肃省西北部，河西走廊中部，东临河西重镇酒泉市肃州区，东南距省会兰州直线距离650公里；西北连石油城酒泉玉门市，西北至新疆哈密650千米；南倚祁连山与张掖市肃南裕固族自治县接壤；北枕黑山与酒泉市金塔县相连接，中部为酒泉绿洲西缘。","richText2":"       嘉峪关方特欢乐世界位于嘉峪关市南市区方特大道，由深圳华强集团投资打造。它是目前甘肃规模最大的高科技第四代主题公园，被誉为\u201c东方丝路明珠\u201d，同时它也是嘉峪关华强文化科技产业基地的重要组成部分。 \n       在嘉峪关方特欢乐世界，可以体验国际一流的高空飞翔体验项目\u201c飞越极限\u201d、中国独创的大型探险项目\u201c唐古拉雪山\u201d、跟踪式立体魔幻表演项目\u201c魔法城堡\u201d、大型主题漂流历险项目\u201c激流勇进\u201d，每一项都会让游客流连忘返，乐不思蜀。由于嘉峪关方特欢乐世界的部分项目为室内高科技体验互动型项目，不受天气的影响，进一步丰富了嘉峪关地区的旅游产业。\n       嘉峪关华强文化科技产业基地项目方特欢乐世界拥有飞越极限、聊斋、丝路之旅、方特城堡、\u201c熊出没\u201d剧场、\u201c熊出没\u201d历险、生命之光、激流勇进、海螺湾、唐古拉雪山、火流星等二十几个主题游乐项目，涵盖其它游乐项目、休闲及景观项目数百项，其中包括许多世界领先的超大型游乐项目。深圳华强集团在这些项目的研发建设、创意设计、硬件、软件及影视制作方面拥有完全的知识产权，并已将文化科技主题公园项目输出到伊朗、乌克兰、南非等国，使中国成为继美国、法国之后的第三个大型文化主题公园出口国。"}
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
         * image1FilePath : http://202.111.178.10:28085/upload/image/201709120856000021360.jpg
         * image2FilePath : http://202.111.178.10:28085/upload/image/201709120857000047200.jpg
         * image3FilePath : http://202.111.178.10:28085/upload/image/201709111810000399016.jpg
         * imageDate : 2017-09-12
         * imageId : 17091208570001628
         * imageName : 【每日一图】旅游百事系列之“东方丝路明珠”
         * latitude : 39.75
         * longitude : 98.35
         * richText1 :        嘉峪关市是甘肃省下辖的地级市，位于甘肃省西北部，河西走廊中部，东临河西重镇酒泉市肃州区，东南距省会兰州直线距离650公里；西北连石油城酒泉玉门市，西北至新疆哈密650千米；南倚祁连山与张掖市肃南裕固族自治县接壤；北枕黑山与酒泉市金塔县相连接，中部为酒泉绿洲西缘。
         * richText2 :        嘉峪关方特欢乐世界位于嘉峪关市南市区方特大道，由深圳华强集团投资打造。它是目前甘肃规模最大的高科技第四代主题公园，被誉为“东方丝路明珠”，同时它也是嘉峪关华强文化科技产业基地的重要组成部分。
         在嘉峪关方特欢乐世界，可以体验国际一流的高空飞翔体验项目“飞越极限”、中国独创的大型探险项目“唐古拉雪山”、跟踪式立体魔幻表演项目“魔法城堡”、大型主题漂流历险项目“激流勇进”，每一项都会让游客流连忘返，乐不思蜀。由于嘉峪关方特欢乐世界的部分项目为室内高科技体验互动型项目，不受天气的影响，进一步丰富了嘉峪关地区的旅游产业。
         嘉峪关华强文化科技产业基地项目方特欢乐世界拥有飞越极限、聊斋、丝路之旅、方特城堡、“熊出没”剧场、“熊出没”历险、生命之光、激流勇进、海螺湾、唐古拉雪山、火流星等二十几个主题游乐项目，涵盖其它游乐项目、休闲及景观项目数百项，其中包括许多世界领先的超大型游乐项目。深圳华强集团在这些项目的研发建设、创意设计、硬件、软件及影视制作方面拥有完全的知识产权，并已将文化科技主题公园项目输出到伊朗、乌克兰、南非等国，使中国成为继美国、法国之后的第三个大型文化主题公园出口国。
         */

        private String image1FilePath;
        private String image2FilePath;
        private String image3FilePath;
        private String imageDate;
        private String imageId;
        private String imageName;
        private String latitude;
        private String longitude;
        private String richText1;
        private String richText2;
        private String richText3;

        public String getImage1FilePath() {
            return image1FilePath;
        }

        public void setImage1FilePath(String image1FilePath) {
            this.image1FilePath = image1FilePath;
        }

        public String getImage2FilePath() {
            return image2FilePath;
        }

        public void setImage2FilePath(String image2FilePath) {
            this.image2FilePath = image2FilePath;
        }

        public String getImage3FilePath() {
            return image3FilePath;
        }

        public void setImage3FilePath(String image3FilePath) {
            this.image3FilePath = image3FilePath;
        }

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

        public String getRichText1() {
            return richText1;
        }

        public void setRichText1(String richText1) {
            this.richText1 = richText1;
        }

        public String getRichText2() {
            return richText2;
        }

        public void setRichText2(String richText2) {
            this.richText2 = richText2;
        }

        public String getRichText3() {
            return richText3;
        }

        public void setRichText3(String richText2) {
            this.richText3 = richText3;
        }
    }
}
