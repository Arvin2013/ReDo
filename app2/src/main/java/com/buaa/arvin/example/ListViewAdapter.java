package com.buaa.arvin.example;


import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.buaa.arvin.zlistview.R;
import com.buaa.arvin.zlistview.adapter.BaseSwipeAdapter;
import com.buaa.arvin.zlistview.enums.DragEdge;
import com.buaa.arvin.zlistview.enums.ShowMode;
import com.buaa.arvin.zlistview.listener.SimpleSwipeListener;
import com.buaa.arvin.zlistview.widget.ZSwipeItem;


/**
 * Created by yangmu on 2015/11/30.
 */

public class ListViewAdapter extends BaseSwipeAdapter {

    protected static final String TAG = "ListViewAdapter";

    private Activity context;


    private Button left;
    private Button right;
    private ZSwipeItem swipeItem;

    public ListViewAdapter(Activity context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 200;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /*
    *  这个方法用来返回position位置的布局文件中ZSwipeItem的id，之所以需要有position，
    * 是为了在有多种布局在一起的情况。大多数情况下，我们不需要关心position参数即可。
    */
    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe_item;
    }

    /**
     * 在这个方法里面，我们需要完成布局文件资源的加载，就像上面这样用就可以了。
     *
     * @param position
     * @param parent
     * @return
     */
    @Override
    public View generateView(int position, ViewGroup parent) {
        return context.getLayoutInflater().inflate(R.layout.item_listview,
                parent, false);
    }

    /**
     * 这个方法是用来对我们的布局进行数据填充和监听器绑定的，
     * 在这里面，你不需要关心convertView是否为null，已经经过实例化了，尽情的调用就可以了。
     *
     * @param position
     * @param convertView
     */
    @Override
    public void fillValues(final int position, View convertView) {
        swipeItem = (ZSwipeItem) convertView
                .findViewById(R.id.swipe_item);
        LinearLayout ll = (LinearLayout) convertView.findViewById(R.id.ll);

        left = (Button) convertView.findViewById(R.id.left);
        right = (Button) convertView.findViewById(R.id.right);

        TextView tv = (TextView) convertView.findViewById(R.id.tv);
        tv.setText(position + "." + " 测试文本");

//        if (position % 4 == 1) {
//            swipeItem.setShowMode(ShowMode.PullOut);
//            swipeItem.setDragEdge(DragEdge.Right);
//        } else if (position % 4 == 2) {
//            swipeItem.setShowMode(ShowMode.LayDown);
//            swipeItem.setDragEdge(DragEdge.Right);
//        } else if (position % 4 == 3) {
//            swipeItem.setShowMode(ShowMode.PullOut);
//            swipeItem.setDragEdge(DragEdge.Left);
//        } else if (position % 4 == 0) {
//            swipeItem.setShowMode(ShowMode.LayDown);
//            swipeItem.setDragEdge(DragEdge.Left);
//        }
        /*是在设置显示模式。显示模式一共有两种，PullOut和LayDown，在ShowMode枚举类型里面定义的
        。PullOut就是推出模式，侧滑之后，前面的布局会被推出屏外，后面的布局从屏外移动进来，
        而LayOut则是后面的布局会一点点的显示出来，也就是被遮盖主了。
         */
        swipeItem.setShowMode(ShowMode.PullOut);
        /*
        是在设置侧滑动作的接受方向，Right代表从右边往左滑动的时候，后面布局会显示出来，
        这个也是一个枚举类型，有上下左右四个取值，一般推荐左右，上下和ListView的滑动有冲突，效果不好
         */
        swipeItem.setDragEdge(DragEdge.Right);
        /*
        可以给滑动item添加各种事件监听，推荐使用SimpleSwipeListener的匿名类，这样就可以只重写自己关心的事件，
        onOpen和onClose是打开关闭的时候调用，onStartXX则是在动作一开始就调用，因此，如果需要改变后面布局的状态，请在onStartXX的时候调用，
        onHandRelease()则是在用户手指离开屏幕的时候调用，参数layout是事件发生的ZSwipeItem对象、xvel和yvel则是手势放开瞬间，x和y方向的加速度。
        onUpdate()在滑动的时候一直会调用，leftOffset和topOffset是距离左上角坐标的距离。
         */
        swipeItem.addSwipeListener(new SimpleSwipeListener() {
            @Override
            public void onOpen(ZSwipeItem layout) {
                Log.d(TAG, "打开:" + position);
            }

            @Override
            public void onClose(ZSwipeItem layout) {
                Log.d(TAG, "关闭:" + position);
            }

            @Override
            public void onStartOpen(ZSwipeItem layout) {
                Log.d(TAG, "准备打开:" + position);
            }

            @Override
            public void onStartClose(ZSwipeItem layout) {
                Log.d(TAG, "准备关闭:" + position);
            }

            @Override
            public void onHandRelease(ZSwipeItem layout, float xvel, float yvel) {
                Log.d(TAG, "手势释放");
            }

            @Override
            public void onUpdate(ZSwipeItem layout, int leftOffset,
                                 int topOffset) {
                Log.d(TAG, "位置更新");
            }
        });

        left.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(context, left.getText() + "" + position, Toast.LENGTH_SHORT)
                        .show();
                swipeItem.close();
            }
        });

        right.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(context, right.getText() + "" + position, Toast.LENGTH_SHORT)
                        .show();
                swipeItem.close();
            }
        });

    }
}
