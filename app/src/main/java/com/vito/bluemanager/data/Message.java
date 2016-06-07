package com.vito.bluemanager.data;

/**
 * @Description: TODO
 * @Created by Zhangfeng on 2016/6/6.
 * @ModifiedBy: Clowire51
 * @ModifiedTime: 2016/6/6 15:11
 * @ModifiedNotes:
 * @Version
 */
public final class Message {

    private int mId;
    private String mUserName;
    private String mMsg;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getMsg() {
        return mMsg;
    }

    public void setMsg(String msg) {
        mMsg = msg;
    }
}
