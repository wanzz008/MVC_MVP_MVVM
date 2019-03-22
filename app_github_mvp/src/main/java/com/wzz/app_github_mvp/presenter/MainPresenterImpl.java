package com.wzz.app_github_mvp.presenter;

import com.wzz.app_github_mvp.model.GithubService;
import com.wzz.app_github_mvp.model.Repo;
import com.wzz.app_github_mvp.view.MainBaseView;

import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainPresenterImpl implements MainPresenter {

    MainBaseView mBaseView ;

    @Override
    public void attach(MainBaseView view) {
        this.mBaseView = view;
    }

    /** 销毁的时候，把绑定也解除 */
    @Override
    public void detach() {
        this.mBaseView = null ;
        if ( subscribe != null ){
            subscribe.unsubscribe();
        }

    }
    private List<Repo> repoList ;
    private Subscription subscribe ;

    @Override
    public void loadGithub() {
        mBaseView.showProgress();

        String url = "http://github.laowch.com/json/java_daily" ;
        GithubService githubService = GithubService.Factory.create();
        subscribe = githubService.javaRepositories(url)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Repo>>() {
                    @Override
                    public void onCompleted() {
                        if (repoList != null) {
                            mBaseView.showRecyclerView(repoList);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Repo> repos) {
                        repoList = repos;
                    }
                });
    }
}
