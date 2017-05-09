package cn.droidlover.xdroidmvp.sys.ui;

import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.TimeUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.droidlover.xdroidmvp.mvp.XActivity;
import cn.droidlover.xdroidmvp.sys.R;
import cn.droidlover.xdroidmvp.sys.db.OrmLiteManager;
import cn.droidlover.xdroidmvp.sys.model.DevelopCustomerModel;
import cn.droidlover.xdroidmvp.sys.present.PDevelopCustomerForm;
import cn.droidlover.xstatecontroller.XStateController;

public class DevelopCustomerFormActivity extends XActivity<PDevelopCustomerForm> {

    @BindView(R.id.edit_customer_customerName)
    EditText et_customerName;

    @BindView(R.id.edit_customer_sex)
    EditText et_sex;

    @BindView(R.id.edit_customer_mobilePhone)
    EditText et_mobilePhone;

    @BindView(R.id.edit_customer_summary)
    EditText et_summary;

    @BindView(R.id.edit_customer_type)
    EditText et_type;

    @BindView(R.id.edit_customer_email)
    EditText et_email;

    @BindView(R.id.edit_customer_recentDate)
    EditText et_recentDate;

    @BindView(R.id.edit_customer_recentResult)
    EditText et_recentResult;

    @BindView(R.id.btn_customer_save)
    TextView btn_save;

    @BindView(R.id.contentLayout)
    XStateController controller;

    DevelopCustomerModel.DevelopCustomer data;


    @Override
    public void initData(Bundle savedInstanceState) {
        initContentLayout();
        controller.showLoading();
        String id = getIntent().getStringExtra("id");
        getP().queryOne(id);
    }

    private void initContentLayout() {
        controller.loadingView(View.inflate(context, R.layout.view_loading, null));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_developcustomerform;
    }

    @Override
    public PDevelopCustomerForm newP() {
        return new PDevelopCustomerForm();
    }

    @OnClick(R.id.btn_customer_save)
    public void click(View v) {
        switch (v.getId()) {
            case R.id.btn_customer_save:
                doSave();
                break;
        }
    }

    private void doSave() {
        data.setCustomerName(et_customerName.getText().toString());
        data.setMobilePhone(et_mobilePhone.getText().toString());
        data.setSex(et_sex.getText().toString());
        data.setSummary(et_summary.getText().toString());
        data.setType(et_type.getText().toString());
        data.setEmail(et_email.getText().toString());
        data.setRecentDate(TimeUtils.string2Date(et_recentDate.getText().toString()));
        data.setRecentResult(et_recentResult.getText().toString());
        getP().save(data);
    }

    public void showData(DevelopCustomerModel.DevelopCustomer data) {
        this.data = data;
        et_customerName.setText(data.getCustomerName());
        et_mobilePhone.setText(data.getMobilePhone());
        et_sex.setText(data.getSex());
        et_summary.setText(data.getSummary());
        et_type.setText(data.getType());
        et_email.setText(data.getEmail());
        et_recentDate.setText(null == data.getRecentDate() ? "" : TimeUtils.date2String(data.getRecentDate()));
        et_recentResult.setText(data.getRecentResult());
        controller.showContent();
    }
}
