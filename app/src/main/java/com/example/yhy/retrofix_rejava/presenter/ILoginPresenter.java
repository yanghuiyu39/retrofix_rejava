package com.example.yhy.retrofix_rejava.presenter;

/**
 * Created by yhy on 2016/8/26.
 */
public interface ILoginPresenter {
    void clear();
    void doLogin(String name,String pwd);
    void setProgressBarVisiblity(int visiblity);
}
