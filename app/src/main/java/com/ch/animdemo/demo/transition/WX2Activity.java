package com.ch.animdemo.demo.transition;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ch.animdemo.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WX2Activity extends AppCompatActivity {


    @BindView(R.id.rv_wx2)
    RecyclerView rvWx2;
    private WxAdapter wxAdapter;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wx2);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        list = new ArrayList<>();
        list.add("http://img1.imgtn.bdimg.com/it/u=4206294871,879077254&fm=26&gp=0.jpg");
        list.add("http://img1.imgtn.bdimg.com/it/u=1901690610,3955011377&fm=200&gp=0.jpg");
        list.add("http://img3.imgtn.bdimg.com/it/u=1546158593,2358526642&fm=200&gp=0.jpg");
        list.add("http://img0.imgtn.bdimg.com/it/u=3792909229,2321547963&fm=200&gp=0.jpg");
        list.add("http://img4.imgtn.bdimg.com/it/u=1621655683,865218969&fm=200&gp=0.jpg");
        list.add("http://img5.imgtn.bdimg.com/it/u=4286838121,1364454560&fm=26&gp=0.jpg");
        list.add("http://img5.imgtn.bdimg.com/it/u=551944592,1654216059&fm=26&gp=0.jpg");
        list.add("http://img1.imgtn.bdimg.com/it/u=2550323596,2167297465&fm=200&gp=0.jpg");
        list.add("http://img4.imgtn.bdimg.com/it/u=952962361,1269259737&fm=26&gp=0.jpg");

        wxAdapter = new WxAdapter(list);
        rvWx2.setLayoutManager(new GridLayoutManager(WX2Activity.this, 3));
        rvWx2.setAdapter(wxAdapter);
        wxAdapter.bindToRecyclerView(rvWx2);


        wxAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ImageView iv = view.findViewById(R.id.iv_wx_img);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    share(iv, position);
                }
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void share(View view, int position) {
        Intent intent = new Intent(WX2Activity.this, Img2Activity.class);
        intent.putStringArrayListExtra(Img2Activity.IMG_KEY, list);
        intent.putExtra(Img2Activity.IMG_POSITION, position);
        Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(this, view, "share").toBundle();
        startActivity(intent, bundle);
    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        if (resultCode == RESULT_OK && data != null) {
            int exitPos = data.getIntExtra(Img2Activity.IMG_CURRENT_POSITION, -1);
            final View exitView = getExitView(exitPos);
            if (exitView != null) {
                ActivityCompat.setExitSharedElementCallback(this, new SharedElementCallback() {
                    @Override
                    public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
                        names.clear();
                        sharedElements.clear();
                        names.add(ViewCompat.getTransitionName(exitView));
                        sharedElements.put(Objects.requireNonNull(ViewCompat.getTransitionName(exitView)), exitView);
                        setExitSharedElementCallback(new SharedElementCallback() {
                        });
                    }
                });
            }
        }
    }


    private View getExitView(int position) {
        if (position == -1) {
            return null;
        }
        if (wxAdapter != null) {
            return wxAdapter.getViewByPosition(position, R.id.iv_wx_img);
        }
        return null;
    }

    class WxAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
        public WxAdapter(List<String> list) {
            super(R.layout.item_wx2, list);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            ImageView iv_img = helper.getView(R.id.iv_wx_img);
            Glide.with(mContext).load(item).apply(new RequestOptions().centerCrop()).into(iv_img);
        }


    }


}
