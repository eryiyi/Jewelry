package com.lbins.Jewelry.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import com.lbins.Jewelry.R;
import com.lbins.Jewelry.adapter.ChangyonggyAdapter;
import com.lbins.Jewelry.adapter.ShoushipjAdapter;
import com.lbins.Jewelry.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/25.
 */
public class ShoushiPjActivity extends BaseActivity implements View.OnClickListener {


    private List<String> lists = new ArrayList<String>();
    private GridView gridView ;
    private GridView gridView2 ;
    private ShoushipjAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoushipj_activity);
        initView();
    }

    private void initView() {
        lists.add("");
        lists.add("");
        lists.add("");
        lists.add("");
        lists.add("");
        lists.add("");
        adapter = new ShoushipjAdapter(lists, ShoushiPjActivity.this);
        gridView = (GridView) this.findViewById(R.id.gridView);
        gridView2 = (GridView) this.findViewById(R.id.gridView2);
        gridView.setAdapter(adapter);
        gridView2.setAdapter(adapter);

    }

    @Override
    public void onClick(View view) {
    }

    public void back(View view){finish();}
}
