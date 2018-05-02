package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

public class DanMuMsgEntity implements DataEntity {
    private static final Gson GSON = new Gson();
    private static final Type STRING_LIST_TYPE = new TypeToken<List<String>>() {
    }.getType();

    /**
     * info : [[0,1,25,16777215,1520664535,1662637384,0,"88874b7b",0],"czpnb",[15723776,"Dough君",0,0,0,"10000",1,""],[],[10,0,9868950,">50000"],[],0,0,{"uname_color":""}]
     * cmd : DANMU_MSG
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("info")
    private JsonArray info;

    @Override
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public JsonArray getInfo() {
        return info;
    }

    public void setInfo(JsonArray info) {
        this.info = info;
    }

    /**
     * 弹幕池 (0 普通 1 字幕 2 特殊)
     */
    public int getPool() {
        return info.get(0).getAsJsonArray().get(0).getAsInt();
    }

    /**
     * 弹幕的模式 (1 普通 4 底端 5 顶端 6 逆向 7 特殊 9 高级)
     */
    public int getMode() {
        return info.get(0).getAsJsonArray().get(1).getAsInt();
    }

    /**
     * 字体大小
     */
    public int getFontSize() {
        return info.get(0).getAsJsonArray().get(2).getAsInt();
    }

    /**
     * 字体颜色
     */
    public int getColor() {
        return info.get(0).getAsJsonArray().get(3).getAsInt();
    }

    /**
     * 弹幕发送时间(Unix 时间戳)(其实是服务器接收到弹幕的时间)
     */
    public long getSendTime() {
        return info.get(0).getAsJsonArray().get(4).getAsInt();
    }

    /**
     * 用户进入房间的时间(Unix 时间戳)(但是 Android 发送的弹幕, 这个值会是随机数)
     */
    public String getUserEnterTime() {
        return info.get(0).getAsJsonArray().get(5).getAsString();
    }

    /**
     * 弹幕内容
     */
    public String getMessage() {
        return info.get(1).getAsString();
    }

    /**
     * 发送者的用户 ID
     */
    public long getUserId() {
        return info.get(2).getAsJsonArray().get(0).getAsLong();
    }

    /**
     * 发送者的用户名
     */
    public String getUsername() {
        return info.get(2).getAsJsonArray().get(1).getAsString();
    }

    /**
     * 发送者是否是管理员
     */
    public boolean isAdmin() {
        return info.get(2).getAsJsonArray().get(2).getAsBoolean();
    }

    /**
     * 发送者是否是 VIP
     */
    public boolean isVip() {
        return info.get(2).getAsJsonArray().get(3).getAsBoolean();
    }

    /**
     * 发送者是否是 SVip
     */
    public boolean isSVip() {
        return info.get(2).getAsJsonArray().get(4).getAsBoolean();
    }

    /**
     * 表示粉丝勋章有关信息的 JsonArray 可能是空的
     * 获取粉丝勋章等级
     */
    public Optional<Integer> getFansMedalLevel() {
        if (info.get(3).getAsJsonArray().size() > 0) {
            return Optional.of(info.get(3).getAsJsonArray().get(0).getAsInt());
        } else {
            return Optional.empty();
        }
    }

    /**
     * 获取粉丝勋章名称
     */
    public Optional<String> getFansMedalName() {
        if (info.get(3).getAsJsonArray().size() > 0) {
            return Optional.of(info.get(3).getAsJsonArray().get(1).getAsString());
        } else {
            return Optional.empty();
        }
    }

    /**
     * 粉丝勋章对应的主播的名字
     */
    public Optional<String> getFansMedalOwnerName() {
        if (info.get(3).getAsJsonArray().size() > 0) {
            return Optional.of(info.get(3).getAsJsonArray().get(2).getAsString());
        } else {
            return Optional.empty();
        }
    }

    /**
     * 粉丝勋章对应的主播的直播间 ID
     */
    public Optional<String> getFansMedalOwnerRoomId() {
        if (info.get(3).getAsJsonArray().size() > 0) {
            return Optional.of(info.get(3).getAsJsonArray().get(3).getAsString());
        } else {
            return Optional.empty();
        }
    }

    /**
     * 用户的观众等级
     */
    public int getUserLevel() {
        return info.get(4).getAsJsonArray().get(0).getAsInt();
    }

    /**
     * 用户的观众等级排名
     */
    public String getUserRank() {
        return info.get(4).getAsJsonArray().get(3).getAsString();
    }

    /**
     * 用户头衔
     */
    public List<String> getUserTitles() {
        return GSON.fromJson(info.get(5), STRING_LIST_TYPE);
    }

    /**
     * 用户名颜色
     */
    public String getUsernameColor() {
        return info.get(8).getAsJsonObject().get("uname_color").getAsString();
    }
}
