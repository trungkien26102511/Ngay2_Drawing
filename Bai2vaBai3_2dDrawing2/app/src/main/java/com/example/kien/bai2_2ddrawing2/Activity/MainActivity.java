package com.example.kien.bai2_2ddrawing2.Activity;

import android.graphics.drawable.ShapeDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.kien.bai2_2ddrawing2.Custom.CustomView;
import com.example.kien.bai2_2ddrawing2.Model.ShapeData;
import com.example.kien.bai2_2ddrawing2.Model.ShapeDataList;
import com.example.kien.bai2_2ddrawing2.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private LinearLayout mLinearLayout;
    public CustomView customView;
    private Button btn_add,btn_remove;
    public ArrayList<ShapeData> mList =  new ArrayList<ShapeData>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLinearLayout = (LinearLayout)findViewById(R.id.ll_main);
        btn_add = (Button)findViewById(R.id.btn_add);
        btn_remove = (Button)findViewById(R.id.btn_remove);

        customView = new CustomView(this);
        mLinearLayout.addView(customView);
        btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customView.removeDrawing();

            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customView.addDrawing();
            }
        });
        ArrayList<ShapeDrawable> list =  customView.mShapes;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("data",new ShapeDataList(customView.getmShapeDataList()));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ShapeDataList s =  new ShapeDataList();
        s = (ShapeDataList) savedInstanceState.getSerializable("data");
        mList = s.getList();
        customView.setmShapeDataList(mList);
        customView.onRestore();
    }
}
