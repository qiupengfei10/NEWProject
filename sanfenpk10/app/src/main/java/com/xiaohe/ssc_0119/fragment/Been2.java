package com.xiaohe.ssc_0119.fragment;

/**
 * Created by pfei on 2017/8/25.
 */
public class Been2 {


    /**
     * code : 200
     * data : {"iswap":"0","ismust":"0","wapurl":"","upurl":"","appurl":""}
     * cookie : t_skey=0f0ccde5b88dc48aa1662d5978619c87; path=/; HttpOnly
     */

    private String code;
    /**
     * iswap : 0
     * ismust : 0
     * wapurl :
     * upurl :
     * appurl :
     */

    private DataBean data;
    private String cookie;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public static class DataBean {
        private String iswap;
        private String ismust;
        private String wapurl;
        private String upurl;
        private String appurl;

        public String getIswap() {
            return iswap;
        }

        public void setIswap(String iswap) {
            this.iswap = iswap;
        }

        public String getIsmust() {
            return ismust;
        }

        public void setIsmust(String ismust) {
            this.ismust = ismust;
        }

        public String getWapurl() {
            return wapurl;
        }

        public void setWapurl(String wapurl) {
            this.wapurl = wapurl;
        }

        public String getUpurl() {
            return upurl;
        }

        public void setUpurl(String upurl) {
            this.upurl = upurl;
        }

        public String getAppurl() {
            return appurl;
        }

        public void setAppurl(String appurl) {
            this.appurl = appurl;
        }
    }
}
