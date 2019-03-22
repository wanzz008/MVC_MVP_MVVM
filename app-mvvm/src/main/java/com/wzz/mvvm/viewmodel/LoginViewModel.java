package com.wzz.mvvm.viewmodel;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Administrator on 2019/3/4.
 */

/**
 *      <data>
 *         <variable name="viewModel"  type="com.wzz.mvvm.viewmodel.LoginViewModel"></variable>
 *     </data>
 */

public class LoginViewModel {

    public String name ;
    public String pwd ;

    public Context mContext ;
    public LoginViewModel(Context context){
        mContext = context ;
    }

    public TextWatcher nameChangedListener(){
      return  new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {

          }

          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {
                name = s.toString() ;
          }

          @Override
          public void afterTextChanged(Editable s) {

          }
      };
    }

    public TextWatcher pwdChangedListener(){
        return  new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                pwd = s.toString() ;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }

    public void login(View view){

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty( pwd )){
            Toast.makeText(mContext,"用户名或密码不能为空！", Toast.LENGTH_SHORT).show();
        }else {
            if ( name.equals("wzz") && pwd.equals("666")){
                Toast.makeText(mContext,"登录成功！", Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(mContext,"登录失败！", Toast.LENGTH_SHORT).show();
            }
        }

    }

}
