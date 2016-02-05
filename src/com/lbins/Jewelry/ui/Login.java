package com.lbins.Jewelry.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.lbins.Jewelry.MainActivity;
import com.lbins.Jewelry.R;
import com.lbins.Jewelry.base.BaseActivity;
import com.lbins.Jewelry.base.InternetURL;
import com.lbins.Jewelry.data.EmpData;
import com.lbins.Jewelry.module.Emp;
import com.lbins.Jewelry.util.StringUtil;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/1/23.
 */
public class Login extends BaseActivity implements View.OnClickListener {

    private EditText mobile;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mobile = (EditText) this.findViewById(R.id.mobile);
        password = (EditText) this.findViewById(R.id.password);
        this.findViewById(R.id.reg).setOnClickListener(this);
        this.findViewById(R.id.forget).setOnClickListener(this);

        if(!StringUtil.isNullOrEmpty(getGson().fromJson(getSp().getString("user_name", ""), String.class))){
            mobile.setText(getGson().fromJson(getSp().getString("user_name", ""), String.class));
        }
        if(!StringUtil.isNullOrEmpty(getGson().fromJson(getSp().getString("password", ""), String.class))){
            password.setText(getGson().fromJson(getSp().getString("password", ""), String.class));
        }
//        if(!StringUtil.isNullOrEmpty(getGson().fromJson(getSp().getString("user_name", ""), String.class)) &&!StringUtil.isNullOrEmpty(getGson().fromJson(getSp().getString("password", ""), String.class))){
//            loginData();
//        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.reg:
                //注册
                Intent regV = new Intent(Login.this, Regist.class);
                startActivity(regV);
                break;
            case R.id.forget:
                Intent forgetView = new Intent(Login.this, UpdatePwrActivity.class);
                startActivity(forgetView);
                break;
        }
    }

    public void login(View view){
        if(StringUtil.isNullOrEmpty(mobile.getText().toString())){
            showMsg(Login.this, "请输入手机号");
            return;
        }
        if(StringUtil.isNullOrEmpty(password.getText().toString())){
            showMsg(Login.this, "请输入密码");
            return;
        }
        progressDialog = new ProgressDialog(Login.this);
        progressDialog.setIndeterminate(true);
        progressDialog.show();
        loginData();
    }


    void loginData(){
        StringRequest request = new StringRequest(
                Request.Method.POST,
                InternetURL.LOGIN__URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        if (StringUtil.isJson(s)) {
                            try {
                                JSONObject jo = new JSONObject(s);
                                String code =  jo.getString("code");
                                if(Integer.parseInt(code) == 200){
                                    EmpData data = getGson().fromJson(s, EmpData.class);
                                    saveAccount(data.getData());
                                }
                                else{
                                    Toast.makeText(Login.this, jo.getString("msg"), Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(Login.this, "登陆失败", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("user_name", mobile.getText().toString());
                params.put("password", password.getText().toString());
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

    public void saveAccount(Emp emp) {
        // 登陆成功，保存用户名密码
        save("uid", emp.getUid());
        save("user_name", emp.getUser_name());
        save("password", password.getText().toString());
        save("sSalt", emp.getsSalt());
        save("fMoney", emp.getfMoney());
        save("fFreezeMoney", emp.getfFreezeMoney());
        save("sImage", emp.getsImage());
        save("sNickName", emp.getsNickName());
        save("sTrueName", emp.getsTrueName());
        save("sTel", emp.getsTel());
        save("nMemberPoints", emp.getnMemberPoints());
        save("fLng", emp.getfLng());
        save("fLat", emp.getfLat());
        save("nIsDel", emp.getnIsDel());
        save("nRegisterDate", emp.getnRegisterDate());
        save("nUpdateDate", emp.getnUpdateDate());
        save("access_token", emp.getAccess_token());

        save("isLogin", "1");//1已经登录了  0未登录

//        Intent intent = new Intent("login_success");
//        Login.this.sendBroadcast(intent);

        Intent intent  =  new Intent(Login.this, MainActivity.class);
        startActivity(intent);
        finish();

    }

}
