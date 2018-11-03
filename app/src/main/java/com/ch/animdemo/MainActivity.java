package com.ch.animdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.ch.animdemo.base.BaseActivity;
import com.ch.animdemo.object.ObjectActivity;
import com.ch.animdemo.value.ValueActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_base)
    AppCompatButton btnBase;
    @BindView(R.id.btn_value)
    AppCompatButton btnValue;
    @BindView(R.id.btn_obj)
    AppCompatButton btnObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_base, R.id.btn_value, R.id.btn_obj})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_base:
                startActivity(new Intent(MainActivity.this, BaseActivity.class));
                break;
            case R.id.btn_value:
                startActivity(new Intent(MainActivity.this, ValueActivity.class));
                break;
            case R.id.btn_obj:
                startActivity(new Intent(MainActivity.this, ObjectActivity.class));
                break;
        }
    }
}
