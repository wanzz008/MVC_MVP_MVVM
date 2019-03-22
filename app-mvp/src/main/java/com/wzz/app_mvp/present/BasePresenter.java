package com.wzz.app_mvp.present;

/**
 * Created by Administrator on 2019/3/4.
 */


/**
 * 用泛型 可以拓展
 * @param <T>
 */
public interface BasePresenter<T> {
    void attach( T view );
    void detach();
}
