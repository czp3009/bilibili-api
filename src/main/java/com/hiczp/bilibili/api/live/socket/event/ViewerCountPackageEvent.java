package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;

public class ViewerCountPackageEvent extends Event {
    private int viewerCount;

    public ViewerCountPackageEvent(LiveClient source, int viewerCount) {
        super(source);
        this.viewerCount = viewerCount;
    }

    public int getViewerCount() {
        return viewerCount;
    }
}
