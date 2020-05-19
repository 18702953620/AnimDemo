package com.ch.animdemo.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

import com.ch.animdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 旋转
 */
public class RotateActivity extends AppCompatActivity {

    @BindView(R.id.tv_demo)
    TextView tvDemo;
    @BindView(R.id.btn_1)
    AppCompatButton btn1;
    @BindView(R.id.btn_2)
    AppCompatButton btn2;
    @BindView(R.id.btn_3)
    AppCompatButton btn3;
    @BindView(R.id.btn_4)
    AppCompatButton btn4;
    private RotateAnimation rotateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("RotateAnimation");
    }

    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                //fromDegrees     开始旋转的角度位置，正值代表顺时针方向度数，负值代码逆时针方向度数
                //toDegrees         结束时旋转到的角度位置，正值代表顺时针方向度数，负值代码逆时针方向度数
                //pivotX        旋转起点X轴坐标，可以是数值、百分数、百分数p 三种样式 同scale
                //pivotY               旋转起点Y轴坐标，可以是数值、百分数、百分数p 三种样式
                rotateAnimation = new RotateAnimation(0, 720, 0, 0);
                rotateAnimation.setDuration(2000);
                tvDemo.startAnimation(rotateAnimation);

                break;
            case R.id.btn_2:
                rotateAnimation = new RotateAnimation(0, -720, 0, 0);
                rotateAnimation.setDuration(2000);
                tvDemo.startAnimation(rotateAnimation);
                break;
            case R.id.btn_3:
                rotateAnimation = new RotateAnimation(0, -720, RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation.setDuration(2000);
                tvDemo.startAnimation(rotateAnimation);
                break;
            case R.id.btn_4:
                rotateAnimation = new RotateAnimation(0, -720, RotateAnimation.RELATIVE_TO_PARENT, 0f,
                        RotateAnimation.RELATIVE_TO_PARENT, 0.5f);
                rotateAnimation.setDuration(2000);
                tvDemo.startAnimation(rotateAnimation);
                break;
            default:
        }
    }
}
