package com.example.kien.baitap2_2ddrawing1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by Kien on 11/9/2016.
 */

public class RandomBitmapView extends View {
    private Random mRandom;
    private Bitmap[] mImages = { makeBitmap(R.drawable.ic_1)
            ,makeBitmap(R.drawable.ic_2)
            ,makeBitmap(R.drawable.ic_3)
            ,makeBitmap(R.drawable.ic_4)
            ,makeBitmap(R.drawable.ic_5)
            ,makeBitmap(R.drawable.ic_6)
            ,makeBitmap(R.drawable.ic_7)
            ,makeBitmap(R.drawable.ic_8)
            ,makeBitmap(R.drawable.ic_9)
            ,makeBitmap(R.drawable.ic_10)};
    public RandomBitmapView(Context context) {
        super(context);
    }

    public RandomBitmapView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mRandom = new Random();
        int viewWidth = getWidth();
        int viewHeight = getHeight();
        for(int i = 0; i< 10; i++){
            drawRandomBitmap(canvas,viewWidth,viewHeight);
        }
    }

    private void drawRandomBitmap(Canvas canvas, int viewWidth, int viewHeight) {
        float left = mRandom.nextInt(viewWidth);
        float top = mRandom.nextInt(viewHeight);
        Bitmap img = mImages[mRandom.nextInt(mImages.length)];
        canvas.drawBitmap(img, left, top, null);
    }
    private Bitmap makeBitmap(int bitmapId) {
        return(BitmapFactory.decodeResource(getResources(), bitmapId));
    }
}
