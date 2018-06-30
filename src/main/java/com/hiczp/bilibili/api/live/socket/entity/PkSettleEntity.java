package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class PkSettleEntity implements DataEntity {
    /**
     * cmd : PK_SETTLE
     * pk_id : 8806
     * pk_status : 400
     * data : {"pk_id":8806,"init_info":{"uid":7799328,"init_id":10979759,"uname":"筱宇淅淅","face":"http://i0.hdslb.com/bfs/face/e16515ac39329aa125bb8de5bb1fa9455f06337c.jpg","votes":0,"is_winner":false},"match_info":{"uid":18654316,"match_id":430063,"uname":"卖丸子尕害羞","face":"http://i1.hdslb.com/bfs/face/1c579a244ec0c66bbb6e2ad6c770a2a498268735.jpg","votes":129,"is_winner":true,"vip_type":0,"exp":{"color":5805790,"user_level":31,"master_level":{"level":26,"color":10512625}},"vip":{"vip":0,"svip":0},"face_frame":"","badge":{"url":"http://i0.hdslb.com/bfs/live/74b2f9a48ce14d752dd27559c4a0df297243a3fd.png","desc":"bilibili直播签约主播\r\n","position":3}},"best_user":{"uid":31459309,"uname":"七友球球","face":"http://i1.hdslb.com/bfs/face/09406a4fe632dda9d523da14f3e3735ee02efbab.jpg","vip_type":0,"exp":{"color":6406234,"user_level":19,"master_level":{"level":1,"color":6406234}},"vip":{"vip":0,"svip":0},"privilege_type":0,"face_frame":"","badge":{"url":"","desc":"","position":0}},"punish_topic":"惩罚：模仿一款表情包"}
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("pk_id")
    private long pkId;
    @SerializedName("pk_status")
    private int pkStatus;
    @SerializedName("data")
    private Data data;

    @Override
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public long getPkId() {
        return pkId;
    }

    public void setPkId(long pkId) {
        this.pkId = pkId;
    }

    public int getPkStatus() {
        return pkStatus;
    }

    public void setPkStatus(int pkStatus) {
        this.pkStatus = pkStatus;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        /**
         * pk_id : 8806
         * init_info : {"uid":7799328,"init_id":10979759,"uname":"筱宇淅淅","face":"http://i0.hdslb.com/bfs/face/e16515ac39329aa125bb8de5bb1fa9455f06337c.jpg","votes":0,"is_winner":false}
         * match_info : {"uid":18654316,"match_id":430063,"uname":"卖丸子尕害羞","face":"http://i1.hdslb.com/bfs/face/1c579a244ec0c66bbb6e2ad6c770a2a498268735.jpg","votes":129,"is_winner":true,"vip_type":0,"exp":{"color":5805790,"user_level":31,"master_level":{"level":26,"color":10512625}},"vip":{"vip":0,"svip":0},"face_frame":"","badge":{"url":"http://i0.hdslb.com/bfs/live/74b2f9a48ce14d752dd27559c4a0df297243a3fd.png","desc":"bilibili直播签约主播\r\n","position":3}}
         * best_user : {"uid":31459309,"uname":"七友球球","face":"http://i1.hdslb.com/bfs/face/09406a4fe632dda9d523da14f3e3735ee02efbab.jpg","vip_type":0,"exp":{"color":6406234,"user_level":19,"master_level":{"level":1,"color":6406234}},"vip":{"vip":0,"svip":0},"privilege_type":0,"face_frame":"","badge":{"url":"","desc":"","position":0}}
         * punish_topic : 惩罚：模仿一款表情包
         */

        @SerializedName("pk_id")
        private long pkId;
        @SerializedName("init_info")
        private InitInfo initInfo;
        @SerializedName("match_info")
        private MatchInfo matchInfo;
        @SerializedName("best_user")
        private BestUser bestUser;
        @SerializedName("punish_topic")
        private String punishTopic;

        public long getPkId() {
            return pkId;
        }

        public void setPkId(long pkId) {
            this.pkId = pkId;
        }

        public InitInfo getInitInfo() {
            return initInfo;
        }

        public void setInitInfo(InitInfo initInfo) {
            this.initInfo = initInfo;
        }

        public MatchInfo getMatchInfo() {
            return matchInfo;
        }

        public void setMatchInfo(MatchInfo matchInfo) {
            this.matchInfo = matchInfo;
        }

        public BestUser getBestUser() {
            return bestUser;
        }

        public void setBestUser(BestUser bestUser) {
            this.bestUser = bestUser;
        }

        public String getPunishTopic() {
            return punishTopic;
        }

        public void setPunishTopic(String punishTopic) {
            this.punishTopic = punishTopic;
        }

        public static class InitInfo {
            /**
             * uid : 7799328
             * init_id : 10979759
             * uname : 筱宇淅淅
             * face : http://i0.hdslb.com/bfs/face/e16515ac39329aa125bb8de5bb1fa9455f06337c.jpg
             * votes : 0
             * is_winner : false
             */

            @SerializedName("uid")
            private long userId;
            @SerializedName("init_id")
            private long initId;
            @SerializedName("uname")
            private String username;
            @SerializedName("face")
            private String face;
            @SerializedName("votes")
            private int votes;
            @SerializedName("is_winner")
            private boolean isWinner;

            public long getUserId() {
                return userId;
            }

            public void setUserId(long userId) {
                this.userId = userId;
            }

            public long getInitId() {
                return initId;
            }

            public void setInitId(long initId) {
                this.initId = initId;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getFace() {
                return face;
            }

            public void setFace(String face) {
                this.face = face;
            }

            public int getVotes() {
                return votes;
            }

            public void setVotes(int votes) {
                this.votes = votes;
            }

            public boolean isIsWinner() {
                return isWinner;
            }

            public void setIsWinner(boolean isWinner) {
                this.isWinner = isWinner;
            }
        }

        public static class MatchInfo {
            /**
             * uid : 18654316
             * match_id : 430063
             * uname : 卖丸子尕害羞
             * face : http://i1.hdslb.com/bfs/face/1c579a244ec0c66bbb6e2ad6c770a2a498268735.jpg
             * votes : 129
             * is_winner : true
             * vip_type : 0
             * exp : {"color":5805790,"user_level":31,"master_level":{"level":26,"color":10512625}}
             * vip : {"vip":0,"svip":0}
             * face_frame :
             * badge : {"url":"http://i0.hdslb.com/bfs/live/74b2f9a48ce14d752dd27559c4a0df297243a3fd.png","desc":"bilibili直播签约主播\r\n","position":3}
             */

            @SerializedName("uid")
            private long userId;
            @SerializedName("match_id")
            private long matchId;
            @SerializedName("uname")
            private String username;
            @SerializedName("face")
            private String face;
            @SerializedName("votes")
            private int votes;
            @SerializedName("is_winner")
            private boolean isWinner;
            @SerializedName("vip_type")
            private int vipType;
            @SerializedName("exp")
            private Exp exp;
            @SerializedName("vip")
            private Vip vip;
            @SerializedName("face_frame")
            private String faceFrame;
            @SerializedName("badge")
            private Badge badge;

            public long getUserId() {
                return userId;
            }

            public void setUserId(long userId) {
                this.userId = userId;
            }

            public long getMatchId() {
                return matchId;
            }

            public void setMatchId(long matchId) {
                this.matchId = matchId;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getFace() {
                return face;
            }

            public void setFace(String face) {
                this.face = face;
            }

            public int getVotes() {
                return votes;
            }

            public void setVotes(int votes) {
                this.votes = votes;
            }

            public boolean isIsWinner() {
                return isWinner;
            }

            public void setIsWinner(boolean isWinner) {
                this.isWinner = isWinner;
            }

            public int getVipType() {
                return vipType;
            }

            public void setVipType(int vipType) {
                this.vipType = vipType;
            }

            public Exp getExp() {
                return exp;
            }

            public void setExp(Exp exp) {
                this.exp = exp;
            }

            public Vip getVip() {
                return vip;
            }

            public void setVip(Vip vip) {
                this.vip = vip;
            }

            public String getFaceFrame() {
                return faceFrame;
            }

            public void setFaceFrame(String faceFrame) {
                this.faceFrame = faceFrame;
            }

            public Badge getBadge() {
                return badge;
            }

            public void setBadge(Badge badge) {
                this.badge = badge;
            }

            public static class Exp {
                /**
                 * color : 5805790
                 * user_level : 31
                 * master_level : {"level":26,"color":10512625}
                 */

                @SerializedName("color")
                private int color;
                @SerializedName("user_level")
                private int userLevel;
                @SerializedName("master_level")
                private MasterLevel masterLevel;

                public int getColor() {
                    return color;
                }

                public void setColor(int color) {
                    this.color = color;
                }

                public int getUserLevel() {
                    return userLevel;
                }

                public void setUserLevel(int userLevel) {
                    this.userLevel = userLevel;
                }

                public MasterLevel getMasterLevel() {
                    return masterLevel;
                }

                public void setMasterLevel(MasterLevel masterLevel) {
                    this.masterLevel = masterLevel;
                }

                public static class MasterLevel {
                    /**
                     * level : 26
                     * color : 10512625
                     */

                    @SerializedName("level")
                    private int level;
                    @SerializedName("color")
                    private int color;

                    public int getLevel() {
                        return level;
                    }

                    public void setLevel(int level) {
                        this.level = level;
                    }

                    public int getColor() {
                        return color;
                    }

                    public void setColor(int color) {
                        this.color = color;
                    }
                }
            }

            public static class Vip {
                /**
                 * vip : 0
                 * svip : 0
                 */

                @SerializedName("vip")
                private int vip;
                @SerializedName("svip")
                private int svip;

                public int getVip() {
                    return vip;
                }

                public void setVip(int vip) {
                    this.vip = vip;
                }

                public int getSvip() {
                    return svip;
                }

                public void setSvip(int svip) {
                    this.svip = svip;
                }
            }

            public static class Badge {
                /**
                 * url : http://i0.hdslb.com/bfs/live/74b2f9a48ce14d752dd27559c4a0df297243a3fd.png
                 * desc : bilibili直播签约主播
                 * <p>
                 * position : 3
                 */

                @SerializedName("url")
                private String url;
                @SerializedName("desc")
                private String description;
                @SerializedName("position")
                private int position;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public int getPosition() {
                    return position;
                }

                public void setPosition(int position) {
                    this.position = position;
                }
            }
        }

        public static class BestUser {
            /**
             * uid : 31459309
             * uname : 七友球球
             * face : http://i1.hdslb.com/bfs/face/09406a4fe632dda9d523da14f3e3735ee02efbab.jpg
             * vip_type : 0
             * exp : {"color":6406234,"user_level":19,"master_level":{"level":1,"color":6406234}}
             * vip : {"vip":0,"svip":0}
             * privilege_type : 0
             * face_frame :
             * badge : {"url":"","desc":"","position":0}
             */

            @SerializedName("uid")
            private long userId;
            @SerializedName("uname")
            private String username;
            @SerializedName("face")
            private String face;
            @SerializedName("vip_type")
            private int vipType;
            @SerializedName("exp")
            private ExpX exp;
            @SerializedName("vip")
            private VipX vip;
            @SerializedName("privilege_type")
            private int privilegeType;
            @SerializedName("face_frame")
            private String faceFrame;
            @SerializedName("badge")
            private BadgeX badge;

            public long getUserId() {
                return userId;
            }

            public void setUserId(long userId) {
                this.userId = userId;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getFace() {
                return face;
            }

            public void setFace(String face) {
                this.face = face;
            }

            public int getVipType() {
                return vipType;
            }

            public void setVipType(int vipType) {
                this.vipType = vipType;
            }

            public ExpX getExp() {
                return exp;
            }

            public void setExp(ExpX exp) {
                this.exp = exp;
            }

            public VipX getVip() {
                return vip;
            }

            public void setVip(VipX vip) {
                this.vip = vip;
            }

            public int getPrivilegeType() {
                return privilegeType;
            }

            public void setPrivilegeType(int privilegeType) {
                this.privilegeType = privilegeType;
            }

            public String getFaceFrame() {
                return faceFrame;
            }

            public void setFaceFrame(String faceFrame) {
                this.faceFrame = faceFrame;
            }

            public BadgeX getBadge() {
                return badge;
            }

            public void setBadge(BadgeX badge) {
                this.badge = badge;
            }

            public static class ExpX {
                /**
                 * color : 6406234
                 * user_level : 19
                 * master_level : {"level":1,"color":6406234}
                 */

                @SerializedName("color")
                private int color;
                @SerializedName("user_level")
                private int userLevel;
                @SerializedName("master_level")
                private MasterLevelX masterLevel;

                public int getColor() {
                    return color;
                }

                public void setColor(int color) {
                    this.color = color;
                }

                public int getUserLevel() {
                    return userLevel;
                }

                public void setUserLevel(int userLevel) {
                    this.userLevel = userLevel;
                }

                public MasterLevelX getMasterLevel() {
                    return masterLevel;
                }

                public void setMasterLevel(MasterLevelX masterLevel) {
                    this.masterLevel = masterLevel;
                }

                public static class MasterLevelX {
                    /**
                     * level : 1
                     * color : 6406234
                     */

                    @SerializedName("level")
                    private int level;
                    @SerializedName("color")
                    private int color;

                    public int getLevel() {
                        return level;
                    }

                    public void setLevel(int level) {
                        this.level = level;
                    }

                    public int getColor() {
                        return color;
                    }

                    public void setColor(int color) {
                        this.color = color;
                    }
                }
            }

            public static class VipX {
                /**
                 * vip : 0
                 * svip : 0
                 */

                @SerializedName("vip")
                private int vip;
                @SerializedName("svip")
                private int svip;

                public int getVip() {
                    return vip;
                }

                public void setVip(int vip) {
                    this.vip = vip;
                }

                public int getSvip() {
                    return svip;
                }

                public void setSvip(int svip) {
                    this.svip = svip;
                }
            }

            public static class BadgeX {
                /**
                 * url :
                 * desc :
                 * position : 0
                 */

                @SerializedName("url")
                private String url;
                @SerializedName("desc")
                private String description;
                @SerializedName("position")
                private int position;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public int getPosition() {
                    return position;
                }

                public void setPosition(int position) {
                    this.position = position;
                }
            }
        }
    }
}
