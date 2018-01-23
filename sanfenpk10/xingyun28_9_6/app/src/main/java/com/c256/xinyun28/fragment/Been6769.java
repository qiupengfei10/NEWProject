package com.c256.xinyun28.fragment;

/**
 * Created by qiupengfei on 2017/11/6.
 */
public class Been6769 {
    private String id;

    private String url;


    private String type;


    private String show_url;


    private String appid;


    private String comment;


    private String createAt;


    private String updateAt;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public String getUrl(){
        return this.url;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setShow_url(String show_url){
        this.show_url = show_url;
    }
    public String getShow_url(){
        return this.show_url;
    }
    public void setAppid(String appid){
        this.appid = appid;
    }
    public String getAppid(){
        return this.appid;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    public String getComment(){
        return this.comment;
    }
    public void setCreateAt(String createAt){
        this.createAt = createAt;
    }
    public String getCreateAt(){
        return this.createAt;
    }
    public void setUpdateAt(String updateAt){
        this.updateAt = updateAt;
    }
    public String getUpdateAt(){
        return this.updateAt;
    }

    public class Root {
        private Been6769 data;

        private String rt_code;

        public void setData(Been6769 data){
            this.data = data;
        }
        public Been6769 getData(){
            return this.data;
        }
        public void setRt_code(String rt_code){
            this.rt_code = rt_code;
        }
        public String getRt_code(){
            return this.rt_code;
        }

    }
}
