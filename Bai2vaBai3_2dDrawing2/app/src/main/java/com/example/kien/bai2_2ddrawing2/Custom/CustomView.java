package com.example.kien.bai2_2ddrawing2.Custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import com.example.kien.bai2_2ddrawing2.Model.ShapeData;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Kien on 11/9/2016.
 */

public class CustomView extends View{
    private Random mRandom;
    private String data = "";

    public ArrayList<ShapeDrawable> mShapes = new ArrayList<ShapeDrawable>();
    public ArrayList<ShapeData> mShapeDataList =  new ArrayList<ShapeData>();
    public CustomView(Context context) {
        super(context);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setmShapeDataList(ArrayList<ShapeData> mShapeDataList) {
        this.mShapeDataList = mShapeDataList;
    }

    public ArrayList<ShapeData> getmShapeDataList() {
        return mShapeDataList;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mRandom = new Random();
        for(ShapeDrawable shape: mShapes) {
            shape.draw(canvas);
        }
    }
    public void addDrawing(){
        int viewWidth = getWidth();
        int viewHeight = getHeight();
        int x = mRandom.nextInt(viewWidth);
        int y = mRandom.nextInt(viewHeight);
        mShapes.add(makeShapeDrawable(x, y));
        invalidate();

    }
    private ShapeDrawable makeShapeDrawable(int x, int y) {
        int maxWidth = getWidth()/10;
        Shape shape;
        double type = Math.random();
        if (type < 0.5) {
            shape = new OvalShape();
        } else {
            shape = new RectShape();
        }
        ShapeDrawable s = new ShapeDrawable(shape);
        int width = mRandom.nextInt(maxWidth)+5;
        int height = mRandom.nextInt(maxWidth)+5;
        s.setBounds(x-width/2, y-height/2, x+width/2, y+height/2);
        ShapeData item = new ShapeData(x-width/2, y-height/2, x+width/2, y+height/2,type);
        mShapeDataList.add(item);
        data = data + type + " " +(x-width/2)+ " " + (y-height/2)+ " " +(x+width/2)+ " " + (y+height/2) +"\n";
        return(s);
    }
    public void removeDrawing(){
        if(mShapes.size() > 0) {
            ShapeDrawable shape = mShapes.get(mShapes.size() - 1);
            mShapes.remove(shape);
            ShapeData item =  mShapeDataList.get(mShapeDataList.size() - 1);
            mShapeDataList.remove(item);
            invalidate();

        }else{
            Toast.makeText(getContext(), "het", Toast.LENGTH_SHORT).show();
        }
    }
    public void onRestore(){
        mShapes.clear();
        Shape shape;
        for (int i = 0; i< mShapeDataList.size();i++){
            ShapeData s =  mShapeDataList.get(i);
            if (s.getmType() < 0.5) {
                shape = new OvalShape();
            } else {
                shape = new RectShape();
            }
            ShapeDrawable sd = new ShapeDrawable(shape);
            sd.setBounds(s.getmLeft(),s.getmTop(),s.getmRight(),s.getmBottom());
            mShapes.add(sd);
            invalidate();
        }
    }
}


