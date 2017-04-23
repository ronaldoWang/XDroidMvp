package cn.droidlover.xdroidmvp.demo.net;

import cn.droidlover.xdroidmvp.demo.model.UserModel;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ronaldo on 2017/4/22.
 */

public interface UserService {

    @GET("frontapi/appuser/doLogin")
    Flowable<UserModel> login(@Query("loginName") String userName,
                              @Query("password") String userPwd);
}
