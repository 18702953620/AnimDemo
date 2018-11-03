package com.ch.animdemo.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.ch.animdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 动画集合
 */
public class SetActivity extends AppCompatActivity {

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
    private ScaleAnimation scaleAnimation;
    private TranslateAnimation translateAnimation;
    private AlphaAnimation alphaAnimation;


    private AnimationSet animationSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("AnimationSet");
    }

    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                rotateAnimation = new RotateAnimation(0, 720, 0, 0);
                rotateAnimation.setDuration(2000);

                translateAnimation = new TranslateAnimation(0, 100, 0, 100);
                translateAnimation.setDuration(2000);

                scaleAnimation = new ScaleAnimation(0, 1.4f, 0, 1.4f, 100, 100);
                scaleAnimation.setDuration(2000);

                alphaAnimation = new AlphaAnimation(0, 1);
                alphaAnimation.setDuration(2000);

                animationSet = new AnimationSet(true);
                animationSet.addAnimation(rotateAnimation);
                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(scaleAnimation);
                animationSet.addAnimation(alphaAnimation);
                animationSet.setDuration(4000);
                animationSet.setFillAfter(true);


                tvDemo.startAnimation(animationSet);
                break;
            case R.id.btn_2:
                rotateAnimation = new RotateAnimation(0, -720, 0, 0);
                rotateAnimation.setDuration(2000);

                translateAnimation = new TranslateAnimation(TranslateAnimation.RELATIVE_TO_SELF, 0, TranslateAnimation.RELATIVE_TO_SELF, 0.5f,
                        TranslateAnimation.RELATIVE_TO_SELF, 0, TranslateAnimation.RELATIVE_TO_SELF, 0.5f);
                translateAnimation.setDuration(2000);

                scaleAnimation = new ScaleAnimation(0, 1.4f, 0, 1.4f, 100, 100);
                scaleAnimation.setDuration(2000);

                alphaAnimation = new AlphaAnimation(0, 1);
                alphaAnimation.setDuration(2000);

                animationSet = new AnimationSet(true);
                animationSet.addAnimation(rotateAnimation);
                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(scaleAnimation);
                animationSet.addAnimation(alphaAnimation);
                animationSet.setDuration(4000);
                animationSet.setFillAfter(true);


                tvDemo.startAnimation(animationSet);
                break;
            case R.id.btn_3:

                rotateAnimation = new RotateAnimation(0, -720, RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation.setDuration(2000);

                translateAnimation = new TranslateAnimation(TranslateAnimation.RELATIVE_TO_PARENT, 0, TranslateAnimation.RELATIVE_TO_PARENT, 0.5f,
                        TranslateAnimation.RELATIVE_TO_PARENT, 0, TranslateAnimation.RELATIVE_TO_PARENT, 0.5f);
                translateAnimation.setDuration(2000);

                scaleAnimation = new ScaleAnimation(0, 1.4f, 0, 1.4f, ScaleAnimation.RELATIVE_TO_SELF,
                        0.5f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation.setDuration(2000);

                alphaAnimation = new AlphaAnimation(0, 1);
                alphaAnimation.setDuration(2000);


                animationSet = new AnimationSet(true);
                animationSet.addAnimation(rotateAnimation);
                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(scaleAnimation);
                animationSet.addAnimation(alphaAnimation);
                animationSet.setDuration(4000);
                animationSet.setFillAfter(true);


                tvDemo.startAnimation(animationSet);
                break;
            case R.id.btn_4:
                rotateAnimation = new RotateAnimation(0, -720, RotateAnimation.RELATIVE_TO_PARENT, 0.5f,
                        RotateAnimation.RELATIVE_TO_PARENT, 0.5f);
                rotateAnimation.setDuration(2000);

                scaleAnimation = new ScaleAnimation(0, 1.4f, 0, 1.4f, ScaleAnimation.RELATIVE_TO_PARENT,
                        0.5f, ScaleAnimation.RELATIVE_TO_PARENT, 0.5f);
                scaleAnimation.setDuration(2000);

                translateAnimation = new TranslateAnimation(TranslateAnimation.RELATIVE_TO_PARENT, 0, TranslateAnimation.RELATIVE_TO_PARENT, 0.5f,
                        TranslateAnimation.RELATIVE_TO_PARENT, 0, TranslateAnimation.RELATIVE_TO_PARENT, 0.5f);
                translateAnimation.setDuration(2000);

                alphaAnimation = new AlphaAnimation(1, 0);
                alphaAnimation.setDuration(2000);


                animationSet = new AnimationSet(true);
                animationSet.addAnimation(rotateAnimation);
                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(scaleAnimation);
                animationSet.addAnimation(alphaAnimation);
                animationSet.setDuration(4000);
                animationSet.setFillAfter(true);


                tvDemo.startAnimation(animationSet);
                break;
        }
    }
}
