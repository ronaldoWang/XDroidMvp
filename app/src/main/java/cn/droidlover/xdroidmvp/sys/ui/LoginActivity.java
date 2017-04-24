package cn.droidlover.xdroidmvp.sys.ui;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

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
    EditText et_uname;
    @BindView(R.id.login_edit_pwd)
    EditText et_upwd;
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
        userName = sharedPref.getString("uname", "");
        userPwd = sharedPref.getString("upwd", "");
        boolean isChecked = sharedPref.getBoolean("isChecked", false);
        et_uname.setText(userName);
        et_upwd.setText(userPwd);
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

    @OnClick(R.id.login_btn_login_online)
    public void loginOnline() {
        userName = et_uname.getText().toString();
        userPwd = et_upwd.getText().toString();

        getP().login(userName, userPwd);
    }

    public void doLogin(UserModel.User user) {
        if (cb_save.isChecked()) {
            sharedPref.putString("uname", userName);
            sharedPref.putString("upwd", userPwd);
            sharedPref.putBoolean("isChecked", true);
        } else {
            sharedPref.putString("uname", "");
            sharedPref.putString("upwd", "");
            sharedPref.putBoolean("isChecked", false);
        }
        Router.newIntent(context)
                .to(MainActivity.class)    //to()指定目标context
                .launch();
        context.finish();
    }
}
