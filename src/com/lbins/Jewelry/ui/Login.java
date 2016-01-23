package com.lbins.Jewelry.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.lbins.Jewelry.MainActivity;
import com.lbins.Jewelry.R;
import com.lbins.Jewelry.base.BaseActivity;

/**
 * Created by Administrator on 2016/1/23.
 */
public class Login extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        this.findViewById(R.id.reg).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.reg:
                //注册
                Intent regV = new Intent(Login.this, Regist.class);
                startActivity(regV);
                break;
        }
    }

    public void login(View view){
        //
        Intent intent  =  new Intent(Login.this, MainActivity.class);
        startActivity(intent);
    }
}
