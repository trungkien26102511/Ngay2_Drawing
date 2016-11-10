package com.example.kien.bai1_2ddrawing2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by Kien on 11/9/2016.
 */

public class RectangleCustom extends View {
    private Random mRandom;
    public RectangleCustom(Context context) {
        super(context);
    }

    public RectangleCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int maxWidth = getWidth()- 400;
        int maxHeight = getHeight()- 200;
        mRandom = new Random();
        Paint paint =  new Paint();
        paint.setColor(getContext().getResources().getColor(R.color.colorBackground));
        paint.setStrokeWidth(1);
        int deltaX= 0;
        int deltaY = 0;
        for(int i = 0; i < 5; i++){
            deltaX = mRandom.nextInt(maxWidth);
            deltaY = mRandom.nextInt(maxHeight);
            canvas.drawRect(deltaX + 10,deltaY + 10 , deltaX + 400, deltaY + 200,paint);
            Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
            p.setColor(getContext().getResources().getColor(R.color.colorAccent));
            p.setTextSize(60);
            canvas.drawText("WOW!",deltaX + 130,deltaY + 120 ,p);
        }

    }
}
