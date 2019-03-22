package com.wzz.app_github_mvp.presenter;

import com.wzz.app_github_mvp.model.GithubService;
import com.wzz.app_github_mvp.model.Repository;
import com.wzz.app_github_mvp.view.UserReposBaseView;

import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class UserReposPresenterImpl implements UserReposPresenter {

    private List<Repository> repositoryList ;
    private Subscription subscribe  ;

    private UserReposBaseView mView ;
    @Override
    public void attach(UserReposBaseView view) {
        mView = view ;
    }

    @Override
    public void loadSecondGithub(String userName) {

        mView.showProgress();

        subscribe = GithubService.Factory.create().publicRepositories(userName)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Repository>>() {

                    @Override
                    public void onCompleted() {
                        if (repositoryList != null) {
                            mView.showRecyclerView(repositoryList);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showErrorMessage();
                    }

                    @Override
                    public void onNext(List<Repository> repositories) {
                        repositoryList = repositories;
                    }
                });
    }


    @Override
    public void detach() {
        mView = null ;
        if (subscribe!=null){
            subscribe.unsubscribe();
        }
    }
}
