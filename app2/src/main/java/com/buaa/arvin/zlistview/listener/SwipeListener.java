package com.buaa.arvin.zlistview.listener;

import com.buaa.arvin.zlistview.widget.ZSwipeItem;

/**
 * 滑动监听器
 * Created by yangmu on 2015/11/30.
 */
public interface SwipeListener {
    public void onStartOpen(ZSwipeItem layout);

    public void onOpen(ZSwipeItem layout);

    public void onStartClose(ZSwipeItem layout);

    public void onClose(ZSwipeItem layout);

    public void onUpdate(ZSwipeItem layout ,int leftOffset, int topOffset);

    public void onHandRelease(ZSwipeItem layout,float xvel,float yvel);
}
