package com.hiczp.bilibili.api.live.socket.event;

import java.util.EventObject;

public class ViewerCountPackageEvent extends EventObject {
    private int viewerCount;

    public ViewerCountPackageEvent(Object source, int viewerCount) {
        super(source);
        this.viewerCount = viewerCount;
    }

    public int getViewerCount() {
        return viewerCount;
    }
}
