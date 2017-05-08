package cn.droidlover.xdroidmvp.sys.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.droidlover.xdroidmvp.net.IModel;

/**
 * Created by haoxi on 2017/4/25.
 */

public class DevelopCustomerModel extends BaseModel<List<DevelopCustomerModel.DevelopCustomer>> implements IModel {

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

        public Map<String, Object> getDataMap() {
            Map<String, Object> map = new HashMap<>();
            map.put("customerName", customerName);
            map.put("customerNo", customerNo);
            map.put("sex", sex);
            map.put("mobilePhone", mobilePhone);
            return map;
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
