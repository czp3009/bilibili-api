package com.hiczp.bilibili.api.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hiczp.bilibili.api.BilibiliRESTAPI;
import com.hiczp.bilibili.api.Utils;
import com.hiczp.bilibili.api.live.entity.BulletScreenEntity;
import com.hiczp.bilibili.api.live.entity.GiftEntity;
import com.hiczp.bilibili.api.live.entity.LiveRoomInfoEntity;
import com.hiczp.bilibili.api.live.entity.PlayerBagEntity;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LiveServiceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LiveServiceTest.class);
    private static final Gson GSON = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
    private static int roomId = Config.getInstance().getRoomId();
    private static LiveRoomInfoEntity.LiveRoomEntity liveRoomEntity;
    private static PlayerBagEntity.BagGiftEntity firstGiftInPlayerBag;

    @Test
    public void _00getBulletScreenConfig() throws IOException {
        LOGGER.info("Getting Bullet Screen config");
        GSON.toJson(
                BilibiliRESTAPI.getLiveService()
                        .getBulletScreenConfig("all")
                        .execute()
                        .body(),
                System.out
        );
    }

    @Test
    public void _01getHistoryBulletScreens() throws Exception {
        LOGGER.info("Getting history Bullet Screens of room " + roomId);
        GSON.toJson(
                BilibiliRESTAPI.getLiveService()
                        .getHistoryBulletScreens(roomId)
                        .execute()
                        .body(),
                System.out
        );
    }

    @Test
    public void _02getRoomInfo() throws Exception {
        LOGGER.info("Getting info of live room " + roomId);
        LiveRoomInfoEntity liveRoomInfoEntity = BilibiliRESTAPI.getLiveService()
                .getRoomInfo(roomId)
                .execute()
                .body();
        liveRoomEntity = liveRoomInfoEntity.getData();
        roomId = liveRoomEntity.getRoomId();
        GSON.toJson(
                liveRoomInfoEntity,
                System.out);
    }

    @Test
    public void _03isFollowed() throws Exception {
        LOGGER.info("Getting is followed user " + liveRoomEntity.getMid());
        GSON.toJson(
                BilibiliRESTAPI.getLiveService()
                        .isFollowed(liveRoomEntity.getMid())
                        .execute()
                        .body(),
                System.out
        );
    }

    @Test
    public void _04sendDaily() throws Exception {
        LOGGER.info("Sending daily");
        GSON.toJson(
                BilibiliRESTAPI.getLiveService()
                        .sendDaily()
                        .execute()
                        .body(),
                System.out
        );
    }

    @Test
    public void _05getAllItem() throws Exception {
        LOGGER.info("Getting all items");
        GSON.toJson(
                BilibiliRESTAPI.getLiveService()
                        .getAllItem()
                        .execute()
                        .body(),
                System.out
        );
    }

    @Test
    public void _06getAppSmallTV() throws Exception {
        LOGGER.info("Getting App Small TV info");
        GSON.toJson(
                BilibiliRESTAPI.getLiveService()
                        .getAppSmallTV()
                        .execute()
                        .body(),
                System.out
        );
    }

    @Test
    public void _07getTitle() throws Exception {
        LOGGER.info("Getting titles");
        GSON.toJson(
                BilibiliRESTAPI.getLiveService()
                        .getTitle()
                        .execute()
                        .body(),
                System.out
        );
    }

    @Test
    public void _08getSpecialGift() throws Exception {
        LOGGER.info("Getting special gift");
        GSON.toJson(
                BilibiliRESTAPI.getLiveService()
                        .getSpecialGift(roomId)
                        .execute()
                        .body(),
                System.out
        );
    }

    @Test
    public void _09getUserInfo() throws Exception {
        LOGGER.info("Getting user info");
        GSON.toJson(
                BilibiliRESTAPI.getLiveService()
                        .getUserInfo()
                        .execute()
                        .body(),
                System.out
        );
    }

    @Test
    public void _10getPlayUrl() throws Exception {
        LOGGER.info("Getting play url of room " + roomId);
        GSON.toJson(
                BilibiliRESTAPI.getLiveService()
                        .getPlayUrl(roomId, "json")
                        .execute()
                        .body(),
                System.out
        );
    }

    @Test
    public void _11sendOnlineHeart() throws Exception {
        LOGGER.info("Sending online heart to room " + roomId);
        GSON.toJson(
                BilibiliRESTAPI.getLiveService()
                        .sendOnlineHeart(roomId, Utils.getScale())
                        .execute()
                        .body(),
                System.out
        );
    }

    @Test
    public void _12sendBulletScreen() throws Exception {
        LOGGER.info("Sending Bullet Screen to room " + roomId);
        GSON.toJson(
                BilibiliRESTAPI.getLiveService()
                        .sendBulletScreen(new BulletScreenEntity(roomId, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())))
                        .execute()
                        .body(),
                System.out
        );
    }

    @Test
    public void _13getFreeSilverCurrentTask() throws Exception {
        LOGGER.info("Getting free silver current task");
        GSON.toJson(
                BilibiliRESTAPI.getLiveService()
                        .getFreeSilverCurrentTask()
                        .execute()
                        .body(),
                System.out
        );
    }

    @Test
    public void _14getFreeSilverAward() throws Exception {
        LOGGER.info("Getting free silver award");
        GSON.toJson(
                BilibiliRESTAPI.getLiveService()
                        .getFreeSilverAward()
                        .execute()
                        .body(),
                System.out
        );
    }

    @Test
    public void _15getPlayerBag() throws Exception {
        LOGGER.info("Getting player bag");
        PlayerBagEntity playerBagEntity = BilibiliRESTAPI.getLiveService()
                .getPlayerBag()
                .execute()
                .body();
        try {
            firstGiftInPlayerBag = playerBagEntity.getData().get(0);
        } catch (IndexOutOfBoundsException e) {
            LOGGER.error("Current user don't have any gift");
        }
        GSON.toJson(
                playerBagEntity,
                System.out
        );
    }

    @Test
    public void _16getActivityGifts() throws Exception {
        LOGGER.info("Getting activity gifts");
        GSON.toJson(
                BilibiliRESTAPI.getLiveService()
                        .getActivityGifts(roomId)
                        .execute()
                        .body(),
                System.out
        );
    }

    @Test
    public void _17sendGift() throws Exception {
        if (firstGiftInPlayerBag != null) {
            int number = 1;
            LOGGER.info("Sending {} {} to room of user '{}'", number, firstGiftInPlayerBag.getGiftName(), liveRoomEntity.getUname());
            GSON.toJson(
                    BilibiliRESTAPI.getLiveService()
                            .sendGift(new GiftEntity(firstGiftInPlayerBag, number, liveRoomEntity))
                            .execute()
                            .body(),
                    System.out
            );
        } else {
            LOGGER.error("No gift available in player bag, ignore sending gift test");
        }
    }

    @Test
    public void _18getGiftTop() throws Exception {
        LOGGER.info("Getting gift top");
        GSON.toJson(
                BilibiliRESTAPI.getLiveService()
                        .getGiftTop(roomId)
                        .execute()
                        .body(),
                System.out
        );
    }

    @Test
    public void _19getSignInfo() throws Exception {
        LOGGER.info("Getting sign info");
        GSON.toJson(
                BilibiliRESTAPI.getLiveService()
                        .getSignInfo()
                        .execute()
                        .body(),
                System.out
        );
    }

    @After
    public void endLine() {
        System.out.println();
    }
}
