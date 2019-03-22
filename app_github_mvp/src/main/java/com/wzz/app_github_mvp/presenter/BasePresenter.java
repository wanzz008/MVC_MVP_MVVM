package com.wzz.app_github_mvp.presenter;

public interface BasePresenter<T> {

    void attach(T view);
    void detach();


}
