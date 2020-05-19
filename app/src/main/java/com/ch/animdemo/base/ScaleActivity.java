package com.ch.animdemo.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

import com.ch.animdemo.R;

import java.lang.annotation.Annotation;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 尺寸缩放
 */
public class ScaleActivity extends AppCompatActivity {

    @BindView(R.id.btn_1)
    AppCompatButton btn1;
    @BindView(R.id.btn_2)
    AppCompatButton btn2;
    @BindView(R.id.btn_3)
    AppCompatButton btn3;
    @BindView(R.id.btn_4)
    AppCompatButton btn4;
    @BindView(R.id.tv_demo)
    TextView tvDemo;
    private ScaleAnimation scaleAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("ScaleAnimation");
    }

    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                //fromXScale    起始的X方向上相对自身的缩放比例，浮点值，比如1.0代表自身无变化，0.5代表起始时缩小一倍，2.0代表放大一倍；
                //toXScale        结尾的X方向上相对自身的缩放比例，浮点值；
                //fromYScale    起始的Y方向上相对自身的缩放比例，浮点值
                //toYScale        结尾的Y方向上相对自身的缩放比例，浮点值
                scaleAnimation = new ScaleAnimation(0, 1.4f, 0, 1.4f);

                //公共属性

                //动画持续时间
                scaleAnimation.setDuration(2000);
                //如果设置为true，控件动画结束时，将保持动画最后时的状态
                scaleAnimation.setFillAfter(true);
                //如果设置为true,控件动画结束时，还原到开始动画前的状态
                scaleAnimation.setFillBefore(false);
                //重复次数
                scaleAnimation.setRepeatCount(2);
                //重复类型，有reverse和restart两个值，reverse表示倒序回放，restart表示重新放一遍，必须与repeatCount一起使用
                scaleAnimation.setRepeatMode(Animation.RESTART);

                tvDemo.startAnimation(scaleAnimation);
                break;
            case R.id.btn_2:
                //pivotx,pivotY 动画起始位置+100
                scaleAnimation = new ScaleAnimation(0, 1.4f, 0, 1.4f, 100, 100);
                scaleAnimation.setDuration(2000);
                tvDemo.startAnimation(scaleAnimation);
                break;
            case R.id.btn_3:
                //如果是50%（代码0.5），表示在当前控件的左上角加上自己宽度的50%做为起始点
                scaleAnimation = new ScaleAnimation(0, 1.4f, 0, 1.4f, ScaleAnimation.RELATIVE_TO_SELF,
                        0.5f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation.setDuration(2000);
                tvDemo.startAnimation(scaleAnimation);
                break;
            case R.id.btn_4:
                //如果是50%p（代码0.5），那么就是表示在当前的左上角加上父控件宽度的50%做为起始点x轴坐标。
                scaleAnimation = new ScaleAnimation(0, 1.4f, 0, 1.4f, ScaleAnimation.RELATIVE_TO_PARENT,
                        0.5f, ScaleAnimation.RELATIVE_TO_PARENT, 0.5f);
                scaleAnimation.setDuration(2000);
                tvDemo.startAnimation(scaleAnimation);
                break;
            default:
                
        }
    }
}
