package com.wzz.app_github_mvp.presenter;

import com.wzz.app_github_mvp.view.UserReposBaseView;

public interface UserReposPresenter extends BasePresenter<UserReposBaseView>{

    void loadSecondGithub(String username );
}
