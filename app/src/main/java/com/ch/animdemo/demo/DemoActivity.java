package com.ch.animdemo.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.ch.animdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DemoActivity extends AppCompatActivity {

    @BindView(R.id.ball)
    AppCompatButton ball;
    @BindView(R.id.wxImg)
    AppCompatButton wxImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ball, R.id.wxImg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ball:
                startActivity(new Intent(DemoActivity.this, BallActivity.class));
                break;
            case R.id.wxImg:
                startActivity(new Intent(DemoActivity.this, WXPicActivity.class));
                break;
        }
    }
}
