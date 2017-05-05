package cn.droidlover.xdroidmvp.sys.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.droidlover.xdroidmvp.mvp.XActivity;
import cn.droidlover.xdroidmvp.sys.R;
import cn.droidlover.xdroidmvp.sys.model.DevelopCustomerModel;
import cn.droidlover.xdroidmvp.sys.present.PDevelopCustomerForm;

public class DevelopCustomerFormActivity extends XActivity<PDevelopCustomerForm> {

    @BindView(R.id.edit_customer_customerName)
    EditText et_customerName;

    @BindView(R.id.edit_customer_sex)
    EditText et_sex;

    @BindView(R.id.edit_customer_mobilePhone)
    EditText et_mobilePhone;

    @BindView(R.id.btn_customer_save)
    TextView btn_save;

    DevelopCustomerModel.DevelopCustomer data;


    @Override
    public void initData(Bundle savedInstanceState) {
        String id = getIntent().getStringExtra("id");
        getP().queryOne(id);
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
        getP().save(data);
    }

    public void showData(DevelopCustomerModel.DevelopCustomer data) {
        this.data = data;
        et_customerName.setText(data.getCustomerName());
        et_sex.setText(data.getSex());
        et_mobilePhone.setText(data.getMobilePhone());
    }
}
