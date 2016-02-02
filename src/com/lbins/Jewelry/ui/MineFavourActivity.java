package com.lbins.Jewelry.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.lbins.Jewelry.R;
import com.lbins.Jewelry.adapter.FavourAdapter;
import com.lbins.Jewelry.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/25.
 */
public class MineFavourActivity extends BaseActivity implements View.OnClickListener {

    private TextView no_goods;
    private List<String> lists = new ArrayList<String>();
    private ListView lstv ;
    private FavourAdapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favour_activity);

        initView();
    }

    private void initView() {
        lists.add("");
        lists.add("");
        lists.add("");
        lists.add("");
        lists.add("");
        lists.add("");
        lists.add("");
        lists.add("");
        adapter = new FavourAdapter(lists, MineFavourActivity.this);
        lstv = (ListView) this.findViewById(R.id.lstv);
        no_goods = (TextView) this.findViewById(R.id.no_goods);
        lstv.setAdapter(adapter);
        no_goods.setVisibility(View.GONE);
        lstv.setVisibility(View.VISIBLE);
        lstv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent detailV = new Intent(MineFavourActivity.this, DetailProductActivity.class);
                startActivity(detailV);
            }
        });
    }

    @Override
    public void onClick(View view) {
    }

    public void back(View view){finish();}
}
