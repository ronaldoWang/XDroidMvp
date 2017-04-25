package cn.droidlover.xdroidmvp.sys.model;

import cn.droidlover.xdroidmvp.net.IModel;

/**
 * Created by haoxi on 2017/4/25.
 */

public class DevelopCustomerModel extends BaseModel<DevelopCustomerModel.DevelopCustomer> implements IModel {

    public static class DevelopCustomer {
        private String customerName; // 客户名称
        private String customerNo; // 客户编号
        private String sex; // 性别
        private String mobilePhone; // 手机

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getCustomerNo() {
            return customerNo;
        }

        public void setCustomerNo(String customerNo) {
            this.customerNo = customerNo;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getMobilePhone() {
            return mobilePhone;
        }

        public void setMobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
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
