package com.example.kien.bai2_2ddrawing2.Model;

import java.io.Serializable;

/**
 * Created by Kien on 11/10/2016.
 */

public class ShapeData implements Serializable {
    private int mLeft, mTop, mRight,mBottom;
    private double mType;

    public ShapeData(int mLeft, int mTop, int mRight, int mBottom, double mType) {
        this.mLeft = mLeft;
        this.mTop = mTop;
        this.mRight = mRight;
        this.mBottom = mBottom;
        this.mType = mType;
    }

    public int getmTop() {
        return mTop;
    }

    public void setmTop(int mTop) {
        this.mTop = mTop;
    }

    public int getmLeft() {
        return mLeft;
    }

    public void setmLeft(int mLeft) {
        this.mLeft = mLeft;
    }

    public int getmRight() {
        return mRight;
    }

    public void setmRight(int mRight) {
        this.mRight = mRight;
    }

    public int getmBottom() {
        return mBottom;
    }

    public void setmBottom(int mBottom) {
        this.mBottom = mBottom;
    }

    public double getmType() {
        return mType;
    }

    public void setmType(double mType) {
        this.mType = mType;
    }
}
