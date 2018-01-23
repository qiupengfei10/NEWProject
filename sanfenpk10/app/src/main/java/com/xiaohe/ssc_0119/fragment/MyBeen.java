package com.xiaohe.ssc_0119.fragment;

import java.io.Serializable;

/**
 * Created by qiupengfei on 2017/12/13.
 */
public class MyBeen implements Serializable{

    /**
     * code : 200
     * data : {"iswap":"0","ismust":"0","wapurl":"https://apk.kosungames.com/app-wfccp-release.apk","upurl":"方框色       aabb_707  jhl579937@163.com benzhu（已经绑定手机号）","appurl":"http://mobile.baidu.com/item?docid=22987085&source=s1001","isUpdate":true,"updateUrl":"https://apk.kosungames.com/app-wfccp-release.apk","background":""}
     */

    private String code;
    /**
     * iswap : 0
     * ismust : 0
     * wapurl : https://apk.kosungames.com/app-wfccp-release.apk
     * upurl : 方框色       aabb_707  jhl579937@163.com benzhu（已经绑定手机号）
     * appurl : http://mobile.baidu.com/item?docid=22987085&source=s1001
     * isUpdate : true
     * updateUrl : https://apk.kosungames.com/app-wfccp-release.apk
     * background :
     */

    private DataBean data;

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

    public static class DataBean implements Serializable {
        private String iswap;
        private String ismust;
        private String wapurl;
        private String upurl;
        private String appurl;
        private boolean isUpdate;
        private String updateUrl;
        private String background;

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

        public boolean isIsUpdate() {
            return isUpdate;
        }

        public void setIsUpdate(boolean isUpdate) {
            this.isUpdate = isUpdate;
        }

        public String getUpdateUrl() {
            return updateUrl;
        }

        public void setUpdateUrl(String updateUrl) {
            this.updateUrl = updateUrl;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }
    }
}
