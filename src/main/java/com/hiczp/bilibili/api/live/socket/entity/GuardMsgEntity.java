package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class GuardMsgEntity implements DataEntity {
    /**
     * cmd : GUARD_MSG
     * msg : 乘客 :?想不想joice:? 成功购买1313366房间总督船票1张，欢迎登船！
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("msg")
    private String msg;

    @Override
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
