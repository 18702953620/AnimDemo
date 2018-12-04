package com.ch.animdemo.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ch.animdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WXPicActivity extends AppCompatActivity {

    @BindView(R.id.btn_top_left)
    Button btnTopLeft;
    @BindView(R.id.btn_top_right)
    Button btnTopRight;
    @BindView(R.id.btn_bottom_left)
    Button btnBottomLeft;
    @BindView(R.id.btn_bottom_right)
    Button btnBottomRight;
    @BindView(R.id.btn_center)
    Button btnCenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wxpic);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_top_left, R.id.btn_top_right, R.id.btn_bottom_left, R.id.btn_bottom_right, R.id.btn_center})
    public void onViewClicked(View view) {
        Intent intent = new Intent(WXPicActivity.this, ImgActivity.class);
        int[] location = new int[2];

        switch (view.getId()) {
            case R.id.btn_top_left:
                btnTopLeft.getLocationOnScreen(location);
                break;
            case R.id.btn_top_right:
                btnTopRight.getLocationOnScreen(location);
                break;
            case R.id.btn_bottom_left:
                btnBottomLeft.getLocationOnScreen(location);
                break;
            case R.id.btn_bottom_right:
                btnBottomRight.getLocationOnScreen(location);
                break;
            case R.id.btn_center:
                btnCenter.getLocationOnScreen(location);
                break;
        }
        intent.putExtra(ImgActivity.POINTX, location[0] + btnCenter.getMeasuredWidth() / 2);
        intent.putExtra(ImgActivity.POINTY, location[1] + btnCenter.getMeasuredHeight() / 2);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
}
