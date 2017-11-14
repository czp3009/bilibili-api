package com.hiczp.bilibili.api.live.socket;

import com.sun.istack.internal.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Utils {
    private static byte[][] splitBytes(byte[] bytes, int n) {
        int lineCount = bytes.length % n == 0 ? bytes.length / n : bytes.length / n + 1;
        byte[][] result = new byte[lineCount][];
        int to;
        for (int line = 1; line <= lineCount; line++) {
            if (line != lineCount) {
                to = line * n;
            } else {
                to = bytes.length;
            }
            result[line - 1] = Arrays.copyOfRange(bytes, (line - 1) * n, to);
        }
        return result;
    }

    static void invokeCallback(List<BulletScreenListener> bulletScreenListeners, @Nullable Consumer<BulletScreenListener> consumer) {
        if (consumer != null) {
            for (int i = bulletScreenListeners.size() - 1; i >= 0; i--) {
                try {
                    consumer.accept(bulletScreenListeners.get(i));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void printBytes(byte[] bytes) {
        byte[][] data = splitBytes(bytes, 16);
        byte[] currentRow;
        char c;
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%08x  ", i * 16);
            currentRow = data[i];
            for (int j = 0; j < currentRow.length; j++) {
                System.out.printf("%02x ", currentRow[j]);
                if (j == 7) {
                    System.out.print(" ");
                }
            }
            if (currentRow.length < 16) {
                for (int k = 0; k < (48 - currentRow.length * 2 - (currentRow.length - 1)); k++) {
                    System.out.print(" ");
                }
            }
            System.out.print(" ");
            for (int j = 0; j < currentRow.length; j++) {
                if (currentRow[j] < ' ') {
                    c = '.';
                } else {
                    c = (char) currentRow[j];
                }
                System.out.print(c);
                if (j == 7) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
