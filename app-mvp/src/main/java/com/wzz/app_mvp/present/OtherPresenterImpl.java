package com.wzz.app_mvp.present;

import com.wzz.app_mvp.model.User;
import com.wzz.app_mvp.view.OtherBaseView;

/**
 * Created by Administrator on 2019/3/4.
 */

public class OtherPresenterImpl implements OtherBasePresenter {


    private OtherBaseView view ;
    @Override
    public void upload(User user) {

    }

    @Override
    public void attach(OtherBaseView view) {
        this.view = view ;
    }

    @Override
    public void detach() {
        this.view = null ;
    }
}
