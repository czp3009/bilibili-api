package com.hiczp.bilibili.api.live.bulletScreen;

import javax.annotation.Nonnull;

public class BulletScreenHelper {
    public static String[] splitMessageByFixedLength(@Nonnull String message, int lengthLimit) {
        int count = message.length() / lengthLimit;
        if (message.length() % lengthLimit != 0) {
            count++;
        }
        String[] messages = new String[count];
        for (int i = 0; i < count; i++) {
            messages[i] = message.substring(i * lengthLimit, i != count - 1 ? (i + 1) * lengthLimit : message.length());
        }
        return messages;
    }
}
