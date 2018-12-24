package com.ch.animdemo.demo.transition;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.ch.animdemo.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Img2Activity extends AppCompatActivity {

    @BindView(R.id.rv_preview)
    RecyclerView rvPreview;
    private List<String> imgList;
    private int currentPosition;
    private int enterPosition;

    public static final String IMG_KEY = "IMG_KEY";
    public static final String IMG_POSITION = "IMG_POSITION";
    public static final String IMG_CURRENT_POSITION = "IMG_CURRENT_POSITION";
    private PagerSnapHelper snapHelper;
    private ImgAdapter imgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img2);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        // 延迟共享动画的执行
        postponeEnterTransition();

        imgList = getIntent().getStringArrayListExtra(IMG_KEY);
        enterPosition = getIntent().getIntExtra(IMG_POSITION, 0);
        currentPosition = enterPosition;


        snapHelper = new PagerSnapHelper() {
            @Override
            public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
                currentPosition = super.findTargetSnapPosition(layoutManager, velocityX, velocityY);
                return currentPosition;
            }
        };
        snapHelper.attachToRecyclerView(rvPreview);


        imgAdapter = new ImgAdapter(imgList);
        rvPreview.setLayoutManager(new LinearLayoutManager(Img2Activity.this, LinearLayoutManager.HORIZONTAL, false));
        rvPreview.setAdapter(imgAdapter);

        imgAdapter.bindToRecyclerView(rvPreview);

        rvPreview.scrollToPosition(enterPosition);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (enterPosition != currentPosition) {
            //滑动过，需要刷新

            final View exitView = imgAdapter.getViewByPosition(currentPosition, R.id.iv_img);
            ActivityCompat.setEnterSharedElementCallback(this, new android.support.v4.app.SharedElementCallback() {
                @Override
                public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
                    names.clear();
                    sharedElements.clear();
                    names.add(ViewCompat.getTransitionName(exitView));
                    sharedElements.put(ViewCompat.getTransitionName(exitView), exitView);

                }
            });
        }
    }

    @Override
    public void finishAfterTransition() {
        Intent intent = new Intent();
        if (enterPosition == currentPosition) {
            //没有改变
            intent.putExtra(IMG_CURRENT_POSITION, -1);
        } else {
            intent.putExtra(IMG_CURRENT_POSITION, currentPosition);
        }
        setResult(RESULT_OK, intent);
        super.finishAfterTransition();
    }


    class ImgAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
        public ImgAdapter(List<String> list) {
            super(R.layout.item_img, list);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            ImageView iv_img = helper.getView(R.id.iv_img);
            Glide.with(mContext).load(item).listener(new RequestListener<Drawable>() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                    return false;
                }

                @Override
                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {

                    //图片加载完成的回调中，启动过渡动画
                    startPostponedEnterTransition();
                    return false;
                }
            }).into(iv_img);
        }

    }
}
