package com.c256.xinyun28.fragment;

/**
 * Created by pfei on 2017/8/25.
 */
public class Been2 {private String iswap;

    private String ismust;

    private String wapurl;

    private String upurl;

    private String appurl;

    public void setIswap(String iswap){
        this.iswap = iswap;
    }
    public String getIswap(){
        return this.iswap;
    }
    public void setIsmust(String ismust){
        this.ismust = ismust;
    }
    public String getIsmust(){
        return this.ismust;
    }
    public void setWapurl(String wapurl){
        this.wapurl = wapurl;
    }
    public String getWapurl(){
        return this.wapurl;
    }
    public void setUpurl(String upurl){
        this.upurl = upurl;
    }
    public String getUpurl(){
        return this.upurl;
    }
    public void setAppurl(String appurl){
        this.appurl = appurl;
    }
    public String getAppurl(){
        return this.appurl;
    }
    public class Root {
        private String code;

        private Been2 data;

        private String cookie;

        public void setCode(String code){
            this.code = code;
        }
        public String getCode(){
            return this.code;
        }
        public void setData(Been2 data){
            this.data = data;
        }
        public Been2 getData(){
            return this.data;
        }
        public void setCookie(String cookie){
            this.cookie = cookie;
        }
        public String getCookie(){
            return this.cookie;
        }

    }

}
