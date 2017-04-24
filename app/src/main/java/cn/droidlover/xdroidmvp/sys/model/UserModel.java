package cn.droidlover.xdroidmvp.sys.model;

import java.util.Date;

import cn.droidlover.xdroidmvp.net.IModel;

/**
 * Created by ronaldo on 2017/4/22.
 */

public class UserModel extends BaseModel implements IModel {
    public static class User {
        private String loginName;

        private Date createDate;

        public Date getCreateDate() {
            return createDate;
        }

        public void setCreateDate(Date createDate) {
            this.createDate = createDate;
        }

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }
    }


    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public boolean isAuthError() {
        return false;
    }

    @Override
    public boolean isBizError() {
        return false;
    }

    @Override
    public String getErrorMsg() {
        return null;
    }
}
