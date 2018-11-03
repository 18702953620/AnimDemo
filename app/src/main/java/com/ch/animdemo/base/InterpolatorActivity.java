package com.ch.animdemo.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

import com.ch.animdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 插值器
 */
public class InterpolatorActivity extends AppCompatActivity {

    @BindView(R.id.btn_1)
    AppCompatButton btn1;
    @BindView(R.id.btn_2)
    AppCompatButton btn2;
    @BindView(R.id.btn_3)
    AppCompatButton btn3;
    @BindView(R.id.btn_4)
    AppCompatButton btn4;
    @BindView(R.id.btn_5)
    AppCompatButton btn5;
    @BindView(R.id.btn_6)
    AppCompatButton btn6;
    @BindView(R.id.btn_7)
    AppCompatButton btn7;
    @BindView(R.id.btn_8)
    AppCompatButton btn8;
    @BindView(R.id.btn_9)
    AppCompatButton btn9;
    @BindView(R.id.tv_demo)
    TextView tvDemo;
    private RotateAnimation rotateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolator);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("Interpolator");
        //AccelerateDecelerateInterpolator   在动画开始与介绍的地方速率改变比较慢，在中间的时候加速
        //AccelerateInterpolator                     在动画开始的地方速率改变比较慢，然后开始加速
        //AnticipateInterpolator                      开始的时候向后然后向前甩
        //AnticipateOvershootInterpolator     开始的时候向后然后向前甩一定值后返回最后的值
        //BounceInterpolator                          动画结束的时候弹起
        //CycleInterpolator                             动画循环播放特定的次数，速率改变沿着正弦曲线
        //DecelerateInterpolator                    在动画开始的地方快然后慢
        //LinearInterpolator                            以常量速率改变
        //OvershootInterpolator                      向前甩一定值后再回到原来位置

//        rotateAnimation = new RotateAnimation(0, 3600, 0, 0);

        rotateAnimation = new RotateAnimation(0, 3600, RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setDuration(5000);
    }

    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                //AccelerateDecelerateInterpolator   在动画开始与介绍的地方速率改变比较慢，在中间的时候加速
                rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                tvDemo.startAnimation(rotateAnimation);
                break;
            case R.id.btn_2:
                //AccelerateInterpolator                     在动画开始的地方速率改变比较慢，然后开始加速
                rotateAnimation.setInterpolator(new AccelerateInterpolator());
                tvDemo.startAnimation(rotateAnimation);
                break;
            case R.id.btn_3:
                //AnticipateInterpolator                      开始的时候向后然后向前甩
                rotateAnimation.setInterpolator(new AnticipateInterpolator());
                tvDemo.startAnimation(rotateAnimation);
                break;
            case R.id.btn_4:
                //AnticipateOvershootInterpolator     开始的时候向后然后向前甩一定值后返回最后的值
                rotateAnimation.setInterpolator(new AnticipateOvershootInterpolator());
                tvDemo.startAnimation(rotateAnimation);
                break;
            case R.id.btn_5:
                //BounceInterpolator                          动画结束的时候弹起
                rotateAnimation.setInterpolator(new BounceInterpolator());
                tvDemo.startAnimation(rotateAnimation);
                break;
            case R.id.btn_6:
                //CycleInterpolator                             动画循环播放特定的次数，速率改变沿着正弦曲线
                rotateAnimation.setInterpolator(new CycleInterpolator(0.5f));
                tvDemo.startAnimation(rotateAnimation);
                break;
            case R.id.btn_7:
                //DecelerateInterpolator                    在动画开始的地方快然后慢
                rotateAnimation.setInterpolator(new DecelerateInterpolator());
                tvDemo.startAnimation(rotateAnimation);
                break;
            case R.id.btn_8:
                //LinearInterpolator                            以常量速率改变
                rotateAnimation.setInterpolator(new LinearInterpolator());
                tvDemo.startAnimation(rotateAnimation);
                break;
            case R.id.btn_9:
                //OvershootInterpolator                      向前甩一定值后再回到原来位置
                rotateAnimation.setInterpolator(new OvershootInterpolator());
                tvDemo.startAnimation(rotateAnimation);
                break;
        }
    }
}
