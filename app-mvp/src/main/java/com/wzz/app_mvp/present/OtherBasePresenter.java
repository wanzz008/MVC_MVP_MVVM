package com.wzz.app_mvp.present;

import com.wzz.app_mvp.model.User;
import com.wzz.app_mvp.view.OtherBaseView;

/**
 * Created by Administrator on 2019/3/4.
 */

public interface OtherBasePresenter extends BasePresenter<OtherBaseView> {

    void  upload(User user); // 上传数据

}
