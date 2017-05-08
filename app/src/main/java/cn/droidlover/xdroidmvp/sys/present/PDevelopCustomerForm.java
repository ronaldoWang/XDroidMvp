package cn.droidlover.xdroidmvp.sys.present;

import android.os.Environment;

import com.blankj.utilcode.util.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import cn.droidlover.xdroidmvp.kit.Kits;
import cn.droidlover.xdroidmvp.mvp.XPresent;
import cn.droidlover.xdroidmvp.net.ApiSubscriber;
import cn.droidlover.xdroidmvp.net.NetError;
import cn.droidlover.xdroidmvp.net.XApi;
import cn.droidlover.xdroidmvp.sys.model.DevelopCustomerModel;
import cn.droidlover.xdroidmvp.sys.net.Api;
import cn.droidlover.xdroidmvp.sys.ui.DevelopCustomerFormActivity;

/**
 * Created by haoxi on 2017/4/25.
 */

public class PDevelopCustomerForm extends XPresent<DevelopCustomerFormActivity> {

    public void queryOne(final String id) {
        Api.getDevelopCustomerService().queryOne(id)
                .compose(XApi.<DevelopCustomerModel>getApiTransformer())
                .compose(XApi.<DevelopCustomerModel>getScheduler())
                .compose(getV().<DevelopCustomerModel>bindToLifecycle())
                .subscribe(new ApiSubscriber<DevelopCustomerModel>() {
                    @Override
                    protected void onFail(NetError error) {
                        System.out.println("==========");
                    }

                    @Override
                    public void onNext(DevelopCustomerModel developCustomerModel) {
                        if (developCustomerModel.isSuccess()) {
                            if (!developCustomerModel.getData().isEmpty()) {
                                getV().showData(developCustomerModel.getData().get(0));
                            }
                        } else {

                        }
                    }
                });
    }

    public void save(DevelopCustomerModel.DevelopCustomer data) {
        Map<String, String> map = new HashMap<>();
        map.put("customerName", data.getCustomerName());
        java.io.File file = new java.io.File(Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                + "/Filename.xml");
        try {
            file.createNewFile();
            FileUtils.writeFileFromIS(file, getV().getResources().getAssets().open("123.txt"), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Api.getDevelopCustomerService().save(map, file)
                .compose(XApi.<DevelopCustomerModel>getApiTransformer())
                .compose(XApi.<DevelopCustomerModel>getScheduler())
                .compose(getV().<DevelopCustomerModel>bindToLifecycle())
                .subscribe(new ApiSubscriber<DevelopCustomerModel>() {
                    @Override
                    protected void onFail(NetError error) {
                        System.out.println("==========");
                    }

                    @Override
                    public void onNext(DevelopCustomerModel developCustomerModel) {
                    }
                });
    }
}
