package com.example.kien.bai2_2ddrawing2.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Kien on 11/10/2016.
 */

public class ShapeDataList implements Serializable {
    private ArrayList<ShapeData> slist;

    public ShapeDataList() {
    }

    public ShapeDataList(ArrayList<ShapeData> data) {
        this.slist = data;
    }

    public ArrayList<ShapeData> getList() {
        return this.slist;
    }
}
