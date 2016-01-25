package com.lbins.Jewelry.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lbins.Jewelry.R;
import com.lbins.Jewelry.base.BaseFragment;

/**
 * Created by Administrator on 2016/1/25.
 */
public class OneFragment extends BaseFragment implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one_fragment, null);

        return view;
    }


    @Override
    public void onClick(View view) {

    }
}
