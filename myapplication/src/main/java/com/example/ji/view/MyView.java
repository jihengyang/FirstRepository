package com.example.ji.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.ji.myapplication.R;

/**
 * Created by ji on 2016/6/27.
 */
public class MyView extends View{
    private float radius;
    private int color;
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //style是主题。styleable是属性集
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyView);
        color = typedArray.getColor(R.styleable.MyView_circle_color,0xfff);
        radius = typedArray.getDimension(R.styleable.MyView_radius,0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(radius,radius,radius,paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int wideMode = MeasureSpec.getMode(widthMeasureSpec);
        int wideSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if(wideMode == MeasureSpec.AT_MOST){
            widthMeasureSpec = MeasureSpec.makeMeasureSpec((int)radius*2,wideMode);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec((int)radius*2,heightMode);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    // TODO: 2016/6/27 一会儿看一下LinearLayout和RelativeLayout布局的区别
}
