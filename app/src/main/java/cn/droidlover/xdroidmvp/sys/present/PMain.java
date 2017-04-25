package cn.droidlover.xdroidmvp.sys.present;

import cn.droidlover.xdroidmvp.mvp.XPresent;
import cn.droidlover.xdroidmvp.net.ApiSubscriber;
import cn.droidlover.xdroidmvp.net.NetError;
import cn.droidlover.xdroidmvp.net.XApi;
import cn.droidlover.xdroidmvp.sys.model.DevelopCustomerModel;
import cn.droidlover.xdroidmvp.sys.net.Api;
import cn.droidlover.xdroidmvp.sys.ui.MainFragment;

/**
 * Created by haoxi on 2017/4/25.
 */

public class PMain extends XPresent<MainFragment> {
    protected static final int PAGE_SIZE = 10;

    public void loadData(final int page) {
        Api.getMainService().query(PAGE_SIZE, page)
                .compose(XApi.<DevelopCustomerModel>getApiTransformer())
                .compose(XApi.<DevelopCustomerModel>getScheduler())
                .compose(getV().<DevelopCustomerModel>bindToLifecycle())
                .subscribe(new ApiSubscriber<DevelopCustomerModel>() {
                    @Override
                    protected void onFail(NetError error) {

                    }

                    @Override
                    public void onNext(DevelopCustomerModel developCustomerModel) {
                        System.out.println("==========");
                    }
                });
    }
}
