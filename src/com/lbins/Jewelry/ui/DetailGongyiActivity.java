package com.lbins.Jewelry.ui;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.*;
import com.lbins.Jewelry.R;
import com.lbins.Jewelry.adapter.GongyiPicAdapter;
import com.lbins.Jewelry.adapter.GongyiVideoAdapter;
import com.lbins.Jewelry.adapter.ShoushipjAdapter;
import com.lbins.Jewelry.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/28.
 */
public class DetailGongyiActivity extends BaseActivity implements View.OnClickListener {
    private ViewPager viewPager;
    private ImageView imageView;
    private TextView textView1,textView2,textView3;
    private List<View> views;
    private int offset = 0;
    private int currIndex = 0;
    private int bmpW;
    private View view1,view2,view3;


    private List<Integer> lists = new ArrayList<Integer>();
    private GridView gridView ;
    private GridView gridView2 ;
    private ListView gridView3;
    private GongyiPicAdapter adapter ;
    private GongyiVideoAdapter adapterVideo ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_gongyi_activity);

        InitImageView();
        InitTextView();
        InitViewPager();

    }

    private void InitViewPager() {
        viewPager=(ViewPager) findViewById(R.id.vPager);
        views=new ArrayList<View>();
        LayoutInflater inflater=getLayoutInflater();
        view1=inflater.inflate(R.layout.gongyi_lay1, null);
        view2=inflater.inflate(R.layout.gongyi_lay2, null);
        view3=inflater.inflate(R.layout.gongyi_lay3, null);
        views.add(view1);
        views.add(view2);
        views.add(view3);
        viewPager.setAdapter(new MyViewPagerAdapter(views));
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new MyOnPageChangeListener());

        gridView = (GridView) view1.findViewById(R.id.gridView);
        gridView2 = (GridView) view2.findViewById(R.id.gridView);
        gridView3 = (ListView) view3.findViewById(R.id.lstv);

        lists.add(R.drawable.gy_pic_1);
        lists.add(R.drawable.gy_pic_2);
        lists.add(R.drawable.gy_pic_3);
        lists.add(R.drawable.gy_pic_4);
        lists.add(R.drawable.gy_pic_5);
        lists.add(R.drawable.gy_pic_6);
        lists.add(R.drawable.gy_pic_7);
        lists.add(R.drawable.gy_pic_8);
        lists.add(R.drawable.gy_pic_9);
        lists.add(R.drawable.gy_pic_10);
        lists.add(R.drawable.gy_pic_11);
        lists.add(R.drawable.gy_pic_12);
        adapter = new GongyiPicAdapter(lists, DetailGongyiActivity.this);
        adapterVideo = new GongyiVideoAdapter(lists, DetailGongyiActivity.this);

        gridView.setAdapter(adapter);
        gridView2.setAdapter(adapter);
        gridView3.setAdapter(adapterVideo);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DetailGongyiActivity.this, GongyiXiangjieActivity.class);
                startActivity(intent);
            }
        });
        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DetailGongyiActivity.this, GongyiXiangjieActivity.class);
                startActivity(intent);
            }
        });
        gridView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DetailGongyiActivity.this, GongyiXiangjieActivity.class);
                startActivity(intent);
            }
        });

    }


    private void InitTextView() {
        textView1 = (TextView) findViewById(R.id.text1);
        textView2 = (TextView) findViewById(R.id.text2);
        textView3 = (TextView) findViewById(R.id.text3);

        textView1.setOnClickListener(new MyOnClickListener(0));
        textView2.setOnClickListener(new MyOnClickListener(1));
        textView3.setOnClickListener(new MyOnClickListener(2));
    }



    private void InitImageView() {
        imageView= (ImageView) findViewById(R.id.cursor);
        bmpW = BitmapFactory.decodeResource(getResources(), R.drawable.a).getWidth();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        offset = (screenW / 3 - bmpW) / 2;
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        imageView.setImageMatrix(matrix);
    }

    @Override
    public void onClick(View view) {

    }


    private class MyOnClickListener implements View.OnClickListener {
        private int index=0;
        public MyOnClickListener(int i){
            index=i;
        }
        public void onClick(View v) {
            viewPager.setCurrentItem(index);
        }

    }

    public class MyViewPagerAdapter extends PagerAdapter {
        private List<View> mListViews;

        public MyViewPagerAdapter(List<View> mListViews) {
            this.mListViews = mListViews;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) 	{
            container.removeView(mListViews.get(position));
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mListViews.get(position), 0);
            return mListViews.get(position);
        }

        @Override
        public int getCount() {
            return  mListViews.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0==arg1;
        }
    }

    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        int one = offset * 2 + bmpW;
        int two = one * 2;
        public void onPageScrollStateChanged(int arg0) {


        }

        public void onPageScrolled(int arg0, float arg1, int arg2) {


        }

        public void onPageSelected(int arg0) {
            Animation animation = new TranslateAnimation(one*currIndex, one*arg0, 0, 0);
            currIndex = arg0;
            animation.setFillAfter(true);
            animation.setDuration(300);
            imageView.startAnimation(animation);
        }

    }
}
