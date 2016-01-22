package com.buaa.arvin.redo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

/**
 * Created by yangmu on 2015/11/27.
 */
public class QQListView extends ListView {

    //滑动的最小距离
    private int touchSlop;
    //是否相应滑动
    private boolean isSliding;

    //手指按下时的x坐标
    private int xDown;
    private int yDown;
    //手指滑动时的X坐标
    private int xMove;
    private int yMove;

    private LayoutInflater layoutInflater;
    private PopupWindow popupWindow;
    private int popupWindowHeight;
    private int popupWindowWidth;

    private Button mDeleBtn;

    //当前手指触摸的View
    private View mCurrentView;
    //当前手指触摸的位置
    private int mCurrentViewPostion;

    //为删除按钮提供一个回调接口
    private DelButtonClickListener delButtonClickListener;

    public QQListView(Context context,AttributeSet attrs) {
        super(context,attrs);
        layoutInflater = LayoutInflater.from(context);
        touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();

        View view = layoutInflater.inflate(R.layout.delete_btn,null);
        mDeleBtn = (Button) view.findViewById(R.id.id_item_btn);
        popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);

        //调用measure，否则拿不到高宽
        popupWindow.getContentView().measure(0,0);
        popupWindowHeight = popupWindow.getContentView().getMeasuredHeight();
        popupWindowWidth = popupWindow.getContentView().getMeasuredWidth();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                xDown = x;
                yDown = y;
                //如果当前popupWindow显示，则直接隐藏，然后屏蔽ListView的touch事件的下传
                if (popupWindow.isShowing()){
                    dismissPopWindow();
                    return false;
                }
                //获得当前手指按下时的item的位置
                mCurrentViewPostion = pointToPosition(xDown,yDown);
                //获得当前手指按下时的item
                View view = getChildAt(mCurrentViewPostion - getFirstVisiblePosition());
                mCurrentView = view;
                break;
            case MotionEvent.ACTION_MOVE:
                xMove = x;
                yMove = y;
                int dx = xMove -xDown;
                int dy = yMove - yDown;
                //判断是否是从右到左的滑动
                if (xMove < xDown && Math.abs(dx) > touchSlop && Math.abs(dy) < touchSlop){
                    isSliding = true;
                }
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onFilterTouchEventForSecurity(MotionEvent event) {
        int action = event.getAction();
        //如果是从右到左的滑动才响应
        if (isSliding){
            switch (action){
                case MotionEvent.ACTION_MOVE:
                    final int[] location = new int[2];
                    //获得当前item的位置x与y
                    mCurrentView.getLocationOnScreen(location);
                    //设置popuwindow的动画
                    popupWindow.setAnimationStyle(R.style.popwindow_delete_btn_anim_style);
                    popupWindow.update();
                    popupWindow.showAtLocation(mCurrentView, Gravity.LEFT | Gravity.TOP, location[0] + mCurrentView.getWidth(), location[1] + mCurrentView.getHeight() / 2 - popupWindowHeight / 2);
                    //设置删除按钮的回调
                    mDeleBtn.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (delButtonClickListener != null){
                                delButtonClickListener.clickHappend(mCurrentViewPostion);
                                popupWindow.dismiss();
                            }
                        }
                    });
                    break;
                case MotionEvent.ACTION_UP:
                    isSliding = false;
                    break;
            }
            //相应滑动期间屏幕itemClick事件，避免发生冲突
            return true;
        }
        return super.onFilterTouchEventForSecurity(event);
    }


    private void dismissPopWindow(){
        if (popupWindow != null && popupWindow.isShowing()){
            popupWindow.dismiss();
        }
    }

    public void setDelButtonClickListener(DelButtonClickListener listener){
        delButtonClickListener = listener;
    }
    interface  DelButtonClickListener{
        public void clickHappend(int position);
    }
}
