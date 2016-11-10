package com.example.kien.baitap1_2ddrawing1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Kien on 11/9/2016.
 */

public class LineDraw extends View {
    private float mStartX,mStartY,mStopX,mStopY;
    public LineDraw(Context context) {
        super(context);
    }

    public LineDraw(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.getResources().getColor(R.color.colorAccent));
        Paint paint = new Paint();
        paint.setColor(this.getResources().getColor(R.color.colorWhite));
        int viewWidth = getWidth();
        int viewHeight = getHeight();
        getLine1(viewWidth,viewHeight,canvas,paint);
        getLine2(viewWidth,viewHeight,canvas,paint);
        getLine3(viewWidth,viewHeight,canvas,paint);
        getLine4(viewWidth,viewHeight,canvas,paint);

    }

    private void getLine4(int viewWidth, int viewHeight,Canvas canvas,Paint paint) {
        mStartX =viewWidth/2;
        mStartY = 0;
        mStopX = viewWidth/2;
        mStopY = viewHeight;
        canvas.drawLine(mStartX, mStartY, mStopX, mStopY, paint);
    }

    private void getLine3(int viewWidth, int viewHeight,Canvas canvas,Paint paint) {
        mStartX =0;
        mStartY = viewHeight/2;
        mStopX = viewWidth;
        mStopY = viewHeight/2;
        canvas.drawLine(mStartX, mStartY, mStopX, mStopY, paint);
    }

    private void getLine2(int viewWidth, int viewHeight,Canvas canvas, Paint paint) {
        mStartX =viewWidth;
        mStartY = 0;
        mStopX = 0;
        mStopY = viewHeight;
        canvas.drawLine(mStartX, mStartY, mStopX, mStopY, paint);
    }

    private void getLine1(int viewWidth, int viewHeight,Canvas canvas, Paint paint) {
        mStartX =0;
        mStartY = 0;
        mStopX = viewWidth;
        mStopY = viewHeight;
        canvas.drawLine(mStartX, mStartY, mStopX, mStopY, paint);
    }

}
