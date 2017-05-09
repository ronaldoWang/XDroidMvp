package cn.droidlover.xdroidmvp.sys.present;

import com.blankj.utilcode.util.ToastUtils;

import cn.droidlover.xdroidmvp.mvp.XPresent;
import cn.droidlover.xdroidmvp.net.ApiSubscriber;
import cn.droidlover.xdroidmvp.net.NetError;
import cn.droidlover.xdroidmvp.net.XApi;
import cn.droidlover.xdroidmvp.router.Router;
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
                        ToastUtils.showShortToast(error.getMessage());
                    }

                    @Override
                    public void onNext(DevelopCustomerModel developCustomerModel) {
                        if (developCustomerModel.isSuccess()) {
                            if (!developCustomerModel.getData().isEmpty()) {
                                getV().showData(developCustomerModel.getData().get(0));
                            }
                        } else {
                            ToastUtils.showShortToast(developCustomerModel.getMessage());
                        }
                    }
                });
    }

    public void save(DevelopCustomerModel.DevelopCustomer data) {
//        java.io.File file = new java.io.File("/sdcard/Test/123.txt");
//        FileUtils.createOrExistsFile(file);
//        try {
//            FileUtils.writeFileFromIS(file, getV().getResources().getAssets().open("123.txt"), true);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(file.length());
//        RequestBody requestFile =
//                RequestBody.create(MediaType.parse("application/otcet-stream"), file);
//        MultipartBody.Part body =
//                MultipartBody.Part.createFormData("aFile", file.getName(), requestFile);
        Api.getDevelopCustomerService().save(data.getDataMap())
                .compose(XApi.<DevelopCustomerModel>getApiTransformer())
                .compose(XApi.<DevelopCustomerModel>getScheduler())
                .compose(getV().<DevelopCustomerModel>bindToLifecycle())
                .subscribe(new ApiSubscriber<DevelopCustomerModel>() {
                    @Override
                    protected void onFail(NetError error) {
                        ToastUtils.showShortToast(error.getMessage());
                    }

                    @Override
                    public void onNext(DevelopCustomerModel developCustomerModel) {
                        if (developCustomerModel.isSuccess()) {
                            ToastUtils.showShortToast(developCustomerModel.getMessage());
                            Router.pop(getV());
                        } else {
                            ToastUtils.showShortToast(developCustomerModel.getMessage());
                        }
                    }
                });
    }
}
