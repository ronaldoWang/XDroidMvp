package cn.droidlover.xdroidmvp.sys.ui;

import android.os.Bundle;

import java.util.List;

import cn.droidlover.xdroidmvp.mvp.XActivity;
import cn.droidlover.xdroidmvp.sys.R;
import cn.droidlover.xdroidmvp.sys.model.DevelopCustomerModel;
import cn.droidlover.xdroidmvp.sys.present.PDevelopCustomerForm;

public class DevelopCustomerFormActivity extends XActivity<PDevelopCustomerForm> {
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

    public void showData(List<DevelopCustomerModel.DevelopCustomer> data) {

    }
}
