package com.lbins.Jewelry.ui;

import android.os.Bundle;
import android.view.View;
import com.lbins.Jewelry.R;
import com.lbins.Jewelry.base.BaseActivity;

/**
 * Created by Administrator on 2016/1/25.
 */
public class HelpActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_activity);
    }

    @Override
    public void onClick(View view) {

    }
    public void back(View view){finish();}
}
