package com.lbins.Jewelry.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.lbins.Jewelry.R;
import com.lbins.Jewelry.adapter.ChangyonggyAdapter;
import com.lbins.Jewelry.adapter.ChengpinLiebiaoAdapter;
import com.lbins.Jewelry.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/25.
 */
public class TwoFragment extends BaseFragment implements View.OnClickListener {

    private List<String> lists = new ArrayList<String>();
    private ListView lstv ;
    private ChengpinLiebiaoAdapter adapter ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.two_fragment, null);

        lstv = (ListView) view.findViewById(R.id.lstv);
        lists.add("制图");
        lists.add("制版");
        lists.add("铸造");
        lists.add("打磨");
        lists.add("抛光");
        adapter = new ChengpinLiebiaoAdapter(lists, getActivity());
        lstv.setAdapter(adapter);
        return view;
    }


    @Override
    public void onClick(View view) {

    }
}
