package com.wzz.app_mvp.view;

/**
 * Created by Administrator on 2019/3/4.
 */

public interface MainBaseView extends BaseView {
    void loginSuccess( String msg );
    void loginFailed( String msg );
}
