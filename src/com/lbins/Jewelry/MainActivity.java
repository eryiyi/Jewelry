package com.lbins.Jewelry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.lbins.Jewelry.base.BaseActivity;
import com.lbins.Jewelry.base.InternetURL;
import com.lbins.Jewelry.data.EmpData;
import com.lbins.Jewelry.ui.*;
import com.lbins.Jewelry.util.StringUtil;
import com.umeng.update.UmengUpdateAgent;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        UmengUpdateAgent.update(this);

        initView();

    }

    void initView(){
        this.findViewById(R.id.helpText).setOnClickListener(this);
        this.findViewById(R.id.mineFavour).setOnClickListener(this);
        this.findViewById(R.id.changyonggy).setOnClickListener(this);
        this.findViewById(R.id.shoushipj).setOnClickListener(this);
        this.findViewById(R.id.chengpin).setOnClickListener(this);
        this.findViewById(R.id.mine).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.helpText:
            {
                Intent helpV = new Intent(MainActivity.this, HelpActivity.class);
                startActivity(helpV);
            }
                break;
            case R.id.mineFavour:
            {
                Intent favourV = new Intent(MainActivity.this, MineFavourActivity.class);
                startActivity(favourV);
            }
                break;
            case R.id.changyonggy:
            {
                Intent favourV = new Intent(MainActivity.this, ChangyongGyActivity.class);
                startActivity(favourV);
            }
                break;
            case R.id.shoushipj:
            {
                Intent favourV = new Intent(MainActivity.this, ShoushiPjActivity.class);
                startActivity(favourV);
            }
                break;
            case R.id.chengpin:
            {
                Intent favourV = new Intent(MainActivity.this, ChengpinActivity.class);
                startActivity(favourV);
            }
                break;
            case R.id.mine:
            {
                Intent favourV = new Intent(MainActivity.this, MineActivity.class);
                startActivity(favourV);
            }
                break;


        }
    }




}
