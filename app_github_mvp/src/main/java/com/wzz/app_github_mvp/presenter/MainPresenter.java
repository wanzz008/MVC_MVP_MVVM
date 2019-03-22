package com.wzz.app_github_mvp.presenter;

import com.wzz.app_github_mvp.view.MainBaseView;

public interface MainPresenter extends BasePresenter<MainBaseView>{

    void loadGithub();
}
