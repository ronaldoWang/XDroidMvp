package cn.droidlover.xdroidmvp.sys.net;

import java.io.File;
import java.util.Map;

import cn.droidlover.xdroidmvp.sys.model.DevelopCustomerModel;
import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by ronaldo on 2017/4/22.
 */

public interface DevelopCustomerService {

    @GET("frontapi/developCustomer/queryList")
    Flowable<DevelopCustomerModel> query(@Query("pageNo") int pageNum);

    @GET("frontapi/developCustomer/queryOne")
    Flowable<DevelopCustomerModel> queryOne(@Query("customerNo") String id);

    @Multipart
    @POST("frontapi/developCustomer/save")
    Flowable<DevelopCustomerModel> save(@QueryMap Map<String, String> map, @Part("aFile") File file);
}
