package cn.droidlover.xdroidmvp.sys.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;
import cn.droidlover.xdroidmvp.cache.SharedPref;
import cn.droidlover.xdroidmvp.mvp.XActivity;
import cn.droidlover.xdroidmvp.router.Router;
import cn.droidlover.xdroidmvp.sys.R;
import cn.droidlover.xdroidmvp.sys.model.UserModel;
import cn.droidlover.xdroidmvp.sys.present.PUser;

public class LoginActivity extends XActivity<PUser> {
    @BindView(R.id.login_edit_name)
    EditText et_userName;
    @BindView(R.id.login_edit_pwd)
    EditText et_userPwd;
    @BindView(R.id.login_cb_savepwd)
    CheckBox cb_save;
    @BindView(R.id.login_btn_login_online)
    TextView btn_login_online;
    @BindView(R.id.login_btn_login_unline)
    TextView btn_login_unline;
    SharedPref sharedPref;
    String userName = "";
    String userPwd = "";

    @Override
    public void initData(Bundle savedInstanceState) {
        sharedPref = SharedPref.getInstance(context);
        userName = sharedPref.getString("userName", "");
        userPwd = sharedPref.getString("userPwd", "");
        boolean isChecked = sharedPref.getBoolean("isChecked", false);
        et_userName.setText(userName);
        et_userPwd.setText(userPwd);
        cb_save.setChecked(isChecked);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public PUser newP() {
        return new PUser();
    }

    /**
     * 在线登录
     */
    @OnClick({R.id.login_btn_login_online, R.id.login_btn_login_unline})
    public void click(View v) {
        switch (v.getId()) {
            case R.id.login_btn_login_online:
                userName = et_userName.getText().toString();
                userPwd = et_userPwd.getText().toString();
                if (StringUtils.isTrimEmpty(userName)) {
                    ToastUtils.showLongToast("用户名不能为空");
                    return;
                }
                if (StringUtils.isTrimEmpty(userPwd)) {
                    ToastUtils.showLongToast("密码不能为空");
                    return;
                }
                getP().login(userName, userPwd);
                break;
            case R.id.login_btn_login_unline:
                break;
            default:
                break;
        }
    }

    /**
     * 登录
     *
     * @param user
     */
    public void doLogin(UserModel.User user) {
        if (cb_save.isChecked()) {
            sharedPref.putString("userName", userName);
            sharedPref.putString("userPwd", userPwd);
            sharedPref.putBoolean("isChecked", true);
        } else {
            sharedPref.putString("userName", "");
            sharedPref.putString("userPwd", "");
            sharedPref.putBoolean("isChecked", false);
        }
        sharedPref.put("curUser", user);//设置当前登陆人
        Router.newIntent(context)
                .to(MainActivity.class)    //to()指定目标context
                .launch();
        context.finish();
    }
}
