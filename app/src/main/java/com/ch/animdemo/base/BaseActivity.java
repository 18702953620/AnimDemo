package com.ch.animdemo.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.ch.animdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 基础动画
 */
public class BaseActivity extends AppCompatActivity {

    @BindView(R.id.btn_scale)
    AppCompatButton btnScale;
    @BindView(R.id.btn_alpha)
    AppCompatButton btnAlpha;
    @BindView(R.id.btn_translate)
    AppCompatButton btnTranslate;
    @BindView(R.id.btn_rotate)
    AppCompatButton btnRotate;
    @BindView(R.id.btn_set)
    AppCompatButton btnSet;
    @BindView(R.id.btn_interploator)
    AppCompatButton btnInterploator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_scale, R.id.btn_alpha, R.id.btn_translate, R.id.btn_rotate, R.id.btn_set, R.id.btn_interploator})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_scale:
                startActivity(new Intent(BaseActivity.this, ScaleActivity.class));
                break;
            case R.id.btn_alpha:
                startActivity(new Intent(BaseActivity.this, AlphaActivity.class));
                break;
            case R.id.btn_translate:
                startActivity(new Intent(BaseActivity.this, TranslateActivity.class));
                break;
            case R.id.btn_rotate:
                startActivity(new Intent(BaseActivity.this, RotateActivity.class));
                break;
            case R.id.btn_set:
                startActivity(new Intent(BaseActivity.this, SetActivity.class));
                break;
            case R.id.btn_interploator:
                startActivity(new Intent(BaseActivity.this, InterpolatorActivity.class));
                break;
            default:
        }
    }
}
