package com.ch.animdemo.value;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import com.ch.animdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 属性动画
 * ValueAnimator有个缺点，就是只能对数值对动画计算。
 * 我们要想对哪个控件操作，需要监听动画过程，在监听中对控件操作。
 * 这样使用起来相比补间动画而言就相对比较麻烦。
 */
public class ValueActivity extends AppCompatActivity {

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
    @BindView(R.id.tv_demo)
    TextView tvDemo;

    private ValueAnimator valueAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("ValueAnimator");
        valueAnimator = ValueAnimator.ofFloat(0, 1f);
        valueAnimator.setDuration(200);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.e("cheng", "value=" + animation.getAnimatedValue());
            }
        });

        valueAnimator.start();
        tvDemo.setBackgroundColor(1);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                valueAnimator = ValueAnimator.ofInt(0, 400);
                valueAnimator.setDuration(2000);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int curValue = (int) animation.getAnimatedValue();
                        tvDemo.layout(curValue, curValue, curValue + tvDemo.getWidth(), curValue + tvDemo.getHeight());
                    }
                });
                valueAnimator.start();

                break;
            case R.id.btn_2:

                valueAnimator = ValueAnimator.ofInt(0, 400, 0);
                valueAnimator.setDuration(2000);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int curValue = (int) animation.getAnimatedValue();
                        tvDemo.layout(curValue, curValue, curValue + tvDemo.getWidth(), curValue + tvDemo.getHeight());
                    }
                });
                valueAnimator.start();
                break;
            case R.id.btn_3:
                valueAnimator = ValueAnimator.ofFloat(0, 400f, 0, 800f, 0);
                valueAnimator.setDuration(2000);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Float curValueFloat = (Float) animation.getAnimatedValue();
                        int curValue = curValueFloat.intValue();
                        tvDemo.layout(curValue, curValue, curValue + tvDemo.getWidth(), curValue + tvDemo.getHeight());
                    }
                });
                valueAnimator.start();
                break;
            case R.id.btn_4:
                valueAnimator = ValueAnimator.ofFloat(0, 400f, 0, 800f, 0);
                valueAnimator.setDuration(2000);
                valueAnimator.setInterpolator(new DecelerateInterpolator());
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Float curValueFloat = (Float) animation.getAnimatedValue();
                        int curValue = curValueFloat.intValue();
                        tvDemo.layout(curValue, curValue, curValue + tvDemo.getWidth(), curValue + tvDemo.getHeight());
                    }
                });
                valueAnimator.start();
                break;
            case R.id.btn_5:
                valueAnimator = ValueAnimator.ofArgb(0xffffff00, 0xff0000ff);
                valueAnimator.setDuration(2000);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int curValue = (int) animation.getAnimatedValue();
                        tvDemo.setBackgroundColor(curValue);
                    }
                });
                valueAnimator.start();
                break;
            case R.id.btn_6:
                valueAnimator = ValueAnimator.ofObject(new CharEvaluator(), 'A', 'Z');
                valueAnimator.setDuration(2000);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        char text = (char) animation.getAnimatedValue();
                        tvDemo.setText(String.valueOf(text));
                    }
                });
                valueAnimator.start();
                break;
        }
    }

    /**
     * 字母A到字母Z之间的所有字母对应的数字区间为65到90
     * 在程序中，我们能通过数字强转成对应的字符。
     */
    public class CharEvaluator implements TypeEvaluator<Character> {
        @Override
        public Character evaluate(float fraction, Character startValue, Character endValue) {
            int startInt = (int) startValue;
            int endInt = (int) endValue;
            int curInt = (int) (startInt + fraction * (endInt - startInt));
            char result = (char) curInt;
            return result;
        }
    }
}
