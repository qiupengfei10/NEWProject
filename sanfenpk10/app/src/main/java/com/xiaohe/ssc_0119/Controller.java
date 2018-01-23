package com.xiaohe.ssc_0119;

/**
 * Created by qiupengfei on 2017/8/10.
 */
public class Controller {

    /**
     * success : false
     * hint : 请在10分钟内联系开发人员，否则后果自负，联系人QQ:1715120163
     * time : 1000000000000000
     */

    private boolean success;
    private String hint;
    private long time;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
