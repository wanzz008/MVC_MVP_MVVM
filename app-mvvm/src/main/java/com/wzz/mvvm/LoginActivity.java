package com.wzz.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wzz.mvvm.databinding.ActivityLoginBinding;
import com.wzz.mvvm.viewmodel.LoginViewModel;

/**
 *
 * MVVM:
 *  Model代表基本的业务逻辑
 *  view显示内容
 *  viewmodel将前两者联系在一起
 *  添加配置：
 *  android {
 *      dataBinding{
 *         enabled = true
 *     }
 *  }
 * DataBinding：
 * 该工具可以将View和对象的一个Filed字段绑定，当Filed更新时，framework也会收到通知，然后view会自动更新
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /** 不再通过setContentView方式绑定视图 */
//        setContentView(R.layout.activity_main);

        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setViewModel(new LoginViewModel(this));

//        LoginViewModel viewModel = new LoginViewModel(this);
//        binding.setViewmodel(viewModel);


    }


}
