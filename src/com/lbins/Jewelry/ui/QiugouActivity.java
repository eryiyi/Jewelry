package com.lbins.Jewelry.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.lbins.Jewelry.R;
import com.lbins.Jewelry.adapter.ChangyonggyAdapter;
import com.lbins.Jewelry.adapter.QiugouAdapter;
import com.lbins.Jewelry.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/25.
 */
public class QiugouActivity extends BaseActivity implements View.OnClickListener {

    private TextView no_goods;
    private List<String> lists = new ArrayList<String>();
    private ListView lstv ;
    private QiugouAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qiugou_activity);

        initView();

    }


    private void initView() {
        lists.add("");
        lists.add("");
        lists.add("");
        lists.add("");
        lists.add("");
        adapter = new QiugouAdapter(lists, QiugouActivity.this);
        lstv = (ListView) this.findViewById(R.id.lstv);
        no_goods = (TextView) this.findViewById(R.id.no_goods);
        lstv.setAdapter(adapter);
        no_goods.setVisibility(View.GONE);
        lstv.setVisibility(View.VISIBLE);
    }


    @Override
    public void onClick(View view) {

    }

    public void back(View view){finish();}


}
