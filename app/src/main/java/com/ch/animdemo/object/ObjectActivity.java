package com.ch.animdemo.object;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.TextView;

import com.ch.animdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 通过指定属性所对应的set方法来改变的。
 * 比如，我们上面指定的改变rotation的属性值，
 * ObjectAnimator在做动画时就会到指定控件（TextView）中去找对应的setRotation()方法来改变控件中对应的值。
 */
public class ObjectActivity extends AppCompatActivity {

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
    private ObjectAnimator objectAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);
        ButterKnife.bind(this);

        /**
         *
         //1、透明度：alpha
         public void setAlpha(float alpha)

         //2、旋转度数：rotation、rotationX、rotationY
         public void setRotation(float rotation)
         public void setRotationX(float rotationX)
         public void setRotationY(float rotationY)

         //3、平移：translationX、translationY
         public void setTranslationX(float translationX)
         public void setTranslationY(float translationY)

         //缩放：scaleX、scaleY
         public void setScaleX(float scaleX)
         public void setScaleY(float scaleY)
         */
    }

    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                objectAnimator = ObjectAnimator.ofFloat(tvDemo, "rotationX", 0, 360, 0);
                objectAnimator.setDuration(2000);
                objectAnimator.start();
                break;
            case R.id.btn_2:
                objectAnimator = ObjectAnimator.ofFloat(tvDemo, "alpha", 0, 1, 0);
                objectAnimator.setDuration(2000);
                objectAnimator.start();
                break;
            case R.id.btn_3:
                objectAnimator = ObjectAnimator.ofFloat(tvDemo, "translationX", 0, 200, 0);
                objectAnimator.setDuration(2000);
                objectAnimator.start();
                break;
            case R.id.btn_4:
                objectAnimator = ObjectAnimator.ofFloat(tvDemo, "scaleX", 0, 3, 1);
                objectAnimator.setDuration(2000);
                objectAnimator.start();
                break;
        }
    }
}
