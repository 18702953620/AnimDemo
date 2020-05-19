package com.ch.animdemo.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.ch.animdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 位移
 */
public class TranslateActivity extends AppCompatActivity {

    @BindView(R.id.tv_demo)
    TextView tvDemo;
    @BindView(R.id.btn_1)
    AppCompatButton btn1;
    @BindView(R.id.btn_2)
    AppCompatButton btn2;
    @BindView(R.id.btn_3)
    AppCompatButton btn3;

    private TranslateAnimation translateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("TranslateAnimation");
    }

    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                //fromXDelta     起始点X轴坐标，可以是数值、百分数、百分数p 三种样式，同scale
                //fromYDelta    起始点Y轴从标，可以是数值、百分数、百分数p 三种样式
                //toXDelta         结束点X轴坐标
                //toYDelta        结束点Y轴坐标
                translateAnimation = new TranslateAnimation(0, 100, 0, 100);
                translateAnimation.setDuration(2000);
                tvDemo.startAnimation(translateAnimation);
                break;
            case R.id.btn_2:
                translateAnimation = new TranslateAnimation(TranslateAnimation.RELATIVE_TO_SELF, 0, TranslateAnimation.RELATIVE_TO_SELF, 0.5f,
                        TranslateAnimation.RELATIVE_TO_SELF, 0, TranslateAnimation.RELATIVE_TO_SELF, 0.5f);
                translateAnimation.setDuration(2000);
                tvDemo.startAnimation(translateAnimation);
                break;
            case R.id.btn_3:
                translateAnimation = new TranslateAnimation(TranslateAnimation.RELATIVE_TO_PARENT, 0, TranslateAnimation.RELATIVE_TO_PARENT, 0.5f,
                        TranslateAnimation.RELATIVE_TO_PARENT, 0, TranslateAnimation.RELATIVE_TO_PARENT, 0.5f);
                translateAnimation.setDuration(2000);
                tvDemo.startAnimation(translateAnimation);
                break;
            default:
        }
    }
}
