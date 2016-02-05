package com.lbins.Jewelry.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.lbins.Jewelry.R;
import com.lbins.Jewelry.UniversityApplication;
import com.lbins.Jewelry.adapter.AnimateFirstDisplayListener;
import com.lbins.Jewelry.base.BaseActivity;
import com.lbins.Jewelry.base.InternetURL;
import com.lbins.Jewelry.data.EmpData;
import com.lbins.Jewelry.data.MemberObjData;
import com.lbins.Jewelry.module.MemberObj;
import com.lbins.Jewelry.util.StringUtil;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/2/5.
 */
public class MineActivity extends BaseActivity implements View.OnClickListener{

    private ImageView mine_head;
    private TextView nickname;
    private TextView tel;
    private TextView reg_num;
    private TextView reg_date;
    private RatingBar star_level;
    private TextView jifen;
    private TextView daijinquan;
    private TextView company_name;
    private TextView company_adddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_activity);

        mine_head = (ImageView) this.findViewById(R.id.mine_head);
        nickname = (TextView) this.findViewById(R.id.nickname);
        tel = (TextView) this.findViewById(R.id.tel);
        reg_num = (TextView) this.findViewById(R.id.reg_num);
        reg_date = (TextView) this.findViewById(R.id.reg_date);
        star_level = (RatingBar) this.findViewById(R.id.star_level);
        jifen = (TextView) this.findViewById(R.id.jifen);
        jifen = (TextView) this.findViewById(R.id.jifen);
        daijinquan = (TextView) this.findViewById(R.id.daijinquan);
        company_name = (TextView) this.findViewById(R.id.company_name);
        company_adddress = (TextView) this.findViewById(R.id.company_adddress);

        loginData();

    }

    @Override
    public void onClick(View view) {

    }

    public void back(View view){
        finish();
    }

    public void clickQg(View view){
       //
        Intent qgV = new Intent(MineActivity.this, QiugouActivity.class);
        startActivity(qgV);
    }

    public void clickGy(View view){
        //
        Intent qgV = new Intent(MineActivity.this, GongyingActivity.class);
        startActivity(qgV);
    }
    public void clickCar(View view){
        //
        Intent qgV = new Intent(MineActivity.this, MineCartActivity.class);
        startActivity(qgV);
    }

    public void clickJy(View view){
        //
//        Intent qgV = new Intent(MineActivity.this, MineCartActivity.class);
//        startActivity(qgV);
    }

    ImageLoader imageLoader = ImageLoader.getInstance();//图片加载类
    private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();


    MemberObj memberObj;
    void loginData(){
        StringRequest request = new StringRequest(
                Request.Method.POST,
                InternetURL.MEMBER__URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        if (StringUtil.isJson(s)) {
                            try {
                                JSONObject jo = new JSONObject(s);
                                String code =  jo.getString("code");
                                if(Integer.parseInt(code) == 200){
                                    MemberObjData data = getGson().fromJson(s, MemberObjData.class);
                                    memberObj = data.getData();
                                    initData();
                                }
                                else{
                                    Toast.makeText(MineActivity.this, jo.getString("msg"), Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        if (progressDialog != null) {
                            progressDialog.dismiss();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        if (progressDialog != null) {
                            progressDialog.dismiss();
                        }
                        Toast.makeText(MineActivity.this, R.string.get_data_error, Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("user_name", getGson().fromJson(getSp().getString("user_name", ""), String.class));
                params.put("access_token", getGson().fromJson(getSp().getString("access_token", ""), String.class));
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };
        getRequestQueue().add(request);
    }

    private void initData() {
        imageLoader.displayImage( memberObj.getCover(), mine_head, UniversityApplication.txOptions, animateFirstListener);
        nickname.setText(memberObj.getUser_name());
        tel.setText("联系电话：" + memberObj.getMobile());
        reg_num.setText("注册编号：" + memberObj.getRegister_num());
        reg_date.setText("注册日期：" + memberObj.getRegister_date());
        jifen.setText("会员积分：" + memberObj.getMember_points());
        daijinquan.setText("代金券："+memberObj.getProp());
        company_adddress.setText("公司地址："+memberObj.getCompany_address());
        company_name.setText("公司名称："+memberObj.getCompany_name());
        String lev = memberObj.getM_level()==null?"":memberObj.getM_level();
        if(StringUtil.isNullOrEmpty(lev)){
            lev = "0.0";
        }
        star_level.setRating(Float.valueOf(lev));

    }

}
