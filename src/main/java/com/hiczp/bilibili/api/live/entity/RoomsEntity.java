package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RoomsEntity extends ResponseEntity {
    /**
     * code : 0
     * message : ok
     * data : [{"owner":{"face":"https://i1.hdslb.com/bfs/face/5be61949369dd844cc459eab808da151d8c363d2.gif","mid":4548018,"name":"扎双马尾的丧尸"},"cover":{"src":"https://i0.hdslb.com/bfs/live/1f260f3bba18fc329f49a545d1b7c7d7810290bf.jpg","height":180,"width":320},"title":"软萌的熊熊丧","room_id":48499,"online":527628,"playurl":"http://txy.live-play.acgvideo.com/live-txy/851545/live_4548018_332_c521e483.flv?wsSecret=c56fa32194f2dcf33c6f3652bbe69b86&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"御宅文化","area_id":2,"on_flag":0,"round_status":0,"area_v2_id":30,"area_v2_name":"ASMR ","area_v2_parent_id":1,"area_v2_parent_name":"娱乐"},{"owner":{"face":"https://i1.hdslb.com/bfs/face/f7de62c2ebb3f80b4cccdc11de2d1a5ad1eaa553.jpg","mid":16836724,"name":"育碧中国Ubisoft"},"cover":{"src":"https://i0.hdslb.com/bfs/live/c04da150093e404c34794fe69c921db1473a64b5.jpg","height":180,"width":320},"title":"《彩虹六号：围攻》国际邀请赛","room_id":274763,"online":189922,"playurl":"http://live-play.acgvideo.com/live/592/live_16836724_1555083.flv?wsSecret=8a83af6d8f86cc5ccfe1cc6c75d73886&wsTime=5a623875","accept_quality":"4","broadcast_type":0,"area":"单机联机","area_id":1,"on_flag":0,"round_status":0,"area_v2_id":65,"area_v2_name":"彩虹六号","area_v2_parent_id":2,"area_v2_parent_name":"游戏"},{"owner":{"face":"https://i1.hdslb.com/bfs/face/6bbeb93dd72c60cb7ad2e876b241d0360d7f0d38.gif","mid":164627,"name":"杆菌无敌"},"cover":{"src":"https://i0.hdslb.com/bfs/live/3b7f754a5abf9e27dc48c53ce07ac856010f1017.jpg","height":180,"width":320},"title":"【杆菌】新年215航天！我又™飞了","room_id":26057,"online":178263,"playurl":"http://js.live-play.acgvideo.com/live-js/350504/live_164627_2722814.flv?wsSecret=7f36641cccd47f1ed04d46424b4e968d&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"手游直播","area_id":12,"on_flag":0,"round_status":0,"area_v2_id":37,"area_v2_name":"Fate/GO","area_v2_parent_id":3,"area_v2_parent_name":"手游"},{"owner":{"face":"https://i1.hdslb.com/bfs/face/3ad90d135227e822fc939217b26191e2bff238c9.jpg","mid":75,"name":"丸子"},"cover":{"src":"https://i0.hdslb.com/bfs/live/3ec00d93e7dc4a1eab97882461c99b58ec1a3545.jpg","height":180,"width":320},"title":"【FGO】215剑式血祭，新年福袋","room_id":11713,"online":152795,"playurl":"http://txy.live-play.acgvideo.com/live-txy/591292/live_75_5343444.flv?wsSecret=b6f94cb867df6e72d93599017a75eeec&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"手游直播","area_id":12,"on_flag":0,"round_status":0,"area_v2_id":37,"area_v2_name":"Fate/GO","area_v2_parent_id":3,"area_v2_parent_name":"手游"},{"owner":{"face":"https://i2.hdslb.com/bfs/face/288f13d1f589a3d6386d022044fbc10b705cab4f.jpg","mid":20848957,"name":"风竹教主解说"},"cover":{"src":"https://i0.hdslb.com/bfs/live/e45d8e74090431aa91d8749a6b4ada6dd2de768e.jpg","height":180,"width":320},"title":"狗年的第十七只鸡！","room_id":66688,"online":122416,"playurl":"http://qn.live-play.acgvideo.com/live-qn/589040/live_20848957_7290944.flv?wsSecret=76ab1a782de8705d5a9e89c1af4cb390&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"单机联机","area_id":1,"on_flag":0,"round_status":0,"area_v2_id":80,"area_v2_name":"绝地求生：大逃杀","area_v2_parent_id":2,"area_v2_parent_name":"游戏"},{"owner":{"face":"https://i1.hdslb.com/bfs/face/b8bd2c79fe59196a5aae3aa66105b684c316e565.jpg","mid":11616487,"name":"绝不早到小吱吱"},"cover":{"src":"https://i0.hdslb.com/bfs/live/6deca6a5f2801050901c47b4993f8ca48676f9ac.jpg","height":180,"width":320},"title":"aSMr萝莉御姐陪你入睡","room_id":3495920,"online":108598,"playurl":"http://xl.live-play.acgvideo.com/live-xl/503206/live_11616487_4809373.flv?wsSecret=5f115b778892b6ffaa416d36b8331488&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"御宅文化","area_id":2,"on_flag":0,"round_status":0,"area_v2_id":30,"area_v2_name":"ASMR ","area_v2_parent_id":1,"area_v2_parent_name":"娱乐"},{"owner":{"face":"https://i2.hdslb.com/bfs/face/dd383c48ab9dd1f97d0c907f92406d65db9f0cbd.jpg","mid":11783152,"name":"不要吃咖喱"},"cover":{"src":"https://i0.hdslb.com/bfs/live/3206c8cb59cbe289d4aea477fc2e914cdf330327.jpg","height":180,"width":320},"title":"ASMR酥软萝莉 甜甜的撩爆你233","room_id":360972,"online":105773,"playurl":"http://dl.live-play.acgvideo.com/live-dl/244745/live_11783152_3987869.flv?wsSecret=0319cb71735b733a5cf184343b49c176&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"御宅文化","area_id":2,"on_flag":0,"round_status":0,"area_v2_id":30,"area_v2_name":"ASMR ","area_v2_parent_id":1,"area_v2_parent_name":"娱乐"},{"owner":{"face":"https://i2.hdslb.com/bfs/face/3908006b2086c3180bb4fa303745b79f6e501d2d.jpg","mid":863092,"name":"提不起劲的小明同学"},"cover":{"src":"https://i0.hdslb.com/bfs/live/7697e5e7168c75fc0aaf80ca85c0de03b861e8df.jpg","height":180,"width":320},"title":"【男声ASMR】女友视角哄睡（ づ ωど","room_id":765408,"online":82403,"playurl":"http://xl.live-play.acgvideo.com/live-xl/997008/live_863092_5946736.flv?wsSecret=8c8b95b02efa24f46f3ec495f3151811&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"御宅文化","area_id":2,"on_flag":0,"round_status":0,"area_v2_id":30,"area_v2_name":"ASMR ","area_v2_parent_id":1,"area_v2_parent_name":"娱乐"},{"owner":{"face":"https://i0.hdslb.com/bfs/face/b6b981ef5d06e5c4f4ae3e38683b35507d30877d.jpg","mid":167945180,"name":"天华华丶"},"cover":{"src":"https://i0.hdslb.com/bfs/live/bd8d9d9d714ddddbfff6b489026cbd6dfaa36144.jpg","height":180,"width":320},"title":"万物皆可野，英雄由你定！","room_id":5438584,"online":62037,"playurl":"http://qn.live-play.acgvideo.com/live-qn/683920/live_167945180_7813051.flv?wsSecret=70c297511b9f9cdd39a20513ed0a107d&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"电子竞技","area_id":4,"on_flag":0,"round_status":0,"area_v2_id":86,"area_v2_name":"英雄联盟","area_v2_parent_id":2,"area_v2_parent_name":"游戏"},{"owner":{"face":"https://i2.hdslb.com/bfs/face/79d49e85fd4b20dc762c696e1bb62e0f743a4dbb.jpg","mid":922545,"name":"yoyo鼠です"},"cover":{"src":"https://i0.hdslb.com/bfs/live/6801563bf00d507a6fb8c4fa559f7f0fea66644a.jpg","height":180,"width":320},"title":"A鼠MR 毛绒鼠哄睡觉~","room_id":75031,"online":50155,"playurl":"http://xl.live-play.acgvideo.com/live-xl/934981/live_922545_4785397.flv?wsSecret=ca63874caacf5bd4b72a99cd5aa0981d&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"御宅文化","area_id":2,"on_flag":0,"round_status":0,"area_v2_id":30,"area_v2_name":"ASMR ","area_v2_parent_id":1,"area_v2_parent_name":"娱乐"},{"owner":{"face":"https://i0.hdslb.com/bfs/face/67f01127a411016e2b20cfd3d2e088d651856f31.jpg","mid":4705522,"name":"沙拉Azusa"},"cover":{"src":"https://i0.hdslb.com/bfs/live/f6f292f4febd54942a5454629db075f11132bc40.jpg","height":180,"width":320},"title":"女装美少♂男用变声器在线gay人","room_id":933508,"online":49554,"playurl":"http://txy.live-play.acgvideo.com/live-txy/180689/live_4705522_7251458.flv?wsSecret=148b8ab0cf7b501ca0621bdfb106f6f0&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"单机联机","area_id":1,"on_flag":0,"round_status":0,"area_v2_id":80,"area_v2_name":"绝地求生：大逃杀","area_v2_parent_id":2,"area_v2_parent_name":"游戏"},{"owner":{"face":"https://i1.hdslb.com/bfs/face/b61a708015167fb7360c81bd7c77f0bab3bcf1f7.jpg","mid":4122321,"name":"轻十月"},"cover":{"src":"https://i0.hdslb.com/bfs/live/675c2e619f8c9c8a313e98029a4c81dd087f5ab9.jpg","height":180,"width":320},"title":"豹毙了解一下","room_id":44221,"online":35739,"playurl":"http://dl.live-play.acgvideo.com/live-dl/124285/live_4122321_1127441.flv?wsSecret=5ade712d747a94a1468f53bb91594661&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"手游直播","area_id":12,"on_flag":0,"round_status":0,"area_v2_id":98,"area_v2_name":"其他手游","area_v2_parent_id":3,"area_v2_parent_name":"手游"},{"owner":{"face":"https://i0.hdslb.com/bfs/face/f778b776f8d831efd44f4a4942105866b61874ef.jpg","mid":1277462,"name":"大脸Zeta"},"cover":{"src":"https://i0.hdslb.com/bfs/live/17cd7f9110b5f1facd78de4fb257a0f61c779dfb.jpg","height":180,"width":320},"title":"【男低音声控噩梦】骚话王装逼王！！","room_id":45972,"online":35584,"playurl":"http://qn.live-play.acgvideo.com/live-qn/593702/live_1277462_4305311.flv?wsSecret=453f45910a3fa58a1053f3a0b5844607&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"手游直播","area_id":12,"on_flag":0,"round_status":0,"area_v2_id":35,"area_v2_name":"王者荣耀","area_v2_parent_id":3,"area_v2_parent_name":"手游"},{"owner":{"face":"https://i2.hdslb.com/bfs/face/025fa73e3f1be9d7f4c2b10678d6a0a5a89addee.jpg","mid":1774758,"name":"青衣才不是御姐呢"},"cover":{"src":"https://i0.hdslb.com/bfs/live/d8cf633b4c8de28cb443dcbfd64105d56e2c37db.jpg","height":180,"width":320},"title":"【男友视角】好了我躺好了","room_id":5311231,"online":35319,"playurl":"http://qn.live-play.acgvideo.com/live-qn/186227/live_1774758_5060462.flv?wsSecret=77165b9cadfe80ed7f198b5f9d980065&wsTime=1518976621","accept_quality":"4","broadcast_type":1,"area":"生活娱乐","area_id":6,"on_flag":0,"round_status":0,"area_v2_id":32,"area_v2_name":"手机直播","area_v2_parent_id":1,"area_v2_parent_name":"娱乐"},{"owner":{"face":"https://i1.hdslb.com/bfs/face/c30682c5448b045e34092d9afd1e562797fb00c5.jpg","mid":539998,"name":"草莓味の小圆"},"cover":{"src":"https://i0.hdslb.com/bfs/live/837f254f529af7c07dc8533bc175eb0ae49de9fe.jpg","height":180,"width":320},"title":"Asmr酥软萝莉哄睡 欧尼酱  让你耳朵怀孕~","room_id":479592,"online":35253,"playurl":"http://js.live-play.acgvideo.com/live-js/534549/live_539998_8513862.flv?wsSecret=1cfc7b37e5a1c4d8a1027f2e982f3064&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"御宅文化","area_id":2,"on_flag":0,"round_status":0,"area_v2_id":30,"area_v2_name":"ASMR ","area_v2_parent_id":1,"area_v2_parent_name":"娱乐"},{"owner":{"face":"https://i2.hdslb.com/bfs/face/7d9cdaa07c4f350dc4ab99709facd0ca13427baa.jpg","mid":220316581,"name":"结标あわき"},"cover":{"src":"https://i0.hdslb.com/bfs/live/5a2e03fc0b64ac9035e43d8153d68df9c3f605a5.jpg","height":180,"width":320},"title":"【ASMR】性感小姐姐哄睡","room_id":7553185,"online":34655,"playurl":"http://qn.live-play.acgvideo.com/live-qn/440425/live_220316581_4804670.flv?wsSecret=d59c90f355172e7bbdd3b28dc2d2902c&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"御宅文化","area_id":2,"on_flag":0,"round_status":0,"area_v2_id":30,"area_v2_name":"ASMR ","area_v2_parent_id":1,"area_v2_parent_name":"娱乐"},{"owner":{"face":"https://i0.hdslb.com/bfs/face/6590e763ec8ad1a3ba7ed5237949c048be91a7c3.jpg","mid":1872628,"name":"枫言w"},"cover":{"src":"https://i0.hdslb.com/bfs/live/a8a67ca034125fb3b17ffffc201fe604c69e7717.jpg","height":180,"width":320},"title":"vanvan传火","room_id":1175880,"online":33828,"playurl":"http://js.live-play.acgvideo.com/live-js/103609/live_1872628_1461564.flv?wsSecret=112a8c10cf1351facd85b94e6fdcff03&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"单机联机","area_id":1,"on_flag":0,"round_status":0,"area_v2_id":107,"area_v2_name":"其他游戏","area_v2_parent_id":2,"area_v2_parent_name":"游戏"},{"owner":{"face":"https://i0.hdslb.com/bfs/face/52df2ea259b280bd22e232cc0fb9772753be4547.jpg","mid":4677463,"name":"小熊茉莉"},"cover":{"src":"https://i0.hdslb.com/bfs/live/98caca8d2e1d3e5ee5b774d50747dee253bd6f5f.jpg","height":180,"width":320},"title":"ASMR-姐妹耳骚 双层福利","room_id":43001,"online":33269,"playurl":"http://dl.live-play.acgvideo.com/live-dl/880812/live_4677463_3808573.flv?wsSecret=e9725f498943caaf5feb178d4fa99beb&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"御宅文化","area_id":2,"on_flag":0,"round_status":0,"area_v2_id":30,"area_v2_name":"ASMR ","area_v2_parent_id":1,"area_v2_parent_name":"娱乐"},{"owner":{"face":"https://i0.hdslb.com/bfs/face/c1cd432957bbd9bbb98d2c3c36849b5ad7ece7d5.jpg","mid":2976992,"name":"Alessa0"},"cover":{"src":"https://i0.hdslb.com/bfs/live/0ffd3499c297943b190d93574977587200100488.jpg","height":180,"width":320},"title":"新年好","room_id":1013,"online":32837,"playurl":"http://xl.live-play.acgvideo.com/live-xl/669277/live_2976992_332_c521e483.flv?wsSecret=c95899ae76b79e75938b68647565b273&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"单机联机","area_id":1,"on_flag":0,"round_status":0,"area_v2_id":107,"area_v2_name":"其他游戏","area_v2_parent_id":2,"area_v2_parent_name":"游戏"},{"owner":{"face":"https://i1.hdslb.com/bfs/face/5a83cc6de0c936b2cb6bd3a97f46378e15f5a2d3.jpg","mid":103014,"name":"在剧毒中心呼唤爱"},"cover":{"src":"https://i0.hdslb.com/bfs/live/6a85a5ee6fa4edf1d7a0c15d67139aeaf03e26b0.jpg","height":180,"width":320},"title":"店长炼金","room_id":37034,"online":32081,"playurl":"http://js.live-play.acgvideo.com/live-js/819116/live_103014_6932719.flv?wsSecret=ca3071f8811b441108d18542627af83a&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"电子竞技","area_id":4,"on_flag":0,"round_status":0,"area_v2_id":86,"area_v2_name":"英雄联盟","area_v2_parent_id":2,"area_v2_parent_name":"游戏"},{"owner":{"face":"https://i1.hdslb.com/bfs/face/02c19a63cc6f9157b21e60da573f69d423721800.jpg","mid":24047117,"name":"吃不饱的小黄瓜"},"cover":{"src":"https://i0.hdslb.com/bfs/live/d6559d746673e370ca9eb190978cee79ca41bc08.jpg","height":180,"width":320},"title":"ASMR 睡，都给我睡！","room_id":1621877,"online":30991,"playurl":"http://qn.live-play.acgvideo.com/live-qn/933811/live_24047117_8600703.flv?wsSecret=e686818c840e50384450d2b3247ec3ec&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"御宅文化","area_id":2,"on_flag":0,"round_status":0,"area_v2_id":30,"area_v2_name":"ASMR ","area_v2_parent_id":1,"area_v2_parent_name":"娱乐"},{"owner":{"face":"https://i1.hdslb.com/bfs/face/061da7dc21c649a65af75fa6a373cd83e38efef5.jpg","mid":11644473,"name":"第二颗纽扣给樱酱QvQ"},"cover":{"src":"https://i0.hdslb.com/bfs/live/719985b86812915ed4f3ac87f98065e743d77a96.jpg","height":180,"width":320},"title":"ASMR白天不懂夜的黑~","room_id":498388,"online":26821,"playurl":"http://qn.live-play.acgvideo.com/live-qn/964587/live_11644473_9358208.flv?wsSecret=0ec06a805f9e00178baf0485431ee838&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"御宅文化","area_id":2,"on_flag":0,"round_status":0,"area_v2_id":30,"area_v2_name":"ASMR ","area_v2_parent_id":1,"area_v2_parent_name":"娱乐"},{"owner":{"face":"https://i0.hdslb.com/bfs/face/c52d8d5df531a70cc9c87fbf4a4f9b1732d803a8.gif","mid":8414991,"name":"比尔盖厕"},"cover":{"src":"https://i0.hdslb.com/bfs/live/0c11034bcfd362ff58cd460ab496885c7bb392c7.jpg","height":180,"width":320},"title":"【厕】新年好~浪完回家看直播呀~","room_id":273849,"online":25237,"playurl":"http://xl.live-play.acgvideo.com/live-xl/530700/live_8414991_8935961.flv?wsSecret=cc04b1478146d94fbdce129980ccb90c&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"单机联机","area_id":1,"on_flag":0,"round_status":0,"area_v2_id":107,"area_v2_name":"其他游戏","area_v2_parent_id":2,"area_v2_parent_name":"游戏"},{"owner":{"face":"https://i1.hdslb.com/bfs/face/f27a3f37f207ab46c8f7c6c0c788a055f7d1349d.jpg","mid":2255740,"name":"你的苏暖"},"cover":{"src":"https://i0.hdslb.com/bfs/live/54fe0ca59acb0fd675671671973f6dd4f2e3b0a0.jpg","height":180,"width":320},"title":"苏暖：扛枪软妹","room_id":24541,"online":22941,"playurl":"http://qn.live-play.acgvideo.com/live-qn/671413/live_2255740_332_c521e483.flv?wsSecret=4d91de1eab2b01403941a41e64da9722&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"单机联机","area_id":1,"on_flag":0,"round_status":0,"area_v2_id":80,"area_v2_name":"绝地求生：大逃杀","area_v2_parent_id":2,"area_v2_parent_name":"游戏"},{"owner":{"face":"https://i2.hdslb.com/bfs/face/559c79e3e1320edd49b447e0454ea586b1d85577.jpg","mid":25144885,"name":"茹么么Rumeme"},"cover":{"src":"https://i0.hdslb.com/bfs/live/cc2e647566feebb0f25bd843b8e85d9bd65c3826.jpg","height":180,"width":320},"title":"轻轻的·ASMR","room_id":1495752,"online":21822,"playurl":"http://qn.live-play.acgvideo.com/live-qn/543633/live_25144885_6437847.flv?wsSecret=f5c9f253538d1d6e07ff2d3497025cba&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"御宅文化","area_id":2,"on_flag":0,"round_status":0,"area_v2_id":30,"area_v2_name":"ASMR ","area_v2_parent_id":1,"area_v2_parent_name":"娱乐"},{"owner":{"face":"https://i0.hdslb.com/bfs/face/dc6c6e198f13eb56413c2838ed3f623ab590a3a6.jpg","mid":66072698,"name":"你好这里是小V丶"},"cover":{"src":"https://i0.hdslb.com/bfs/live/b4977ea39748b94484a2331b442476bd08a86898.jpg","height":180,"width":320},"title":"【小V 】B站最强狼人杀","room_id":4631694,"online":20298,"playurl":"http://qn.live-play.acgvideo.com/live-qn/405642/live_66072698_8344948.flv?wsSecret=7c85f9e9d8f31aa04020da0674881f47&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"手游直播","area_id":12,"on_flag":0,"round_status":0,"area_v2_id":41,"area_v2_name":"狼人杀","area_v2_parent_id":3,"area_v2_parent_name":"手游"},{"owner":{"face":"https://i1.hdslb.com/bfs/face/370f188f8fcf5f53d2734a2b7d6cee350da9c4cc.jpg","mid":315834,"name":"雷米FF"},"cover":{"src":"https://i0.hdslb.com/bfs/live/3de6438acccd1140adc6ff3bda1149246347f9f7.jpg","height":180,"width":320},"title":"21点准时复活！","room_id":423510,"online":19295,"playurl":"http://js.live-play.acgvideo.com/live-js/449709/live_315834_1754653.flv?wsSecret=605c0aa251daeac2fc3391f95b01ddb9&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"电子竞技","area_id":4,"on_flag":0,"round_status":0,"area_v2_id":86,"area_v2_name":"英雄联盟","area_v2_parent_id":2,"area_v2_parent_name":"游戏"},{"owner":{"face":"https://i2.hdslb.com/bfs/face/18df6c1ccad7a5b0a0e4c9e28725a569c773579d.gif","mid":18210970,"name":"安妮找不到小熊了"},"cover":{"src":"https://i0.hdslb.com/bfs/live/d2dcdaa2b7f923b7480be68307c1b7d717a91c01.jpg","height":180,"width":320},"title":"【绝地求生】日更良心主播关注了","room_id":543359,"online":14787,"playurl":"http://qn.live-play.acgvideo.com/live-qn/142894/live_18210970_2222961.flv?wsSecret=cb7b006f9e507d2af3b5a43983b57688&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"手游直播","area_id":12,"on_flag":0,"round_status":0,"area_v2_id":98,"area_v2_name":"其他手游","area_v2_parent_id":3,"area_v2_parent_name":"手游"},{"owner":{"face":"https://i0.hdslb.com/bfs/face/232325726db9b91c85061686fc265f138ea7b544.jpg","mid":3311852,"name":"璃猫タヌキ"},"cover":{"src":"https://i0.hdslb.com/bfs/live/fe4233635a6c1f207011bf0756a65f65695d0f65.jpg","height":180,"width":320},"title":"qq飞车真好玩","room_id":68612,"online":14174,"playurl":"http://dl.live-play.acgvideo.com/live-dl/247774/live_3311852_7248026.flv?wsSecret=7abab0e16a94fdab107048e9017ffcb3&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"手游直播","area_id":12,"on_flag":0,"round_status":0,"area_v2_id":98,"area_v2_name":"其他手游","area_v2_parent_id":3,"area_v2_parent_name":"手游"},{"owner":{"face":"https://i0.hdslb.com/bfs/face/a42f5bf0c5a1db51f520b9e86fd646378f917867.jpg","mid":682508,"name":"超心塞的十六"},"cover":{"src":"https://i0.hdslb.com/bfs/live/8d879eec269c5e3b6dbd582380bbb4c92d12607b.jpg","height":180,"width":320},"title":"塞尔达达达达达达达 萌新","room_id":10313,"online":13735,"playurl":"http://dl.live-play.acgvideo.com/live-dl/836653/live_682508_3859786.flv?wsSecret=d70840a042a7f93f8950c2d744b48a12&wsTime=1518976621","accept_quality":"4","broadcast_type":0,"area":"单机联机","area_id":1,"on_flag":0,"round_status":0,"area_v2_id":107,"area_v2_name":"其他游戏","area_v2_parent_id":2,"area_v2_parent_name":"游戏"}]
     */

    @SerializedName("code")
    private int code;
    @SerializedName("data")
    private List<Data> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public static class Data {
        /**
         * owner : {"face":"https://i1.hdslb.com/bfs/face/5be61949369dd844cc459eab808da151d8c363d2.gif","mid":4548018,"name":"扎双马尾的丧尸"}
         * cover : {"src":"https://i0.hdslb.com/bfs/live/1f260f3bba18fc329f49a545d1b7c7d7810290bf.jpg","height":180,"width":320}
         * title : 软萌的熊熊丧
         * room_id : 48499
         * online : 527628
         * playurl : http://txy.live-play.acgvideo.com/live-txy/851545/live_4548018_332_c521e483.flv?wsSecret=c56fa32194f2dcf33c6f3652bbe69b86&wsTime=1518976621
         * accept_quality : 4
         * broadcast_type : 0
         * area : 御宅文化
         * area_id : 2
         * on_flag : 0
         * round_status : 0
         * area_v2_id : 30
         * area_v2_name : ASMR
         * area_v2_parent_id : 1
         * area_v2_parent_name : 娱乐
         */

        @SerializedName("owner")
        private Owner owner;
        @SerializedName("cover")
        private Cover cover;
        @SerializedName("title")
        private String title;
        @SerializedName("room_id")
        private long roomId;
        @SerializedName("online")
        private long online;
        @SerializedName("playurl")
        private String playurl;
        @SerializedName("accept_quality")
        private String acceptQuality;
        @SerializedName("broadcast_type")
        private int broadcastType;
        @SerializedName("area")
        private String area;
        @SerializedName("area_id")
        private int areaId;
        @SerializedName("on_flag")
        private int onFlag;
        @SerializedName("round_status")
        private int roundStatus;
        @SerializedName("area_v2_id")
        private int areaV2Id;
        @SerializedName("area_v2_name")
        private String areaV2Name;
        @SerializedName("area_v2_parent_id")
        private int areaV2ParentId;
        @SerializedName("area_v2_parent_name")
        private String areaV2ParentName;

        public Owner getOwner() {
            return owner;
        }

        public void setOwner(Owner owner) {
            this.owner = owner;
        }

        public Cover getCover() {
            return cover;
        }

        public void setCover(Cover cover) {
            this.cover = cover;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public long getRoomId() {
            return roomId;
        }

        public void setRoomId(long roomId) {
            this.roomId = roomId;
        }

        public long getOnline() {
            return online;
        }

        public void setOnline(long online) {
            this.online = online;
        }

        public String getPlayurl() {
            return playurl;
        }

        public void setPlayurl(String playurl) {
            this.playurl = playurl;
        }

        public String getAcceptQuality() {
            return acceptQuality;
        }

        public void setAcceptQuality(String acceptQuality) {
            this.acceptQuality = acceptQuality;
        }

        public int getBroadcastType() {
            return broadcastType;
        }

        public void setBroadcastType(int broadcastType) {
            this.broadcastType = broadcastType;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public int getAreaId() {
            return areaId;
        }

        public void setAreaId(int areaId) {
            this.areaId = areaId;
        }

        public int getOnFlag() {
            return onFlag;
        }

        public void setOnFlag(int onFlag) {
            this.onFlag = onFlag;
        }

        public int getRoundStatus() {
            return roundStatus;
        }

        public void setRoundStatus(int roundStatus) {
            this.roundStatus = roundStatus;
        }

        public int getAreaV2Id() {
            return areaV2Id;
        }

        public void setAreaV2Id(int areaV2Id) {
            this.areaV2Id = areaV2Id;
        }

        public String getAreaV2Name() {
            return areaV2Name;
        }

        public void setAreaV2Name(String areaV2Name) {
            this.areaV2Name = areaV2Name;
        }

        public int getAreaV2ParentId() {
            return areaV2ParentId;
        }

        public void setAreaV2ParentId(int areaV2ParentId) {
            this.areaV2ParentId = areaV2ParentId;
        }

        public String getAreaV2ParentName() {
            return areaV2ParentName;
        }

        public void setAreaV2ParentName(String areaV2ParentName) {
            this.areaV2ParentName = areaV2ParentName;
        }

        public static class Owner {
            /**
             * face : https://i1.hdslb.com/bfs/face/5be61949369dd844cc459eab808da151d8c363d2.gif
             * mid : 4548018
             * name : 扎双马尾的丧尸
             */

            @SerializedName("face")
            private String face;
            @SerializedName("mid")
            private long mid;
            @SerializedName("name")
            private String name;

            public String getFace() {
                return face;
            }

            public void setFace(String face) {
                this.face = face;
            }

            public long getMid() {
                return mid;
            }

            public void setMid(long mid) {
                this.mid = mid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class Cover {
            /**
             * src : https://i0.hdslb.com/bfs/live/1f260f3bba18fc329f49a545d1b7c7d7810290bf.jpg
             * height : 180
             * width : 320
             */

            @SerializedName("src")
            private String src;
            @SerializedName("height")
            private int height;
            @SerializedName("width")
            private int width;

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }
        }
    }
}
