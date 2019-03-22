package com.wzz.app_mvp.present;

import android.text.TextUtils;

import com.wzz.app_mvp.model.User;
import com.wzz.app_mvp.view.MainBaseView;

/**
 * Created by Administrator on 2019/3/4.
 */

/**
 * MainActivity业务逻辑的具体实现
 */
public class MainPresenterImpl implements MainBasePresenter{

    public MainBaseView mBaseView ;

    @Override
    public void login(User user) {
        if (TextUtils.isEmpty(user.username) || TextUtils.isEmpty( user.pwd )){
            mBaseView.showToast( "用户名或密码不能为空！");
        }else {
            if ( user.username.equals("wzz") && user.pwd.equals("666")){
                mBaseView.loginSuccess( "登录成功！");
            }else {
                mBaseView.loginFailed( "登录失败！");
            }
        }
    }


//    @Override
//    public void attach(MainBaseView view) {
//        this.mBaseView = view ;
//    }


    @Override
    public void attach(MainBaseView view) {
        this.mBaseView = view ;
    }

    @Override
    public void detach() {
        this.mBaseView = null ;
    }
}
