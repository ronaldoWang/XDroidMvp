package cn.droidlover.xdroidmvp.sys.present;

import com.blankj.utilcode.util.ToastUtils;

import cn.droidlover.xdroidmvp.mvp.XPresent;
import cn.droidlover.xdroidmvp.net.ApiSubscriber;
import cn.droidlover.xdroidmvp.net.NetError;
import cn.droidlover.xdroidmvp.net.XApi;
import cn.droidlover.xdroidmvp.sys.model.UserModel;
import cn.droidlover.xdroidmvp.sys.net.Api;
import cn.droidlover.xdroidmvp.sys.ui.LoginActivity;
import cn.droidlover.xdroidmvp.sys.widget.LoadingDialog;

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
                        LoadingDialog.cancelDialogForLoading();
                        ToastUtils.showLongToast("登录失败");
                    }

                    @Override
                    public void onNext(UserModel userModel) {
                        LoadingDialog.cancelDialogForLoading();
                        if (userModel.isSuccess()) {
                            getV().doLogin(userModel.getData());
                        } else {
                            ToastUtils.showLongToast(userModel.getMessage());
                        }
                    }
                });
    }
}
