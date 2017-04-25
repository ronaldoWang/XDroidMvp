package cn.droidlover.xdroidmvp.sys.net;

import cn.droidlover.xdroidmvp.net.XApi;

/**
 * Created by wanglei on 2016/12/31.
 */

public class Api {
    public static final String API_BASE_URL = "http://gank.io/api/";
    public static final String API_USER = "http://jupai168.duapp.com/";

    private static GankService gankService;
    private static UserService userService;
    private static MainService mainService;

    public static GankService getGankService() {
        if (gankService == null) {
            synchronized (Api.class) {
                if (gankService == null) {
                    gankService = XApi.getInstance().getRetrofit(API_BASE_URL, true).create(GankService.class);
                }
            }
        }
        return gankService;
    }

    public static UserService getUserService() {
        if (userService == null) {
            synchronized (Api.class) {
                if (userService == null) {
                    userService = XApi.getInstance().getRetrofit(API_USER, true).create(UserService.class);
                }
            }
        }
        return userService;
    }

    public static MainService getMainService() {
        if (mainService == null) {
            synchronized (Api.class) {
                if (mainService == null) {
                    mainService = XApi.getInstance().getRetrofit(API_USER, true).create(MainService.class);
                }
            }
        }
        return mainService;
    }

}
