package com.wzz.app_mvp.present;

import com.wzz.app_mvp.model.User;
import com.wzz.app_mvp.view.MainBaseView;


/**
 * Created by Administrator on 2019/3/4.
 */

public interface MainBasePresenter extends BasePresenter<MainBaseView> {

    void  login(User user);

}
