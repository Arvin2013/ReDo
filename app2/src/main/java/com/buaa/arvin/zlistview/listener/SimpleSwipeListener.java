package com.buaa.arvin.zlistview.listener;


import com.buaa.arvin.zlistview.widget.ZSwipeItem;

/**
 * 简单实现的SwipeListener
 * Created by yangmu on 2015/11/27.
 * SwipeListener则是监听ZSwipeItem的open、close、startOpen、startClose、update等事件的，
 * 但是我们使用的时候，我们仅需要继承SimpleSwipeListener，然后重写里面我们关心的事件即可
 */
public class SimpleSwipeListener implements SwipeListener {

    @Override
    public void onStartOpen(ZSwipeItem layout) {
    }

    @Override
    public void onOpen(ZSwipeItem layout) {
    }

    @Override
    public void onStartClose(ZSwipeItem layout) {
    }

    @Override
    public void onClose(ZSwipeItem layout) {
    }

    @Override
    public void onUpdate(ZSwipeItem layout, int leftOffset, int topOffset) {
    }

    @Override
    public void onHandRelease(ZSwipeItem layout, float xvel, float yvel) {
    }
}
