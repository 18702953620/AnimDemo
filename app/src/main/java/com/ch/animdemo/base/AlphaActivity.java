package com.ch.animdemo.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

import com.ch.animdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 透明度
 */
public class AlphaActivity extends AppCompatActivity {

    @BindView(R.id.tv_demo)
    TextView tvDemo;
    @BindView(R.id.btn_1)
    AppCompatButton btn1;
    @BindView(R.id.btn_2)
    AppCompatButton btn2;
    private AlphaAnimation alphaAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("AlphaAnimation");
    }

    @OnClick({R.id.btn_1, R.id.btn_2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                //fromAlpha   动画开始的透明度，从0.0 --1.0 ，0.0表示全透明，1.0表示完全不透明
                //toAlpha       动画结束时的透明度，也是从0.0 --1.0 ，0.0表示全透明，1.0表示完全不透明
                alphaAnimation = new AlphaAnimation(0, 1);
                alphaAnimation.setDuration(2000);
                tvDemo.startAnimation(alphaAnimation);
                break;
            case R.id.btn_2:
                alphaAnimation = new AlphaAnimation(1, 0);
                alphaAnimation.setDuration(2000);
                tvDemo.startAnimation(alphaAnimation);
                break;
        }
    }
}
