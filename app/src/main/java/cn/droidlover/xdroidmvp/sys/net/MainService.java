package cn.droidlover.xdroidmvp.sys.net;

import cn.droidlover.xdroidmvp.sys.model.DevelopCustomerModel;
import cn.droidlover.xdroidmvp.sys.model.UserModel;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ronaldo on 2017/4/22.
 */

public interface MainService {

    @GET("frontapi/developCustomer/queryList")
    Flowable<DevelopCustomerModel> query(@Query("number") int pageSize,
                                         @Query("page") int pageNum);
}
