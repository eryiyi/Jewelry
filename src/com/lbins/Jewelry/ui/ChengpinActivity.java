package com.lbins.Jewelry.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.lbins.Jewelry.R;
import com.lbins.Jewelry.adapter.ChangyonggyAdapter;
import com.lbins.Jewelry.base.BaseActivity;
import com.lbins.Jewelry.fragment.OneFragment;
import com.lbins.Jewelry.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/25.
 */
public class ChengpinActivity extends BaseActivity implements View.OnClickListener {


    private FragmentTransaction fragmentTransaction;
    private FragmentManager fm;

    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    //设置底部图标
    Resources res;

    private TextView oneBt;
    private TextView twoBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chengpin_activity);
        initView();

        res = getResources();
        fm = getSupportFragmentManager();
        initView();

        switchFragment(R.id.oneBtn);

    }

    private void initView() {
        oneBt = (TextView) this.findViewById(R.id.oneBtn);
        twoBtn = (TextView) this.findViewById(R.id.twoBtn);
        this.findViewById(R.id.oneBtn).setOnClickListener(this);
        this.findViewById(R.id.twoBtn).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
                switchFragment(view.getId());
    }

    public void back(View view){finish();}

    public void switchFragment(int id) {
        fragmentTransaction = fm.beginTransaction();
        hideFragments(fragmentTransaction);
        switch (id) {
            case R.id.oneBtn:
                if (oneFragment == null) {
                    oneFragment = new OneFragment();
                    fragmentTransaction.add(R.id.content_frame, oneFragment);
                } else {
                    fragmentTransaction.show(oneFragment);
                }
                oneBt.setBackground(res.getDrawable(R.drawable.blue_yuanjiao));
                twoBtn.setBackground(res.getDrawable(R.drawable.white_yuanjiao));

                oneBt.setTextColor(res.getColor(R.color.white));
                twoBtn.setTextColor(res.getColor(R.color.common_botton_bar_blue));
                break;
            case R.id.twoBtn:
                if (twoFragment == null) {
                    twoFragment = new TwoFragment();
                    fragmentTransaction.add(R.id.content_frame, twoFragment);
                } else {
                    fragmentTransaction.show(twoFragment);
                }

                oneBt.setBackground(res.getDrawable(R.drawable.white_yuanjiao));
                twoBtn.setBackground(res.getDrawable(R.drawable.blue_yuanjiao));
                oneBt.setTextColor(res.getColor(R.color.common_botton_bar_blue));
                twoBtn.setTextColor(res.getColor(R.color.white));
                break;
        }
        fragmentTransaction.commit();
    }

    private void hideFragments(FragmentTransaction ft) {
        if (oneFragment != null) {
            ft.hide(oneFragment);
        }
        if (twoFragment != null) {
            ft.hide(twoFragment);
        }
    }

}
