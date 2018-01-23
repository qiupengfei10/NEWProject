package com.c256.xinyun28;

/**
 * Created by qiupengfei on 2017/logo/10.
 */
public class Been {

    /**
     * id : 64
     * url : http://m.6769c.com
     * type : android
     * show_url : 0
     * appid : 20178101
     * comment : 应用宝
     * createAt : 2017-08-01 18:16:16
     * updateAt : 2017-08-01 18:28:44
     */

    private DataBean data;
    /**
     * data : {"id":"64","url":"http://m.6769c.com","type":"android","show_url":"0","appid":"20178101","comment":"应用宝","createAt":"2017-08-01 18:16:16","updateAt":"2017-08-01 18:28:44"}
     * rt_code : 200
     */

    private String rt_code;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getRt_code() {
        return rt_code;
    }

    public void setRt_code(String rt_code) {
        this.rt_code = rt_code;
    }

    public static class DataBean {
        private String id;
        private String url;
        private String type;
        private String show_url;
        private String appid;
        private String comment;
        private String createAt;
        private String updateAt;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getShow_url() {
            return show_url;
        }

        public void setShow_url(String show_url) {
            this.show_url = show_url;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getCreateAt() {
            return createAt;
        }

        public void setCreateAt(String createAt) {
            this.createAt = createAt;
        }

        public String getUpdateAt() {
            return updateAt;
        }

        public void setUpdateAt(String updateAt) {
            this.updateAt = updateAt;
        }
    }

}
