package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResponseEntity extends ResponseEntity {
    /**
     * code : 0
     * message : OK
     * data : {"page":1,"pagesize":20,"type":"all","room":{"list":[{"roomid":23058,"cover":"//i0.hdslb.com/bfs/live/6029764557e3cbe91475faae26e6e244de8c1d3c.jpg","title":"哔哩哔哩音悦台","name":"3号直播间","face":"//i0.hdslb.com/bfs/face/5d35da6e93fbfb1a77ad6d1f1004b08413913f9a.jpg","online":33717},{"roomid":5962096,"cover":"//i0.hdslb.com/bfs/live/245c47d1e4e7d3ef72915b81ab595fc8c42b7b7e.jpg","title":"新年快乐~好番随机播~","name":"廃喵苦涩酱","face":"//i2.hdslb.com/bfs/face/ebf0eed5436ebd44bf3c60ae770d32ffcd374fcf.jpg","online":5912},{"roomid":157901,"cover":"//i0.hdslb.com/bfs/live/dfe541ff1b1cc5002c324206e997698b2f7aef97.jpg","title":"祈愿屋","name":"我丶好期待","face":"//i1.hdslb.com/bfs/face/48e49865e68124909dad37d61d71ea1c2a3891f2.jpg","online":5855},{"roomid":2703501,"cover":"//i0.hdslb.com/bfs/live/f68beb49d7ccda19a6e17119d216b2d64bad7726.jpg","title":"【灵魂ASMR】同人带老司机重温初体验","name":"兮夜素玄","face":"//i2.hdslb.com/bfs/face/728c4579896fae6357b985646802dcca00e6b88b.jpg","online":5641},{"roomid":35278,"cover":"//i0.hdslb.com/bfs/live/fc8e195f9208506db6fa174aaf9340cf711df660.jpg","title":"新年快乐~米娜桑 好听的音乐直播","name":"智障喵兔w","face":"//i2.hdslb.com/bfs/face/6e5b9196fd84f91320745d5e432b920d750600f2.jpg","online":2534},{"roomid":10101,"cover":"//i0.hdslb.com/bfs/live/7ea796080b68ef514f890ebcbca47203d0c56c6a.jpg","title":"东方同人音乐博物馆","name":"猫耳爱丽丝","face":"//i2.hdslb.com/bfs/face/f864e65a5fc9820c3e814a58e6afefae6aedc794.jpg","online":1268},{"roomid":357983,"cover":"//i0.hdslb.com/bfs/live/78ffda1e4a604c680d1b545ff510998f2ae4d007.jpg","title":"【韩国女团音乐点播间】","name":"大豆爷爷","face":"//i2.hdslb.com/bfs/face/e9211b74cfaead11362e3a84f8b4c920a5b06d0f.jpg","online":937},{"roomid":38946,"cover":"//i0.hdslb.com/bfs/live/2f613f107f4f189f136c8626febc77fa261233ca.jpg","title":"【不是特别攻的音】好听算我输！","name":"散华落叶","face":"//i1.hdslb.com/bfs/face/85ea0bf53ce0f1a6fbefe2472f087416ddc7c18b.jpg","online":682},{"roomid":4394069,"cover":"//i0.hdslb.com/bfs/live/66cc11d95ab71f271d127bcb71d510873b9494d5.jpg","title":"韩国男团点播间","name":"大豆奶奶","face":"//i1.hdslb.com/bfs/face/2fe279e573fbf726531a7dc6fd8071b83af76654.jpg","online":655},{"roomid":4369521,"cover":"//i0.hdslb.com/bfs/live/342f10b170327d8566027783327328ec4b48c720.jpg","title":"QQ飞车：新年快乐哟~","name":"一只欧尼酱丶","face":"//i0.hdslb.com/bfs/face/fc3a953eaa1bd70139a55bfec862eee764431c67.jpg","online":576},{"roomid":1149702,"cover":"//i0.hdslb.com/bfs/live/b41656c693fbea3914b0620621818a332916854a.jpg","title":"嘤嘤嘤怪点歌聊天台","name":"Kyoko释怀","face":"//i2.hdslb.com/bfs/face/8ff5ec6ce92685f974941d9bf8a496c8326ca3e0.jpg","online":377},{"roomid":144784,"cover":"//i0.hdslb.com/bfs/live/5a331b65c855c38ebb458e476870f974b82c1626.jpg","title":"【音乐厅】玖式随机大法","name":"玖兰yuiki","face":"//i2.hdslb.com/bfs/face/bb4d4173bcea989969bacd40d11c00006d68fcf5.jpg","online":357},{"roomid":406117,"cover":"//i0.hdslb.com/bfs/live/46560258e2bd41752c1540e1e8cb86a1d68bc682.jpg","title":"T-ARA 皇冠团 节日快乐 :D","name":"湛蓝初一","face":"//i0.hdslb.com/bfs/face/142af67a3bf12cc98b0bc1685493ede585942d84.jpg","online":249},{"roomid":416695,"cover":"//i0.hdslb.com/bfs/live/3ae3593bd9e589473504ebe831c2962df216c79a.jpg","title":"私人歌单，带耳机进。。","name":"flwjn","face":"//i1.hdslb.com/bfs/face/a809a3b8407840ae00032360108261fcf503d38a.jpg","online":243},{"roomid":29922,"cover":"//i0.hdslb.com/bfs/live/88ca857b0c0b7d387b653d6c64754e320b8fc4bf.jpg","title":"全天直播_东方_V家_萌耳系_二次元环绕","name":"いぬやしゃ_Inuyasha","face":"//i1.hdslb.com/bfs/face/9532691338e471aa5e9d31d28e7664e1ce155123.jpg","online":187},{"roomid":449326,"cover":"//i0.hdslb.com/bfs/live/c597dd333c14e60c7067c171d8fac5d49d92ffaa.jpg","title":"深夜睡眠小电台，可点轻音乐，听歌睡觉哦!","name":"小月丿痕","face":"//i2.hdslb.com/bfs/face/6c464efb32385926487ea424fd8d7a6fd16fc114.jpg","online":151},{"roomid":400766,"cover":"//i0.hdslb.com/bfs/live/ca1e7a9e487ca8f5f25c8eea538e65308473775b.jpg","title":"始于侧颜，沉于歌声，忠于马尾。","name":"龙虾呀","face":"//i1.hdslb.com/bfs/face/8d535760d3390dcccd306008529c98691e27033a.gif","online":147},{"roomid":71423,"cover":"//i0.hdslb.com/bfs/live/7c3965e5f2bd1e2247c3de156fc4b8b6bcb063b7.jpg","title":"Forever音乐屋","name":"匚凵冂","face":"//i1.hdslb.com/bfs/face/d9a98f83554fa287d4a5ca6ed6e5add1a35fbe85.jpg","online":109},{"roomid":2570641,"cover":"//i0.hdslb.com/bfs/live/d8d4c634684cbfc2bc80f12bbee963aa30e71b2b.jpg","title":"24小时网易云音乐vip点歌台","name":"0点后的活动不要叫夜猫","face":"//i1.hdslb.com/bfs/face/09e3fc6b785af00e2d524b9552cdfb370408c54a.jpg","online":84},{"roomid":10724,"cover":"//i0.hdslb.com/bfs/live/82c87e28c5d5546523eab3833d4aaaba465697ea.jpg","title":"新年打猛汉 欢迎组队","name":"天空夜明","face":"//i2.hdslb.com/bfs/face/6a28cb05aed94e1d649d4268a79c3d389b62f365.jpg","online":77}],"total_room":43,"total_page":3},"user":{"list":[{"face":"//i1.hdslb.com/bfs/face/a1b248975dcc42dec34c9b097c5ce3b1b4d6f7bb.jpg","name":"聆听の音乐","live_status":1,"areaName":"放映厅","fansNum":165,"roomTags":["洛天依","天依音悦台","天依"],"roomid":4355580},{"face":"//i0.hdslb.com/bfs/face/12156a3a2f014475c8bdd12d3778570f54587563.jpg","name":"满汉全席音乐团队","live_status":0,"areaName":"生活娱乐","fansNum":1569325,"roomTags":["唱歌","音乐","纯男声"],"roomid":55041},{"face":"//i2.hdslb.com/bfs/face/311c0cf25085a795dcf63bea312caa1edbebd9ca.jpg","name":"我是爱音乐的徐梦圆","live_status":0,"areaName":"单机联机","fansNum":368129,"roomTags":["守望先锋"],"roomid":286662},{"face":"//i2.hdslb.com/bfs/face/5773186b159cb3dfdfba6ef5ad7290c67b824a78.jpg","name":"歌者盟音乐","live_status":0,"areaName":"单机游戏","fansNum":141748,"roomTags":[""],"roomid":923438},{"face":"//i0.hdslb.com/bfs/face/8539f20190ffa7a1d337cd96c4e5ec37fc6ad0b1.jpg","name":"趣弹音乐","live_status":0,"areaName":"生活娱乐","fansNum":83258,"roomTags":[""],"roomid":930041},{"face":"//i0.hdslb.com/bfs/face/bd95e148b71c496449ae3e0a92ad17bce963a9a5.jpg","name":"SOE音乐课堂","live_status":0,"areaName":"生活娱乐","fansNum":62832,"roomTags":["声乐培训"],"roomid":285435},{"face":"//i2.hdslb.com/bfs/face/9fa8bcb0ef1843a585a47fbc73eb02d22dcf7e10.jpg","name":"养心音乐","live_status":0,"areaName":"单机游戏","fansNum":57998,"roomTags":[""],"roomid":4238998},{"face":"//i2.hdslb.com/bfs/face/1540e9eb03abef032a1315327130505d12ef0af3.jpg","name":"馒头音乐","live_status":0,"areaName":"单机游戏","fansNum":55741,"roomTags":[""],"roomid":1357493},{"face":"//i2.hdslb.com/bfs/face/6563b8eea46d7c51d2f58346501637a4e3e1b406.jpg","name":"古风音乐会","live_status":0,"areaName":"单机游戏","fansNum":54934,"roomTags":[""],"roomid":214816},{"face":"//i0.hdslb.com/bfs/face/70caba75dc7c635a0553b2ac4d0b82e55b28829b.jpg","name":"嗨的国风音乐","live_status":0,"areaName":"唱见舞见","fansNum":52707,"roomTags":["古琴"],"roomid":3214656},{"face":"//i2.hdslb.com/bfs/face/904f9263c5a28743977af9139962304d2eb5143e.jpg","name":"白熊音乐Ukulele","live_status":0,"areaName":"单机游戏","fansNum":47957,"roomTags":[""],"roomid":2852510},{"face":"//i1.hdslb.com/bfs/face/255bd6d66d2e0f03603b37e7f1d9bdc86cd38abc.jpg","name":"不要音乐","live_status":0,"areaName":"单机游戏","fansNum":39059,"roomTags":[""],"roomid":1216095},{"face":"//i1.hdslb.com/bfs/face/ea674e951d97d05d1d228660004e8c14d2f046cc.jpg","name":"亮声音乐","live_status":0,"areaName":"单机游戏","fansNum":38554,"roomTags":[""],"roomid":4959493},{"face":"//i2.hdslb.com/bfs/face/9d299e94dc1834353fea7d5f0a5ecb5b1f4d575c.jpg","name":"音乐学霸哥e","live_status":0,"areaName":"单机游戏","fansNum":35614,"roomTags":[""],"roomid":947738},{"face":"//i0.hdslb.com/bfs/face/371b13b4831c1e1b0999989f270c36922bff3d05.jpg","name":"迷因爱音乐","live_status":0,"areaName":"放映厅","fansNum":33092,"roomTags":["电音"],"roomid":3971679},{"face":"//i0.hdslb.com/bfs/face/63175628b06158ceefe8f329ff0761cf28038304.jpg","name":"鸾凤鸣原创音乐","live_status":0,"areaName":"单机游戏","fansNum":27338,"roomTags":[""],"roomid":677243},{"face":"//i2.hdslb.com/bfs/face/4c09fba674efbeeb97cf6219428d66d8b58ae978.jpg","name":"音乐大爆炸-老赵LD","live_status":0,"areaName":"单机联机","fansNum":23997,"roomTags":[""],"roomid":741247},{"face":"//i2.hdslb.com/bfs/face/e22a63b0cf7afd74076fb6214f80bd8528ce8b5b.jpg","name":"音乐人网","live_status":0,"areaName":"生活娱乐","fansNum":22164,"roomTags":["教学","编曲","混音","后期","音乐制作"],"roomid":93751},{"face":"//i2.hdslb.com/bfs/face/bb06e15a84a2f52b0eca3b56260e6b7af3af95a9.jpg","name":"MikaiMusic未开封音乐","live_status":0,"areaName":"单机游戏","fansNum":21813,"roomTags":[""],"roomid":5379747},{"face":"//i0.hdslb.com/bfs/face/d17ddb244a783fa8179c362209080c48716beebf.jpg","name":"唯一音乐小魔王","live_status":0,"areaName":"单机游戏","fansNum":21317,"roomTags":[""],"roomid":9020709}],"total_user":1000,"total_page":50}}
     */

    @SerializedName("code")
    private int code;
    @SerializedName("data")
    private Data data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        /**
         * page : 1
         * pagesize : 20
         * type : all
         * room : {"list":[{"roomid":23058,"cover":"//i0.hdslb.com/bfs/live/6029764557e3cbe91475faae26e6e244de8c1d3c.jpg","title":"哔哩哔哩音悦台","name":"3号直播间","face":"//i0.hdslb.com/bfs/face/5d35da6e93fbfb1a77ad6d1f1004b08413913f9a.jpg","online":33717},{"roomid":5962096,"cover":"//i0.hdslb.com/bfs/live/245c47d1e4e7d3ef72915b81ab595fc8c42b7b7e.jpg","title":"新年快乐~好番随机播~","name":"廃喵苦涩酱","face":"//i2.hdslb.com/bfs/face/ebf0eed5436ebd44bf3c60ae770d32ffcd374fcf.jpg","online":5912},{"roomid":157901,"cover":"//i0.hdslb.com/bfs/live/dfe541ff1b1cc5002c324206e997698b2f7aef97.jpg","title":"祈愿屋","name":"我丶好期待","face":"//i1.hdslb.com/bfs/face/48e49865e68124909dad37d61d71ea1c2a3891f2.jpg","online":5855},{"roomid":2703501,"cover":"//i0.hdslb.com/bfs/live/f68beb49d7ccda19a6e17119d216b2d64bad7726.jpg","title":"【灵魂ASMR】同人带老司机重温初体验","name":"兮夜素玄","face":"//i2.hdslb.com/bfs/face/728c4579896fae6357b985646802dcca00e6b88b.jpg","online":5641},{"roomid":35278,"cover":"//i0.hdslb.com/bfs/live/fc8e195f9208506db6fa174aaf9340cf711df660.jpg","title":"新年快乐~米娜桑 好听的音乐直播","name":"智障喵兔w","face":"//i2.hdslb.com/bfs/face/6e5b9196fd84f91320745d5e432b920d750600f2.jpg","online":2534},{"roomid":10101,"cover":"//i0.hdslb.com/bfs/live/7ea796080b68ef514f890ebcbca47203d0c56c6a.jpg","title":"东方同人音乐博物馆","name":"猫耳爱丽丝","face":"//i2.hdslb.com/bfs/face/f864e65a5fc9820c3e814a58e6afefae6aedc794.jpg","online":1268},{"roomid":357983,"cover":"//i0.hdslb.com/bfs/live/78ffda1e4a604c680d1b545ff510998f2ae4d007.jpg","title":"【韩国女团音乐点播间】","name":"大豆爷爷","face":"//i2.hdslb.com/bfs/face/e9211b74cfaead11362e3a84f8b4c920a5b06d0f.jpg","online":937},{"roomid":38946,"cover":"//i0.hdslb.com/bfs/live/2f613f107f4f189f136c8626febc77fa261233ca.jpg","title":"【不是特别攻的音】好听算我输！","name":"散华落叶","face":"//i1.hdslb.com/bfs/face/85ea0bf53ce0f1a6fbefe2472f087416ddc7c18b.jpg","online":682},{"roomid":4394069,"cover":"//i0.hdslb.com/bfs/live/66cc11d95ab71f271d127bcb71d510873b9494d5.jpg","title":"韩国男团点播间","name":"大豆奶奶","face":"//i1.hdslb.com/bfs/face/2fe279e573fbf726531a7dc6fd8071b83af76654.jpg","online":655},{"roomid":4369521,"cover":"//i0.hdslb.com/bfs/live/342f10b170327d8566027783327328ec4b48c720.jpg","title":"QQ飞车：新年快乐哟~","name":"一只欧尼酱丶","face":"//i0.hdslb.com/bfs/face/fc3a953eaa1bd70139a55bfec862eee764431c67.jpg","online":576},{"roomid":1149702,"cover":"//i0.hdslb.com/bfs/live/b41656c693fbea3914b0620621818a332916854a.jpg","title":"嘤嘤嘤怪点歌聊天台","name":"Kyoko释怀","face":"//i2.hdslb.com/bfs/face/8ff5ec6ce92685f974941d9bf8a496c8326ca3e0.jpg","online":377},{"roomid":144784,"cover":"//i0.hdslb.com/bfs/live/5a331b65c855c38ebb458e476870f974b82c1626.jpg","title":"【音乐厅】玖式随机大法","name":"玖兰yuiki","face":"//i2.hdslb.com/bfs/face/bb4d4173bcea989969bacd40d11c00006d68fcf5.jpg","online":357},{"roomid":406117,"cover":"//i0.hdslb.com/bfs/live/46560258e2bd41752c1540e1e8cb86a1d68bc682.jpg","title":"T-ARA 皇冠团 节日快乐 :D","name":"湛蓝初一","face":"//i0.hdslb.com/bfs/face/142af67a3bf12cc98b0bc1685493ede585942d84.jpg","online":249},{"roomid":416695,"cover":"//i0.hdslb.com/bfs/live/3ae3593bd9e589473504ebe831c2962df216c79a.jpg","title":"私人歌单，带耳机进。。","name":"flwjn","face":"//i1.hdslb.com/bfs/face/a809a3b8407840ae00032360108261fcf503d38a.jpg","online":243},{"roomid":29922,"cover":"//i0.hdslb.com/bfs/live/88ca857b0c0b7d387b653d6c64754e320b8fc4bf.jpg","title":"全天直播_东方_V家_萌耳系_二次元环绕","name":"いぬやしゃ_Inuyasha","face":"//i1.hdslb.com/bfs/face/9532691338e471aa5e9d31d28e7664e1ce155123.jpg","online":187},{"roomid":449326,"cover":"//i0.hdslb.com/bfs/live/c597dd333c14e60c7067c171d8fac5d49d92ffaa.jpg","title":"深夜睡眠小电台，可点轻音乐，听歌睡觉哦!","name":"小月丿痕","face":"//i2.hdslb.com/bfs/face/6c464efb32385926487ea424fd8d7a6fd16fc114.jpg","online":151},{"roomid":400766,"cover":"//i0.hdslb.com/bfs/live/ca1e7a9e487ca8f5f25c8eea538e65308473775b.jpg","title":"始于侧颜，沉于歌声，忠于马尾。","name":"龙虾呀","face":"//i1.hdslb.com/bfs/face/8d535760d3390dcccd306008529c98691e27033a.gif","online":147},{"roomid":71423,"cover":"//i0.hdslb.com/bfs/live/7c3965e5f2bd1e2247c3de156fc4b8b6bcb063b7.jpg","title":"Forever音乐屋","name":"匚凵冂","face":"//i1.hdslb.com/bfs/face/d9a98f83554fa287d4a5ca6ed6e5add1a35fbe85.jpg","online":109},{"roomid":2570641,"cover":"//i0.hdslb.com/bfs/live/d8d4c634684cbfc2bc80f12bbee963aa30e71b2b.jpg","title":"24小时网易云音乐vip点歌台","name":"0点后的活动不要叫夜猫","face":"//i1.hdslb.com/bfs/face/09e3fc6b785af00e2d524b9552cdfb370408c54a.jpg","online":84},{"roomid":10724,"cover":"//i0.hdslb.com/bfs/live/82c87e28c5d5546523eab3833d4aaaba465697ea.jpg","title":"新年打猛汉 欢迎组队","name":"天空夜明","face":"//i2.hdslb.com/bfs/face/6a28cb05aed94e1d649d4268a79c3d389b62f365.jpg","online":77}],"total_room":43,"total_page":3}
         * user : {"list":[{"face":"//i1.hdslb.com/bfs/face/a1b248975dcc42dec34c9b097c5ce3b1b4d6f7bb.jpg","name":"聆听の音乐","live_status":1,"areaName":"放映厅","fansNum":165,"roomTags":["洛天依","天依音悦台","天依"],"roomid":4355580},{"face":"//i0.hdslb.com/bfs/face/12156a3a2f014475c8bdd12d3778570f54587563.jpg","name":"满汉全席音乐团队","live_status":0,"areaName":"生活娱乐","fansNum":1569325,"roomTags":["唱歌","音乐","纯男声"],"roomid":55041},{"face":"//i2.hdslb.com/bfs/face/311c0cf25085a795dcf63bea312caa1edbebd9ca.jpg","name":"我是爱音乐的徐梦圆","live_status":0,"areaName":"单机联机","fansNum":368129,"roomTags":["守望先锋"],"roomid":286662},{"face":"//i2.hdslb.com/bfs/face/5773186b159cb3dfdfba6ef5ad7290c67b824a78.jpg","name":"歌者盟音乐","live_status":0,"areaName":"单机游戏","fansNum":141748,"roomTags":[""],"roomid":923438},{"face":"//i0.hdslb.com/bfs/face/8539f20190ffa7a1d337cd96c4e5ec37fc6ad0b1.jpg","name":"趣弹音乐","live_status":0,"areaName":"生活娱乐","fansNum":83258,"roomTags":[""],"roomid":930041},{"face":"//i0.hdslb.com/bfs/face/bd95e148b71c496449ae3e0a92ad17bce963a9a5.jpg","name":"SOE音乐课堂","live_status":0,"areaName":"生活娱乐","fansNum":62832,"roomTags":["声乐培训"],"roomid":285435},{"face":"//i2.hdslb.com/bfs/face/9fa8bcb0ef1843a585a47fbc73eb02d22dcf7e10.jpg","name":"养心音乐","live_status":0,"areaName":"单机游戏","fansNum":57998,"roomTags":[""],"roomid":4238998},{"face":"//i2.hdslb.com/bfs/face/1540e9eb03abef032a1315327130505d12ef0af3.jpg","name":"馒头音乐","live_status":0,"areaName":"单机游戏","fansNum":55741,"roomTags":[""],"roomid":1357493},{"face":"//i2.hdslb.com/bfs/face/6563b8eea46d7c51d2f58346501637a4e3e1b406.jpg","name":"古风音乐会","live_status":0,"areaName":"单机游戏","fansNum":54934,"roomTags":[""],"roomid":214816},{"face":"//i0.hdslb.com/bfs/face/70caba75dc7c635a0553b2ac4d0b82e55b28829b.jpg","name":"嗨的国风音乐","live_status":0,"areaName":"唱见舞见","fansNum":52707,"roomTags":["古琴"],"roomid":3214656},{"face":"//i2.hdslb.com/bfs/face/904f9263c5a28743977af9139962304d2eb5143e.jpg","name":"白熊音乐Ukulele","live_status":0,"areaName":"单机游戏","fansNum":47957,"roomTags":[""],"roomid":2852510},{"face":"//i1.hdslb.com/bfs/face/255bd6d66d2e0f03603b37e7f1d9bdc86cd38abc.jpg","name":"不要音乐","live_status":0,"areaName":"单机游戏","fansNum":39059,"roomTags":[""],"roomid":1216095},{"face":"//i1.hdslb.com/bfs/face/ea674e951d97d05d1d228660004e8c14d2f046cc.jpg","name":"亮声音乐","live_status":0,"areaName":"单机游戏","fansNum":38554,"roomTags":[""],"roomid":4959493},{"face":"//i2.hdslb.com/bfs/face/9d299e94dc1834353fea7d5f0a5ecb5b1f4d575c.jpg","name":"音乐学霸哥e","live_status":0,"areaName":"单机游戏","fansNum":35614,"roomTags":[""],"roomid":947738},{"face":"//i0.hdslb.com/bfs/face/371b13b4831c1e1b0999989f270c36922bff3d05.jpg","name":"迷因爱音乐","live_status":0,"areaName":"放映厅","fansNum":33092,"roomTags":["电音"],"roomid":3971679},{"face":"//i0.hdslb.com/bfs/face/63175628b06158ceefe8f329ff0761cf28038304.jpg","name":"鸾凤鸣原创音乐","live_status":0,"areaName":"单机游戏","fansNum":27338,"roomTags":[""],"roomid":677243},{"face":"//i2.hdslb.com/bfs/face/4c09fba674efbeeb97cf6219428d66d8b58ae978.jpg","name":"音乐大爆炸-老赵LD","live_status":0,"areaName":"单机联机","fansNum":23997,"roomTags":[""],"roomid":741247},{"face":"//i2.hdslb.com/bfs/face/e22a63b0cf7afd74076fb6214f80bd8528ce8b5b.jpg","name":"音乐人网","live_status":0,"areaName":"生活娱乐","fansNum":22164,"roomTags":["教学","编曲","混音","后期","音乐制作"],"roomid":93751},{"face":"//i2.hdslb.com/bfs/face/bb06e15a84a2f52b0eca3b56260e6b7af3af95a9.jpg","name":"MikaiMusic未开封音乐","live_status":0,"areaName":"单机游戏","fansNum":21813,"roomTags":[""],"roomid":5379747},{"face":"//i0.hdslb.com/bfs/face/d17ddb244a783fa8179c362209080c48716beebf.jpg","name":"唯一音乐小魔王","live_status":0,"areaName":"单机游戏","fansNum":21317,"roomTags":[""],"roomid":9020709}],"total_user":1000,"total_page":50}
         */

        @SerializedName("page")
        private long page;
        @SerializedName("pagesize")
        private long pageSize;
        @SerializedName("type")
        private String type;
        @SerializedName("room")
        private Room room;
        @SerializedName("user")
        private User user;

        public long getPage() {
            return page;
        }

        public void setPage(long page) {
            this.page = page;
        }

        public long getPageSize() {
            return pageSize;
        }

        public void setPageSize(long pageSize) {
            this.pageSize = pageSize;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Room getRoom() {
            return room;
        }

        public void setRoom(Room room) {
            this.room = room;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public static class Room {
            /**
             * list : [{"roomid":23058,"cover":"//i0.hdslb.com/bfs/live/6029764557e3cbe91475faae26e6e244de8c1d3c.jpg","title":"哔哩哔哩音悦台","name":"3号直播间","face":"//i0.hdslb.com/bfs/face/5d35da6e93fbfb1a77ad6d1f1004b08413913f9a.jpg","online":33717},{"roomid":5962096,"cover":"//i0.hdslb.com/bfs/live/245c47d1e4e7d3ef72915b81ab595fc8c42b7b7e.jpg","title":"新年快乐~好番随机播~","name":"廃喵苦涩酱","face":"//i2.hdslb.com/bfs/face/ebf0eed5436ebd44bf3c60ae770d32ffcd374fcf.jpg","online":5912},{"roomid":157901,"cover":"//i0.hdslb.com/bfs/live/dfe541ff1b1cc5002c324206e997698b2f7aef97.jpg","title":"祈愿屋","name":"我丶好期待","face":"//i1.hdslb.com/bfs/face/48e49865e68124909dad37d61d71ea1c2a3891f2.jpg","online":5855},{"roomid":2703501,"cover":"//i0.hdslb.com/bfs/live/f68beb49d7ccda19a6e17119d216b2d64bad7726.jpg","title":"【灵魂ASMR】同人带老司机重温初体验","name":"兮夜素玄","face":"//i2.hdslb.com/bfs/face/728c4579896fae6357b985646802dcca00e6b88b.jpg","online":5641},{"roomid":35278,"cover":"//i0.hdslb.com/bfs/live/fc8e195f9208506db6fa174aaf9340cf711df660.jpg","title":"新年快乐~米娜桑 好听的音乐直播","name":"智障喵兔w","face":"//i2.hdslb.com/bfs/face/6e5b9196fd84f91320745d5e432b920d750600f2.jpg","online":2534},{"roomid":10101,"cover":"//i0.hdslb.com/bfs/live/7ea796080b68ef514f890ebcbca47203d0c56c6a.jpg","title":"东方同人音乐博物馆","name":"猫耳爱丽丝","face":"//i2.hdslb.com/bfs/face/f864e65a5fc9820c3e814a58e6afefae6aedc794.jpg","online":1268},{"roomid":357983,"cover":"//i0.hdslb.com/bfs/live/78ffda1e4a604c680d1b545ff510998f2ae4d007.jpg","title":"【韩国女团音乐点播间】","name":"大豆爷爷","face":"//i2.hdslb.com/bfs/face/e9211b74cfaead11362e3a84f8b4c920a5b06d0f.jpg","online":937},{"roomid":38946,"cover":"//i0.hdslb.com/bfs/live/2f613f107f4f189f136c8626febc77fa261233ca.jpg","title":"【不是特别攻的音】好听算我输！","name":"散华落叶","face":"//i1.hdslb.com/bfs/face/85ea0bf53ce0f1a6fbefe2472f087416ddc7c18b.jpg","online":682},{"roomid":4394069,"cover":"//i0.hdslb.com/bfs/live/66cc11d95ab71f271d127bcb71d510873b9494d5.jpg","title":"韩国男团点播间","name":"大豆奶奶","face":"//i1.hdslb.com/bfs/face/2fe279e573fbf726531a7dc6fd8071b83af76654.jpg","online":655},{"roomid":4369521,"cover":"//i0.hdslb.com/bfs/live/342f10b170327d8566027783327328ec4b48c720.jpg","title":"QQ飞车：新年快乐哟~","name":"一只欧尼酱丶","face":"//i0.hdslb.com/bfs/face/fc3a953eaa1bd70139a55bfec862eee764431c67.jpg","online":576},{"roomid":1149702,"cover":"//i0.hdslb.com/bfs/live/b41656c693fbea3914b0620621818a332916854a.jpg","title":"嘤嘤嘤怪点歌聊天台","name":"Kyoko释怀","face":"//i2.hdslb.com/bfs/face/8ff5ec6ce92685f974941d9bf8a496c8326ca3e0.jpg","online":377},{"roomid":144784,"cover":"//i0.hdslb.com/bfs/live/5a331b65c855c38ebb458e476870f974b82c1626.jpg","title":"【音乐厅】玖式随机大法","name":"玖兰yuiki","face":"//i2.hdslb.com/bfs/face/bb4d4173bcea989969bacd40d11c00006d68fcf5.jpg","online":357},{"roomid":406117,"cover":"//i0.hdslb.com/bfs/live/46560258e2bd41752c1540e1e8cb86a1d68bc682.jpg","title":"T-ARA 皇冠团 节日快乐 :D","name":"湛蓝初一","face":"//i0.hdslb.com/bfs/face/142af67a3bf12cc98b0bc1685493ede585942d84.jpg","online":249},{"roomid":416695,"cover":"//i0.hdslb.com/bfs/live/3ae3593bd9e589473504ebe831c2962df216c79a.jpg","title":"私人歌单，带耳机进。。","name":"flwjn","face":"//i1.hdslb.com/bfs/face/a809a3b8407840ae00032360108261fcf503d38a.jpg","online":243},{"roomid":29922,"cover":"//i0.hdslb.com/bfs/live/88ca857b0c0b7d387b653d6c64754e320b8fc4bf.jpg","title":"全天直播_东方_V家_萌耳系_二次元环绕","name":"いぬやしゃ_Inuyasha","face":"//i1.hdslb.com/bfs/face/9532691338e471aa5e9d31d28e7664e1ce155123.jpg","online":187},{"roomid":449326,"cover":"//i0.hdslb.com/bfs/live/c597dd333c14e60c7067c171d8fac5d49d92ffaa.jpg","title":"深夜睡眠小电台，可点轻音乐，听歌睡觉哦!","name":"小月丿痕","face":"//i2.hdslb.com/bfs/face/6c464efb32385926487ea424fd8d7a6fd16fc114.jpg","online":151},{"roomid":400766,"cover":"//i0.hdslb.com/bfs/live/ca1e7a9e487ca8f5f25c8eea538e65308473775b.jpg","title":"始于侧颜，沉于歌声，忠于马尾。","name":"龙虾呀","face":"//i1.hdslb.com/bfs/face/8d535760d3390dcccd306008529c98691e27033a.gif","online":147},{"roomid":71423,"cover":"//i0.hdslb.com/bfs/live/7c3965e5f2bd1e2247c3de156fc4b8b6bcb063b7.jpg","title":"Forever音乐屋","name":"匚凵冂","face":"//i1.hdslb.com/bfs/face/d9a98f83554fa287d4a5ca6ed6e5add1a35fbe85.jpg","online":109},{"roomid":2570641,"cover":"//i0.hdslb.com/bfs/live/d8d4c634684cbfc2bc80f12bbee963aa30e71b2b.jpg","title":"24小时网易云音乐vip点歌台","name":"0点后的活动不要叫夜猫","face":"//i1.hdslb.com/bfs/face/09e3fc6b785af00e2d524b9552cdfb370408c54a.jpg","online":84},{"roomid":10724,"cover":"//i0.hdslb.com/bfs/live/82c87e28c5d5546523eab3833d4aaaba465697ea.jpg","title":"新年打猛汉 欢迎组队","name":"天空夜明","face":"//i2.hdslb.com/bfs/face/6a28cb05aed94e1d649d4268a79c3d389b62f365.jpg","online":77}]
             * total_room : 43
             * total_page : 3
             */

            @SerializedName("total_room")
            private long totalRoom;
            @SerializedName("total_page")
            private long totalPage;
            @SerializedName("list")
            private List<RoomData> list;

            public long getTotalRoom() {
                return totalRoom;
            }

            public void setTotalRoom(long totalRoom) {
                this.totalRoom = totalRoom;
            }

            public long getTotalPage() {
                return totalPage;
            }

            public void setTotalPage(long totalPage) {
                this.totalPage = totalPage;
            }

            public List<RoomData> getList() {
                return list;
            }

            public void setList(List<RoomData> list) {
                this.list = list;
            }

            public static class RoomData {
                /**
                 * roomid : 23058
                 * cover : //i0.hdslb.com/bfs/live/6029764557e3cbe91475faae26e6e244de8c1d3c.jpg
                 * title : 哔哩哔哩音悦台
                 * name : 3号直播间
                 * face : //i0.hdslb.com/bfs/face/5d35da6e93fbfb1a77ad6d1f1004b08413913f9a.jpg
                 * online : 33717
                 */

                @SerializedName("roomid")
                private long roomId;
                @SerializedName("cover")
                private String cover;
                @SerializedName("title")
                private String title;
                @SerializedName("name")
                private String name;
                @SerializedName("face")
                private String face;
                @SerializedName("online")
                private int online;

                public long getRoomId() {
                    return roomId;
                }

                public void setRoomId(long roomId) {
                    this.roomId = roomId;
                }

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getFace() {
                    return face;
                }

                public void setFace(String face) {
                    this.face = face;
                }

                public int getOnline() {
                    return online;
                }

                public void setOnline(int online) {
                    this.online = online;
                }
            }
        }

        public static class User {
            /**
             * list : [{"face":"//i1.hdslb.com/bfs/face/a1b248975dcc42dec34c9b097c5ce3b1b4d6f7bb.jpg","name":"聆听の音乐","live_status":1,"areaName":"放映厅","fansNum":165,"roomTags":["洛天依","天依音悦台","天依"],"roomid":4355580},{"face":"//i0.hdslb.com/bfs/face/12156a3a2f014475c8bdd12d3778570f54587563.jpg","name":"满汉全席音乐团队","live_status":0,"areaName":"生活娱乐","fansNum":1569325,"roomTags":["唱歌","音乐","纯男声"],"roomid":55041},{"face":"//i2.hdslb.com/bfs/face/311c0cf25085a795dcf63bea312caa1edbebd9ca.jpg","name":"我是爱音乐的徐梦圆","live_status":0,"areaName":"单机联机","fansNum":368129,"roomTags":["守望先锋"],"roomid":286662},{"face":"//i2.hdslb.com/bfs/face/5773186b159cb3dfdfba6ef5ad7290c67b824a78.jpg","name":"歌者盟音乐","live_status":0,"areaName":"单机游戏","fansNum":141748,"roomTags":[""],"roomid":923438},{"face":"//i0.hdslb.com/bfs/face/8539f20190ffa7a1d337cd96c4e5ec37fc6ad0b1.jpg","name":"趣弹音乐","live_status":0,"areaName":"生活娱乐","fansNum":83258,"roomTags":[""],"roomid":930041},{"face":"//i0.hdslb.com/bfs/face/bd95e148b71c496449ae3e0a92ad17bce963a9a5.jpg","name":"SOE音乐课堂","live_status":0,"areaName":"生活娱乐","fansNum":62832,"roomTags":["声乐培训"],"roomid":285435},{"face":"//i2.hdslb.com/bfs/face/9fa8bcb0ef1843a585a47fbc73eb02d22dcf7e10.jpg","name":"养心音乐","live_status":0,"areaName":"单机游戏","fansNum":57998,"roomTags":[""],"roomid":4238998},{"face":"//i2.hdslb.com/bfs/face/1540e9eb03abef032a1315327130505d12ef0af3.jpg","name":"馒头音乐","live_status":0,"areaName":"单机游戏","fansNum":55741,"roomTags":[""],"roomid":1357493},{"face":"//i2.hdslb.com/bfs/face/6563b8eea46d7c51d2f58346501637a4e3e1b406.jpg","name":"古风音乐会","live_status":0,"areaName":"单机游戏","fansNum":54934,"roomTags":[""],"roomid":214816},{"face":"//i0.hdslb.com/bfs/face/70caba75dc7c635a0553b2ac4d0b82e55b28829b.jpg","name":"嗨的国风音乐","live_status":0,"areaName":"唱见舞见","fansNum":52707,"roomTags":["古琴"],"roomid":3214656},{"face":"//i2.hdslb.com/bfs/face/904f9263c5a28743977af9139962304d2eb5143e.jpg","name":"白熊音乐Ukulele","live_status":0,"areaName":"单机游戏","fansNum":47957,"roomTags":[""],"roomid":2852510},{"face":"//i1.hdslb.com/bfs/face/255bd6d66d2e0f03603b37e7f1d9bdc86cd38abc.jpg","name":"不要音乐","live_status":0,"areaName":"单机游戏","fansNum":39059,"roomTags":[""],"roomid":1216095},{"face":"//i1.hdslb.com/bfs/face/ea674e951d97d05d1d228660004e8c14d2f046cc.jpg","name":"亮声音乐","live_status":0,"areaName":"单机游戏","fansNum":38554,"roomTags":[""],"roomid":4959493},{"face":"//i2.hdslb.com/bfs/face/9d299e94dc1834353fea7d5f0a5ecb5b1f4d575c.jpg","name":"音乐学霸哥e","live_status":0,"areaName":"单机游戏","fansNum":35614,"roomTags":[""],"roomid":947738},{"face":"//i0.hdslb.com/bfs/face/371b13b4831c1e1b0999989f270c36922bff3d05.jpg","name":"迷因爱音乐","live_status":0,"areaName":"放映厅","fansNum":33092,"roomTags":["电音"],"roomid":3971679},{"face":"//i0.hdslb.com/bfs/face/63175628b06158ceefe8f329ff0761cf28038304.jpg","name":"鸾凤鸣原创音乐","live_status":0,"areaName":"单机游戏","fansNum":27338,"roomTags":[""],"roomid":677243},{"face":"//i2.hdslb.com/bfs/face/4c09fba674efbeeb97cf6219428d66d8b58ae978.jpg","name":"音乐大爆炸-老赵LD","live_status":0,"areaName":"单机联机","fansNum":23997,"roomTags":[""],"roomid":741247},{"face":"//i2.hdslb.com/bfs/face/e22a63b0cf7afd74076fb6214f80bd8528ce8b5b.jpg","name":"音乐人网","live_status":0,"areaName":"生活娱乐","fansNum":22164,"roomTags":["教学","编曲","混音","后期","音乐制作"],"roomid":93751},{"face":"//i2.hdslb.com/bfs/face/bb06e15a84a2f52b0eca3b56260e6b7af3af95a9.jpg","name":"MikaiMusic未开封音乐","live_status":0,"areaName":"单机游戏","fansNum":21813,"roomTags":[""],"roomid":5379747},{"face":"//i0.hdslb.com/bfs/face/d17ddb244a783fa8179c362209080c48716beebf.jpg","name":"唯一音乐小魔王","live_status":0,"areaName":"单机游戏","fansNum":21317,"roomTags":[""],"roomid":9020709}]
             * total_user : 1000
             * total_page : 50
             */

            @SerializedName("total_user")
            private long totalUser;
            @SerializedName("total_page")
            private long totalPage;
            @SerializedName("list")
            private List<UserData> list;

            public long getTotalUser() {
                return totalUser;
            }

            public void setTotalUser(long totalUser) {
                this.totalUser = totalUser;
            }

            public long getTotalPage() {
                return totalPage;
            }

            public void setTotalPage(long totalPage) {
                this.totalPage = totalPage;
            }

            public List<UserData> getList() {
                return list;
            }

            public void setList(List<UserData> list) {
                this.list = list;
            }

            public static class UserData {
                /**
                 * face : //i1.hdslb.com/bfs/face/a1b248975dcc42dec34c9b097c5ce3b1b4d6f7bb.jpg
                 * name : 聆听の音乐
                 * live_status : 1
                 * areaName : 放映厅
                 * fansNum : 165
                 * roomTags : ["洛天依","天依音悦台","天依"]
                 * roomid : 4355580
                 */

                @SerializedName("face")
                private String face;
                @SerializedName("name")
                private String name;
                @SerializedName("live_status")
                private int liveStatus;
                @SerializedName("areaName")
                private String areaName;
                @SerializedName("fansNum")
                private long fansNum;
                @SerializedName("roomid")
                private long roomId;
                @SerializedName("roomTags")
                private List<String> roomTags;

                public String getFace() {
                    return face;
                }

                public void setFace(String face) {
                    this.face = face;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getLiveStatus() {
                    return liveStatus;
                }

                public void setLiveStatus(int liveStatus) {
                    this.liveStatus = liveStatus;
                }

                public String getAreaName() {
                    return areaName;
                }

                public void setAreaName(String areaName) {
                    this.areaName = areaName;
                }

                public long getFansNum() {
                    return fansNum;
                }

                public void setFansNum(long fansNum) {
                    this.fansNum = fansNum;
                }

                public long getRoomId() {
                    return roomId;
                }

                public void setRoomId(long roomId) {
                    this.roomId = roomId;
                }

                public List<String> getRoomTags() {
                    return roomTags;
                }

                public void setRoomTags(List<String> roomTags) {
                    this.roomTags = roomTags;
                }
            }
        }
    }
}
