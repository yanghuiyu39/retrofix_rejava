package com.example.yhy.retrofix_rejava.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.yhy.retrofix_rejava.model.IUser;
import com.example.yhy.retrofix_rejava.model.IUserModle;
import com.example.yhy.retrofix_rejava.view.ILoginView;


/**
 * Created by yhy on 2016/8/26.
 */
public class LoginPresenterCompl implements ILoginPresenter {

    IUser user;
    ILoginView mILoginView;
    Handler handler;

    public LoginPresenterCompl (ILoginView iLoginView){
        this.mILoginView=iLoginView;
        initUser();
        handler=new Handler(Looper.getMainLooper());
    }
    @Override
    public void clear() {
        mILoginView.onClearText();
    }

    @Override
    public void doLogin(String name, String pwd) {
        Boolean isLoginSuccess = true;
        final int code = user.checkUserValidity(name,pwd);
        if (code!=0) isLoginSuccess = false;
        final Boolean result = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mILoginView.onLoginResult(result, code);
            }
        }, 3000);

    }

    @Override
    public void setProgressBarVisiblity(int visiblity) {
        mILoginView.onSetProgressBarVisibility(visiblity);
    }

    private void initUser(){
        user = new IUserModle();
    }
}
