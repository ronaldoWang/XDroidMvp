package cn.droidlover.xdroidmvp.sys.present;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.ToastUtils;

import cn.droidlover.xdroidmvp.mvp.XPresent;
import cn.droidlover.xdroidmvp.net.ApiSubscriber;
import cn.droidlover.xdroidmvp.net.NetError;
import cn.droidlover.xdroidmvp.net.XApi;
import cn.droidlover.xdroidmvp.sys.model.UserModel;
import cn.droidlover.xdroidmvp.sys.net.Api;
import cn.droidlover.xdroidmvp.sys.ui.LoginActivity;

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
                        ToastUtils.showLongToast("登录失败");
                    }

                    @Override
                    public void onNext(UserModel userModel) {
                        if (userModel.isSuccess()) {
                            UserModel.User user = JSON.parseObject(JSONObject.toJSON(userModel.getData()).toString(), UserModel.User.class);
                            getV().doLogin(user);
                        } else {
                            ToastUtils.showLongToast(userModel.getMessage());
                        }
                    }
                });
    }
}
