package cn.droidlover.xdroidmvp.sys.present;

import cn.droidlover.xdroidmvp.sys.model.UserModel;
import cn.droidlover.xdroidmvp.sys.net.Api;
import cn.droidlover.xdroidmvp.sys.ui.LoginActivity;
import cn.droidlover.xdroidmvp.log.XLog;
import cn.droidlover.xdroidmvp.mvp.XPresent;
import cn.droidlover.xdroidmvp.net.ApiSubscriber;
import cn.droidlover.xdroidmvp.net.NetError;
import cn.droidlover.xdroidmvp.net.XApi;

/**
 * Created by ronaldo on 2017/4/21.
 */

public class PUser extends XPresent<LoginActivity> {

    public void login(final String userName, final String userPwd) {
        Api.getUserService().login(userName, userPwd)
                .compose(XApi.<UserModel>getApiTransformer())
                .compose(XApi.<UserModel>getScheduler())
                .compose(getV().<UserModel>bindToLifecycle())
                .subscribe(new ApiSubscriber<UserModel>() {
                    @Override
                    protected void onFail(NetError error) {

                    }

                    @Override
                    public void onNext(UserModel userModel) {
                        XLog.d("123");
                    }
                });
    }
}
