package com.example.yhy.retrofix_rejava.view;

/**
 * Created by yhy on 2016/8/26.
 */
public interface ILoginView {
     void onClearText();
     void onLoginResult(Boolean result, int code);
     void onSetProgressBarVisibility(int visibility);
}
