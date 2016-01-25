package com.lbins.Jewelry.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.lbins.Jewelry.R;
import com.lbins.Jewelry.base.BaseActivity;

/**
 * Created by Administrator on 2016/1/25.
 */
public class MineActivity extends BaseActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_activity);
    }

    @Override
    public void onClick(View view) {

    }

    public void back(View v){
        finish();
    }

    public void clickQg(View view){
        //
        Intent intent = new Intent(MineActivity.this,  QiugouActivity.class);
        startActivity(intent);
    }
    public void clickGy(View view){
        //
        Intent intent = new Intent(MineActivity.this,  GongyingActivity.class);
        startActivity(intent);

    }
    public void clickJy(View view){
        //
    }
    public void clickCar(View view){
        //
        Intent intent = new Intent(MineActivity.this,  MineCartActivity.class);
        startActivity(intent);
    }
    public void clickMsg(View view){
        //
    }
}
